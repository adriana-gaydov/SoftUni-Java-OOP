package ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double length = Double.parseDouble(sc.nextLine());
        double width = Double.parseDouble(sc.nextLine());
        double height = Double.parseDouble(sc.nextLine());

        try {
            Box box = new Box(length, width, height);

            double surfaceArea = box.calculateSurfaceArea();
            System.out.printf("Surface Area - %.2f%n", surfaceArea);

            double lateralSurfaceArea = box.calculateLateralSurfaceArea();
            System.out.printf("Lateral Surface Area - %.2f%n", lateralSurfaceArea);

            double volume = box.calculateVolume();
            System.out.printf("Volume - %.2f%n", volume);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
