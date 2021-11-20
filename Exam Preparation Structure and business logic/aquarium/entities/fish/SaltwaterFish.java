package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    private static final int DEFAULT_SIZE = 5;
    private static final int DEFAULT_EAT = 2;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        this.setSize(this.getSize() + DEFAULT_EAT);
    }
}
