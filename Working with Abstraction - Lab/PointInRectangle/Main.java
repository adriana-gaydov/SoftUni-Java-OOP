package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Rectangle rectangle = createRectangle();
        readCommands(rectangle);
    }

    private static void readCommands(Rectangle rectangle) {
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            int[] coordinates = readIntArray();
            System.out.println(rectangle.contains(new Point(coordinates[0], coordinates[1])));
        }
    }

    private static Rectangle createRectangle() {
        int[] points = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point A = new Point(points[0], points[1]);
        Point B = new Point(points[2], points[3]);
        return new Rectangle(A, B);
    }

    private static int[] readIntArray() {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

