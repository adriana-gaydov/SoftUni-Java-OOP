package PointInRectangle;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isBiggerOrEqual(Point o) {
        return this.x >= o.x && this.y >= o.y;
    }

    public boolean isLessOrEqual(Point o) {
        return this.x <= o.x && this.y <= o.y;
    }
}
