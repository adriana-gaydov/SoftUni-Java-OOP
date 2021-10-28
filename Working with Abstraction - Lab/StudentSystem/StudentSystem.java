package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public String parseCommand(String[] args) {
        String command = args[0];
        if (command.equals("Create")) {
            createStudent(args);
        } else if (command.equals("Show")) {
            try {
                return showStudent(args[1]);
            } catch (IllegalArgumentException ignored) {

            }
        }
        return null;
    }

    public String showStudent(String name) {
        if (repository.containsKey(name)) {
            Student student = repository.get(name);
            return StudentFormatting.formatStudent(student);
        }
        throw new IllegalArgumentException("No such student");
    }

    public void createStudent(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);
        Student student = new Student(name, age, grade);
        repository.putIfAbsent(name, student);
    }
}
