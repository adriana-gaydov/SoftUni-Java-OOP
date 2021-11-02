package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {

    public E getRandomElement() {
        int size = super.size();
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(size);
        return super.remove(randomIndex);
    }
}
