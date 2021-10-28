package JediGalaxy;

public class EvilMovement {
    public static void move(int row, int col, Field field) {
        while (row >= 0 && col >= 0) {
            if (field.isInBounds(row, col)) {
                field.setElement(row, col, 0);
            }
            row--;
            col--;
        }
    }
}
