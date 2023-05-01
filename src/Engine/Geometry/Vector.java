package Engine.Geometry;

public class Vector {
    public double X;
    public double Y;
    public Vector(double x, double y) {
        X = x;
        Y = y;
    }
    public Vector(Vector other) {
        X = other.X;
        Y = other.Y;
    }
    public void Add(Vector other) {
        X += other.X;
        Y += other.Y;
    }
    public void Mult(double s) {
        X *= s;
        Y *= s;
    }
    public double Abs() {
        return Math.sqrt(X*X + Y*Y);
    }
    public double Scal(Vector other) {
        return X * other.X + Y * other.Y;
    }
}
