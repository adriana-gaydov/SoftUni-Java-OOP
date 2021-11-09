package MilitaryElite;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private TreeSet<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>();
    }

    public void addPrivate(PrivateImpl priv) {
        this.privates.add(priv);
    }

    @Override
    public Collection<PrivateImpl> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    @Override
    public String toString() {
        if (this.privates.isEmpty()) {
            return super.toString() + System.lineSeparator() + "Privates:";
        }
        StringBuilder sb = new StringBuilder(String.format("Privates:%n"));

        AtomicInteger br = new AtomicInteger();
        this.privates.forEach(e -> {
            sb.append(" ").append(e);
            if (br.get() != this.privates.size() - 1) {
                sb.append(System.lineSeparator());
            }
            br.getAndIncrement();
        });

        return super.toString() + System.lineSeparator() + sb;
    }
}
