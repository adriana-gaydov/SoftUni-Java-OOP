package PizzaCalories;

public enum ToppingType {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);

    private double modifier;

    ToppingType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }

    public static ToppingType fromString(String str) {
        switch (str) {
            case "Meat":
                return MEAT;
            case "Veggies":
                return VEGGIES;
            case "Cheese":
                return CHEESE;
            case "Sauce":
                return SAUCE;
        }
        return null;
    }

    public static boolean contains(String str) {
        return str.equals("Meat") || str.equals("Veggies") || str.equals("Cheese") || str.equals("Sauce");
    }
}
