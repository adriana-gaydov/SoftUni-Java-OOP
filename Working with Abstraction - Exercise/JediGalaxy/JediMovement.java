package JediGalaxy;

public class JediMovement {
    public static int move(int row, int col, Field field) {
        int starsValues = 0;
        while (row >= 0 && col < field.getColsCount()) {
            if (field.isInBounds(row, col)) {
                starsValues += field.getElement(row, col);
            }
            col++;
            row--;
        }
        return starsValues;
    }
}
