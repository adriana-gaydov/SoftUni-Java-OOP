package glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.Collection;

public class Carton implements Suitcase {
    private ArrayList<String> exhibits;

    public Carton() {
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }
}
