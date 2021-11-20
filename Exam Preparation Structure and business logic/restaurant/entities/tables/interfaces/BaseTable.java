package restaurant.entities.tables.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {

    private ArrayList<HealthyFood> orderedHealthyFood;
    private ArrayList<Beverages> orderedBeverages;
    private ArrayList<HealthyFood> healthyFood;
    private ArrayList<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.orderedHealthyFood = new ArrayList<>();
        this.orderedBeverages = new ArrayList<>();
        this.allPeople = 0;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.allPeople = this.pricePerPerson * numberOfPeople;
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.orderedHealthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        this.allPeople = calculateBill();
        return allPeople;
    }

    private double calculateBill() {
        double sum = this.allPeople;

        sum += this.orderedHealthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        sum += this.orderedBeverages.stream().mapToDouble(Beverages::getPrice).sum();

        return sum;
    }

    @Override
    public void clear() {
        this.orderedBeverages.clear();
        this.orderedHealthyFood.clear();

        this.isReservedTable = false;

        this.numberOfPeople = 0;
        this.allPeople = 0;
    }

    @Override
    public String tableInformation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Table - %d%n", this.number))
                .append(String.format("Size - %d%n", this.size))
                .append(String.format("Type - %s%n", this.getClass().getSimpleName()))
                .append(String.format("All price - %.2f", this.pricePerPerson));

        return stringBuilder.toString();
    }
}
