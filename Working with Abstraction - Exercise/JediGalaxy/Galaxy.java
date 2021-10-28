package JediGalaxy;

public class Galaxy {
    private Field field;

    public Galaxy(Field field) {
        this.field = field;
    }

    public void moveEvil(int row, int col) {
        EvilMovement.move(row, col, field);
    }

    public int moveJedi(int row, int col) {
        return JediMovement.move(row, col, field);
    }
}

