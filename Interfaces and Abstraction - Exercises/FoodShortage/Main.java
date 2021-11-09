package FoodShortage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Buyer> buyers = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            Buyer buyer = createBuyer(tokens);
            buyers.add(buyer);
        }

        String name = sc.nextLine();
        while (!name.equals("End")) {
            String finalName = name;
            buyers.stream().filter(e -> e.getName().equals(finalName)).forEach(Buyer::buyFood);
            name = sc.nextLine();
        }

        int totalFood = buyers.stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }

    private static Buyer createBuyer(String[] tokens) {
        if (tokens.length == 4) {
            return new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
        }
        return new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
    }
}
