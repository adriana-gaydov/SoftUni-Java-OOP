package PointInRectangle;

class Rectangle {
    private Point A;
    private Point B;

    public Rectangle(Point A, Point B) {
        this.A = A;
        this.B = B;
    }

    public boolean contains(Point p) {
        return p.isBiggerOrEqual(A) && p.isLessOrEqual(B);
    }
}
