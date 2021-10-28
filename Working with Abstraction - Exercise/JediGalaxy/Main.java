package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readIntArray(scanner.nextLine());
        Field field = readField(dimensions);
        Galaxy galaxy = new Galaxy(field);

        String command = scanner.nextLine();
        long totalStarsValues = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinates = readIntArray(command);
            int[] evilCoordinates = readIntArray(scanner.nextLine());
            moveEvil(galaxy, evilCoordinates);
            totalStarsValues = moveJedi(galaxy, totalStarsValues, jediCoordinates);
            command = scanner.nextLine();
        }
        System.out.println(totalStarsValues);
    }

    private static long moveJedi(Galaxy galaxy, long totalStarsValues, int[] jediCoordinates) {
        int jediRow = jediCoordinates[0];
        int jediCol = jediCoordinates[1];

        totalStarsValues += galaxy.moveJedi(jediRow, jediCol);
        return totalStarsValues;
    }

    private static void moveEvil(Galaxy galaxy, int[] evilCoordinates) {
        int evilRow = evilCoordinates[0];
        int evilCol = evilCoordinates[1];

        galaxy.moveEvil(evilRow, evilCol);
    }

    private static Field readField(int[] dimensions) {
        int rowsCount = dimensions[0];
        int colsCount = dimensions[1];

        return new Field(rowsCount, colsCount);
    }

    private static int[] readIntArray(String s) {
        return Arrays.stream(s.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
