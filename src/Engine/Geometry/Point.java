package Engine.Geometry;

public class Point {
    double X;
    double Y;
    public Point(double x, double y) {
        X = x;
        Y = y;
    }
    public Point(Point other) {
        X = other.X;
        Y = other.Y;
    }
}
