package MilitaryElite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<Integer, PrivateImpl> privates = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<SoldierImpl> soldiers = new ArrayList<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];

            switch (type) {
                case "Private":
                    PrivateImpl privateImpl = createPrivate(tokens);
                    soldiers.add(privateImpl);
                    privates.put(Integer.parseInt(tokens[1]), privateImpl);
                    break;
                case "LieutenantGeneral":
                    LieutenantGeneralImpl lieutenantGeneral = createLieutenantGeneral(tokens);
                    soldiers.add(lieutenantGeneral);
                    break;
                case "Engineer":
                    try {
                        EngineerImpl engineer = createEngineer(tokens);
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException ignored) {
                    }
                    break;
                case "Commando":
                    CommandoImpl commando = createCommando(tokens);
                    soldiers.add(commando);
                    break;
                case "Spy":
                    SpyImpl spy = createSpy(tokens);
                    soldiers.add(spy);
                    break;
            }
            input = sc.nextLine();
        }
        soldiers.forEach(System.out::println);
    }

    private static SpyImpl createSpy(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        String codeNumber = tokens[4];

        return new SpyImpl(id, firstName, lastName, codeNumber);
    }


    private static CommandoImpl createCommando(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        String corps = tokens[5];

        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);

        for (int i = 6; i < tokens.length; i += 2) {
            try {
                Mission mission = new Mission(tokens[i], tokens[i + 1]);
                commando.addMission(mission);
            } catch (IllegalArgumentException ignored) {
            }
        }
        return commando;
    }

    private static EngineerImpl createEngineer(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        String corps = tokens[5];

        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

        for (int i = 6; i < tokens.length; i += 2) {
            engineer.addRepair(new Repair(tokens[i], Integer.parseInt(tokens[i + 1])));
        }
        return engineer;
    }

    private static LieutenantGeneralImpl createLieutenantGeneral(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);

        LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
        for (int i = 5; i < tokens.length; i++) {
            lieutenantGeneral.addPrivate(privates.get(Integer.parseInt(tokens[i])));
        }

        return lieutenantGeneral;
    }

    private static PrivateImpl createPrivate(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);

        return new PrivateImpl(id, firstName, lastName, salary);
    }
}
