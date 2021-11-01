package FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Team> teams = new LinkedHashMap<>();

        String command = sc.nextLine();
        while (!command.equals("END")) {
            String[] commandArgs = command.split(";");
            String name = commandArgs[1];
            try {
                switch (commandArgs[0]) {
                    case "Team":
                        teams.putIfAbsent(name, new Team(name));
                        break;
                    case "Add":
                        if (!teams.containsKey(name)) {
                            System.out.printf("Team %s does not exist.%n", name);
                        } else {
                            String playerName = commandArgs[2];
                            int endurance = Integer.parseInt(commandArgs[3]);
                            int sprint = Integer.parseInt(commandArgs[4]);
                            int dribble = Integer.parseInt(commandArgs[5]);
                            int passing = Integer.parseInt(commandArgs[6]);
                            int shooting = Integer.parseInt(commandArgs[7]);
                            teams.get(name).addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));
                        }
                        break;
                    case "Remove":
                        teams.get(name).removePlayer(commandArgs[2]);
                        break;
                    case "Rating":
                        if (!teams.containsKey(name)) {
                            System.out.printf("Team %s does not exist.%n", name);
                        } else {
                            System.out.printf("%s - %d%n", name, Math.round(teams.get(name).getRating()));
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = sc.nextLine();
        }
    }
}
