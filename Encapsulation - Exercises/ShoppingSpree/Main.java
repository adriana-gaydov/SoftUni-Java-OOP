package ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] peopleArgs = sc.nextLine().split(";");

        Arrays.stream(peopleArgs).forEach(e -> {
            try {
                Person person = new Person(e.split("=")[0], Double.parseDouble(e.split("=")[1]));
                people.put(person.getName(), person);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        });

        String[] productArgs = sc.nextLine().split(";");

        Arrays.stream(productArgs).forEach(e -> {
            try {
                Product product = new Product(e.split("=")[0], Double.parseDouble(e.split("=")[1]));
                products.put(product.getName(), product);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        });

        String command = sc.nextLine();
        while (!command.equals("END")) {
            String[] commandArgs = command.split("\\s+");
            try {
                if (people.containsKey(commandArgs[0])) {
                    people.get(commandArgs[0]).buyProduct(products.get(commandArgs[1]));
                    System.out.printf("%s bought %s%n", commandArgs[0], commandArgs[1]);
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            command = sc.nextLine();
        }

        people.values().forEach(e -> System.out.printf("%s - %s%n", e.getName(),
                e.getProducts().isEmpty()
                ? "Nothing bought"
                : e.getProducts().stream().map(Product::getName).collect(Collectors.joining(", "))));
    }
}
