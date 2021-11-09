package MilitaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorp(corps);
    }

    private void setCorp(String corps) {
        if (!(corps.equals("Airforces") || corps.equals("Marines"))) {
            throw new IllegalArgumentException();
        }
        this.corps = Corps.valueOf(corps);
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + String.format("Corps: %s", corps);
    }

}
