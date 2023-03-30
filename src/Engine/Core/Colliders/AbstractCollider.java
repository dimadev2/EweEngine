package Engine.Core.Colliders;

import Engine.Core.Objects.AbstractObject;
import Engine.Geometry.Shapes.AbstractShape;

public abstract class AbstractCollider extends AbstractObject implements ICollider {
    public AbstractShape Shape;
    public AbstractCollider(double x, double y) {
        super(x, y);
    }
}
