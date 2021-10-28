package StudentSystem;

public class CommandParser {
    public static void parseCommand(String[] args, StudentSystem system) {
        if (args[0].equals("Create")) {
            system.createStudent(args);
        } else if (args[0].equals("Show")) {
            system.showStudent(args[1]);
        }
    }
}
