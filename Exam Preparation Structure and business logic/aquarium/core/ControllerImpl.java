package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        if (!aquariumType.equals("FreshwaterAquarium") && !aquariumType.equals("SaltwaterAquarium")) {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        if (aquariumType.equals("FreshwaterAquarium")) {
            this.aquariums.put(aquariumName, new FreshwaterAquarium(aquariumName));
        } else {
            this.aquariums.put(aquariumName, new SaltwaterAquarium(aquariumName));
        }

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        if (!type.equals("Ornament") && !type.equals("Plant")) {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        if (type.equals("Ornament")) {
            this.decorations.add(new Ornament());
        } else {
            this.decorations.add(new Plant());
        }

        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decorationToInsert = this.decorations.findByType(decorationType);

        if (decorationToInsert == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        Aquarium aquarium = this.aquariums.get(aquariumName);
        aquarium.addDecoration(decorationToInsert);
        this.decorations.remove(decorationToInsert);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        if (!fishType.equals("FreshwaterFish") && !fishType.equals("SaltwaterFish")) {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquarium = this.aquariums.get(aquariumName);
        String aquariumType = aquarium.getClass().getSimpleName().replace("Aquarium", "Fish");

        if (!aquariumType.equals(fishType)) {
            return WATER_NOT_SUITABLE;
        }

        try {
            if (fishType.equals("FreshwaterFish")) {
                aquarium.addFish(new FreshwaterFish(fishName, fishSpecies, price));
            } else {
                aquarium.addFish(new SaltwaterFish(fishName, fishSpecies, price));
            }
        } catch (IllegalStateException e) {
            return e.getMessage();
        }

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        aquarium.feed();

        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.get(aquariumName);

        double fishPrices = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationPrices = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();

        return String.format(VALUE_AQUARIUM, aquariumName, fishPrices + decorationPrices);
    }

    @Override
    public String report() {
        return this.aquariums.values().stream().map(Aquarium::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
