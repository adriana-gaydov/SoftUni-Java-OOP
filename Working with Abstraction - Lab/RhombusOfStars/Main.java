package RhombusOfStars;

import java.util.Scanner;

class Rhombus {
    private final int n;

    public Rhombus(int n) {
        this.n = n;
    }

    public void printRhombusOfStars() {
        printTop();
        printBottom();
    }

    private void printTop() {
        for (int r = 1; r <= n; r++) {
            printLine(r);
        }
    }

    private void printBottom() {
        int r = n - 1;
        for (; r > 0; r--) {
            printLine(r);
        }
    }

    private void printLine(int r) {
        StringBuilder sb = new StringBuilder();
        sb.append(repeatString(n - r, " "))
                .append(repeatString(r, "* "))
                .append(repeatString(n - r, " "));
        System.out.println(sb);
    }

    private String repeatString(int count, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(str).repeat(Math.max(0, count)));
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rhombus rhombus = new Rhombus(sc.nextInt());
        rhombus.printRhombusOfStars();
    }
}
