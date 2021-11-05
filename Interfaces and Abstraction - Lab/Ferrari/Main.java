package Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car car = new Ferrari(sc.nextLine());
        System.out.println(car);
    }
}
