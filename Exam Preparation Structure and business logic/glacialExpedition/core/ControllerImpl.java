package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int statesExplored;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {

        checkType(type);
        Explorer explorer = createExplorer(type, explorerName);

        this.explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    private Explorer createExplorer(String type, String explorerName) {
        switch (type) {
            case "AnimalExplorer":
                return new AnimalExplorer(explorerName);
            case "NaturalExplorer":
                return new NaturalExplorer(explorerName);
        }
        return new GlacierExplorer(explorerName);
    }

    private void checkType(String type) {
        if (!type.equals("AnimalExplorer") && !type.equals("NaturalExplorer") && !type.equals("GlacierExplorer")) {
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);

        Arrays.stream(exhibits).forEach(e -> state.getExhibits().add(e));

        this.stateRepository.add(state);

        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorerToRetire = this.explorerRepository.byName(explorerName);

        if (explorerToRetire == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        this.explorerRepository.remove(explorerToRetire);
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State stateToExplore = this.stateRepository.byName(stateName);
        List<Explorer> explorers = this.explorerRepository.getCollection().stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());

        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        MissionImpl mission = new MissionImpl();
        mission.explore(stateToExplore, explorers);
        statesExplored++;
        //this.stateRepository.remove(stateToExplore);

        String output = String.format(STATE_EXPLORER, stateName, MissionImpl.retiredExplorers);
        MissionImpl.retiredExplorers = 0;
        return output;
    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(FINAL_STATE_EXPLORED, statesExplored))
                .append(System.lineSeparator())
                .append(FINAL_EXPLORER_INFO)
                .append(System.lineSeparator());

        this.explorerRepository.getCollection().forEach(e -> {
            result.append(String.format(FINAL_EXPLORER_NAME, e.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(FINAL_EXPLORER_ENERGY, e.getEnergy()))
                    .append(System.lineSeparator())
                    .append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,
                            e.getSuitcase().getExhibits().isEmpty()
                            ? "None"
                            : String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, e.getSuitcase().getExhibits())))
                    .append(System.lineSeparator());
        });

        return result.toString().trim();
    }
}
