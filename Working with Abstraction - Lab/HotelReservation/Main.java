package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriceCalculator priceCalculator = createPriceCalculator(sc);
        System.out.printf("%.2f", priceCalculator.getTotalPrice());
    }

    private static PriceCalculator createPriceCalculator(Scanner sc) {
        String[] input = sc.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        Discount discount = Discount.valueOf(input[3]);
        return new PriceCalculator(season, discount, pricePerDay, numberOfDays);
    }
}
