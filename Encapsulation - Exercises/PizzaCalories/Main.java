package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pizzaArgs = sc.nextLine().split("\\s+");
        String[] doughArgs = sc.nextLine().split("\\s+");

        try {
            Pizza pizza = new Pizza(pizzaArgs[1], Integer.parseInt(pizzaArgs[2]));
            Dough dough = new Dough(doughArgs[1], doughArgs[2], Double.parseDouble(doughArgs[3]));

            pizza.setDough(dough);
            String command = sc.nextLine();
            while (!command.equals("END")) {
                String[] toppingArgs = command.split("\\s+");
                Topping topping = new Topping(toppingArgs[1], Double.parseDouble(toppingArgs[2]));
                pizza.addTopping(topping);
                command = sc.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
