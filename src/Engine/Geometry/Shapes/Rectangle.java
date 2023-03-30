package Engine.Geometry.Shapes;

import Engine.Geometry.Vector;

public class Rectangle extends AbstractShape{
    public double Width;
    public double Height;
    public Rectangle(double w, double h, double x, double y) {
        super(x, y);
        Width = w;
        Height = h;
    }
    @Override
    public boolean CollisionWith(AbstractShape aother) {
        if (aother instanceof Rectangle other) {
            if (
                    Pos.X < other.Pos.X + other.Width &&
                            Pos.X + Width > other.Pos.X &&
                            Pos.Y < other.Pos.Y + other.Height &&
                            Pos.Y + Height > other.Pos.Y
            ) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
