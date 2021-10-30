
package GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safeContent = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < safeContent.length; i += 2) {
            String name = safeContent[i];
            int itemCount = Integer.parseInt(safeContent[i + 1]);

            String currentItem = "";

            if (name.length() == 3) {
                currentItem = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                currentItem = "Gem";
            } else if (name.equalsIgnoreCase("gold")) {
                currentItem = "Gold";
            }
            bag.add(currentItem, name, itemCount);
        }
        bag.print();
    }

}