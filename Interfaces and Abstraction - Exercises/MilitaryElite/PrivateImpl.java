package MilitaryElite;

public class PrivateImpl extends SoldierImpl implements Private, Comparable<PrivateImpl> {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public int compareTo(PrivateImpl o) {
        return Integer.compare(o.getId(), this.getId());
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary());
    }
}
