package MilitaryElite;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private HashSet<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new HashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        if (this.repairs.isEmpty()) {
            return super.toString() + System.lineSeparator() + "Repairs:";
        }

        StringBuilder sb = new StringBuilder(String.format("Repairs:%n"));

        AtomicInteger br = new AtomicInteger();
        this.repairs.forEach(e -> {
            sb.append(" ").append(e);
            if (br.get() != this.repairs.size() - 1) {
                sb.append(System.lineSeparator());
            }
            br.getAndIncrement();
        });

        return super.toString() + System.lineSeparator() + sb;
    }
}
