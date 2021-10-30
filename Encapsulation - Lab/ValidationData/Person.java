package ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, 0.0);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "First");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Last");
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    private void validateName(String name, String prefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(prefix + " name cannot be less than 3 symbols");
        }
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            bonus /= 2;
        }
        this.salary = (1 + bonus / 100) * this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age);
    }
}
