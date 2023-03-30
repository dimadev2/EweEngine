package Engine.Geometry.Shapes;

import Engine.Core.Objects.AbstractObject;
import Engine.Geometry.Vector;

public abstract class AbstractShape implements IShape {
    public Vector Pos;

    {
        Pos = new Vector(0, 0);
    }

    public AbstractShape(double x, double y) {
        UpdatePos(x, y);
    }
    public void UpdatePos(double x, double y) {
        Pos.X = x;
        Pos.Y = y;
    }
}
