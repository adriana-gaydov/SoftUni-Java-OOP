package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Birthable> birthables = new ArrayList<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            Birthable birthable = createBirthable(tokens);

            if (birthable != null) {
                birthables.add(birthable);
            }
            input = sc.nextLine();
        }

        String year = sc.nextLine();
        birthables.stream().map(Birthable::getBirthDate).filter(e -> e.endsWith(year)).forEach(System.out::println);
    }

    private static Birthable createBirthable(String[] tokens) {
        String type = tokens[0];

        switch (type) {
            case "Citizen":
                return new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
            case "Pet":
                return new Pet(tokens[1], tokens[2]);
        }
        return null;
    }
}
