package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    public static int retiredExplorers;
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        //explorers = explorers.stream().filter(e -> e.getEnergy() < 0).collect(Collectors.toList());

        Collection<String> exhibits = state.getExhibits();

        HashSet<Explorer> explorersToRetire = new HashSet<>();

        for (Explorer e : explorers) {
            HashSet<String> exhibitsToRemove = new HashSet<>();

            if (exhibits.isEmpty()) {
                break;
            }

            for (String exhibit : exhibits) {
                e.search();
                e.getSuitcase().getExhibits().add(exhibit);
                exhibitsToRemove.add(exhibit);

                if (!e.canSearch()) {
                    explorersToRetire.add(e);
                    retiredExplorers++;
                    break;
                }
            }

            exhibits.removeAll(exhibitsToRemove);
        }

        explorers.removeAll(explorersToRetire);
    }
}
