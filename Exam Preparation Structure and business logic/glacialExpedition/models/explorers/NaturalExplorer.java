package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double INITIAL_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        super.DECREASE_SEARCH = 7;
        super.search();
    }
}
