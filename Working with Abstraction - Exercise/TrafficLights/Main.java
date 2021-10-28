package TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TrafficLight> trafficLights = getTrafficLights(sc);

        int n = Integer.parseInt(sc.nextLine());
        printChanges(trafficLights, n);
    }

    private static void printChanges(List<TrafficLight> trafficLights, int n) {
        while (n-- > 0) {
            trafficLights.forEach(e -> {
                e.changeColor();
                System.out.print(e + " ");
            });
            System.out.println();
        }
    }

    private static List<TrafficLight> getTrafficLights(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .map(e -> new TrafficLight(Colors.valueOf(e)))
                .collect(Collectors.toList());
    }
}
