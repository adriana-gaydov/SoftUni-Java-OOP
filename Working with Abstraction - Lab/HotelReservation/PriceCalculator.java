package HotelReservation;

import java.util.Scanner;

public class PriceCalculator {
   private Season season;
   private Discount discount;
   private double pricePerDay;
   private int numberOfDays;

    public PriceCalculator(Season season, Discount discount, double pricePerDay, int numberOfDays) {
        this.season = season;
        this.discount = discount;
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
    }

    public double getTotalPrice() {
        return pricePerDay * numberOfDays * season.getMultiplier() * (1 - discount.getDiscount());
    }
}


