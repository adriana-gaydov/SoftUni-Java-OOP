package restaurant.entities.tables.interfaces;

public class Indoors extends BaseTable {
    private static final double DEFAULT_PRICE_PER_PERSON = 3.50;

    public Indoors(int number, int size) {
        super(number, size, DEFAULT_PRICE_PER_PERSON);
    }
}
