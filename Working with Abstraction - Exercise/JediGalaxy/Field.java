package JediGalaxy;

public class Field {
    private int[][] matrix;

    public Field(int rowsCount, int colsCount, int startPosition) {
        this.matrix = new int[rowsCount][colsCount];
        fillField(startPosition);
    }

    public Field(int rowsCount, int colsCount) {
        this(rowsCount, colsCount, 0);
    }

    private void fillField(int startValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = startValue++;
            }
        }
    }

    public int getRowsCount() {
        return matrix.length;
    }

    public int getColsCount() {
        return matrix[0].length;
    }

    public int getElement(int row, int col) {
        return matrix[row][col];
    }

    public void setElement(int row, int col, int value) {
        matrix[row][col] =  value;
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length;
    }

}
