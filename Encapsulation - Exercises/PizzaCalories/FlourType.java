package PizzaCalories;

public enum FlourType {
    WHITE(1.5),
    WHOLEGRAIN(1);

    private double modifier;

    FlourType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }

    public static FlourType fromString(String str) {
        switch (str) {
            case "White":
                return WHITE;
            case "Wholegrain":
                return WHOLEGRAIN;
        }
        return null;
    }

    public static boolean contains(String str) {
        return str.equals("White") || str.equals("Wholegrain");
    }
}
