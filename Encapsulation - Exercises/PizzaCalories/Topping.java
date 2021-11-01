package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!ToppingType.contains(toppingType)) {
            String message = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(message);
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            String message = String.format("%s weight should be in the range [1..50].", toppingType);
            throw new IllegalArgumentException(message);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.weight) * ToppingType.fromString(toppingType).getModifier();
    }
}
