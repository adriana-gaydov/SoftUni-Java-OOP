package restaurant.core;

import restaurant.common.enums.BeveragesType;
import restaurant.common.enums.HealthyFoodType;
import restaurant.common.enums.TableType;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
    this.healthFoodRepository = new HealthFoodRepositoryImpl();
    this.beverageRepository = new BeverageRepositoryImpl();
    this.tableRepository = new TableRepositoryImpl();
    this.totalMoney = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood healthyFood = createHealthyFood(type, price, name);

        HealthyFood healthyFoodToAdd = this.healthFoodRepository.foodByName(name);

        if (healthyFoodToAdd != null) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }

        this.healthFoodRepository.add(healthyFood);
        return String.format(FOOD_ADDED, name);
    }

    private HealthyFood createHealthyFood(String type, double price, String name) {
        if (type.equals(HealthyFoodType.Salad.toString())) {
            return new Salad(name, price);
        }
        return new VeganBiscuits(name, price);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        Beverages beverage = createBeverage(type, counter, brand, name);

        if (this.beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }

        this.beverageRepository.add(beverage);
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    private Beverages createBeverage(String type, int counter, String brand, String name) {
        if (type.equals(BeveragesType.Fresh.toString())) {
            return new Fresh(name, counter, brand);
        }
        return new Smoothie(name, counter, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = createTable(type, tableNumber, capacity);

        if (this.tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        this.tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    private Table createTable(String type, int tableNumber, int capacity) {
        if (type.equals(TableType.Indoors.toString())) {
            return new Indoors(tableNumber, capacity);
        }
        return new InGarden(tableNumber, capacity);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = this.tableRepository.getAllEntities().stream()
                .filter(e -> e.getSize() >= numberOfPeople && !e.isReservedTable())
                .findFirst().orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = this.tableRepository.byNumber(tableNumber);
        HealthyFood healthyFood = this.healthFoodRepository.foodByName(healthyFoodName);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (healthyFood == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(healthyFood);
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Beverages beverages = this.beverageRepository.beverageByName(name, brand);
        Table table = this.tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (beverages == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverages);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = this.tableRepository.byNumber(tableNumber);

        double bill = table.bill();
        this.totalMoney += bill;
        table.clear();

        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, this.totalMoney);
    }
}
