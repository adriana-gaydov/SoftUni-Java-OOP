package Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        checkStringIsBlank(name);
        this.name = name;
    }

    private void setGender(String gender) {
        checkStringIsBlank(gender);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    private void checkStringIsBlank(String str) {
        if (str.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String produceSound() {
        return null;
    }


    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(), this.name, this.age, this.gender, this.produceSound());
    }
}
