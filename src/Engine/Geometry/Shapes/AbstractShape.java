package Engine.Geometry.Shapes;

import Engine.Geometry.Vector;

abstract public class AbstractShape implements IShape {
    public Vector Pos;

    {
        Pos = new Vector(0, 0);
    }

    public AbstractShape(double x, double y) {
        Pos.X = x;
        Pos.Y = y;
    }
    public void UpdatePos(Vector pos) {
        Pos.X = pos.X;
        Pos.Y = pos.Y;
    }
}
