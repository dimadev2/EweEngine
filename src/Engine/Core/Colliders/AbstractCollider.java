package Engine.Core.Colliders;

import Engine.Core.Objects.AbstractObject;
import Engine.Geometry.Shapes.AbstractShape;
import Engine.Geometry.Vector;

abstract public class AbstractCollider extends AbstractObject implements ICollider {
    public AbstractShape Shape;
    public AbstractCollider(double x, double y) {
        super(x, y);
    }
    @Override
    public void Move(double dx, double dy) {
        MoveCommand.UpdateDs(dx, dy);
        MoveCommand.Execute();

        Shape.UpdatePos(RealPos);
    }
}
