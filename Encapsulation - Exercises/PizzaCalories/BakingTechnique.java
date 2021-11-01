package PizzaCalories;

public enum BakingTechnique {
    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1);

    private double modifier;

    BakingTechnique(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }

    public static BakingTechnique fromString(String str) {
        switch (str) {
            case "Crispy":
                return CRISPY;
            case "Chewy":
                return CHEWY;
            case "Homemade":
                return HOMEMADE;
        }
        return null;
    }

    public static boolean contains(String str) {
        return str.equals("Crispy") || str.equals("Chewy") || str.equals("Homemade");
    }
}
