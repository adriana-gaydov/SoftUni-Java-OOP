package RhombusOfStars;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printRhombusOfStars(n);
    }


    public static void printRhombusOfStars(int n) {
        printTop(n);
        printBottom(n);
    }

    private static void printTop(int n) {
        for (int r = 1; r <= n; r++) {
            printLine(r, n);
        }
    }

    private static void printBottom(int n) {
        int r = n - 1;
        for (; r > 0; r--) {
            printLine(r, n);
        }
    }

    private static void printLine(int r, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(repeatString(n - r, " "))
                .append(repeatString(r, "* "))
                .append(repeatString(n - r, " "));
        System.out.println(sb);
    }

    private static String repeatString(int count, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
