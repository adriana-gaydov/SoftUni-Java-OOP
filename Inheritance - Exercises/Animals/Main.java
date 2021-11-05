package Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String animalType = sc.nextLine();
        while (!animalType.equals("Beast!")) {
            String[] animalArgs = sc.nextLine().split("\\s+");

            try {
                Animal animal = createAnimal(animalType, animalArgs);
                System.out.println(animal);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animalType = sc.nextLine();
        }
    }

    private static Animal createAnimal(String animalType, String[] animalArgs) {
        String name = animalArgs[0];
        int age = Integer.parseInt(animalArgs[1]);
        String gender = animalArgs[2];

        switch (animalType) {
            case "Cat":
                return new Cat(name, age, gender);
            case "Dog":
                return new Dog(name, age, gender);
            case "Frog":
                return new Frog(name, age, gender);
            case "Kitten":
                return new Kitten(name, age);
            case "Tomcat":
                return new Tomcat(name, age);
        }
        return null;
    }
}
