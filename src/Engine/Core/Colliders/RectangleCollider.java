package Engine.Core.Colliders;

import Engine.Geometry.Shapes.Rectangle;

public abstract class RectangleCollider extends AbstractCollider {
    public RectangleCollider(double x, double y, double w, double h) {
        super(x, y);
        Shape = new Rectangle(w, h, x, y);
    }
    @Override
    public void UpdateShapePos() {
        Shape.UpdatePos(RealPos);
    }
}
