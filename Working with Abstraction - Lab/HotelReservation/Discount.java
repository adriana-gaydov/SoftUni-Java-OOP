package HotelReservation;

public enum Discount {
    VIP(20),
    SecondVisit(10),
    None(0);

    private int discountPercentage;

    Discount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscount() {
        return discountPercentage / 100.0;
    }
}
