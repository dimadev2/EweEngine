import Engine.Core.Colliders.AbstractCollider;
import Engine.Core.Colliders.RectangleCollider;
import Engine.Core.Objects.AbstractObject;
import Engine.Geometry.Vector;

public class Collider extends RectangleCollider {
    public Collider(double x, double y, double w, double h) {
        super(x, y, w, h);
    }
    @Override
    public void OnCollision(AbstractCollider other) {
        //System.out.println(ObjectId + " collided " + other.ObjectId);

        System.out.println("Collider " + ObjectId + ": " + RealPos.X + " " + Pos.X + " " + Shape.Pos.X);

        AbstractObject parent = World.ObjectList.get(ParentId-1);
        AbstractObject otherParent = World.ObjectList.get(other.ParentId - 1);
        if (parent instanceof P p &&
            otherParent instanceof P op) {
            Vector sp = p.Speed;
            Vector osp = op.prevSpeed;

            Vector norm = new Vector(op.Pos.X - p.Pos.X, op.Pos.Y - p.Pos.Y);
            norm.Mult(-1/norm.Abs());

            Vector p1 = new Vector(norm.X, norm.Y);
            p1.Mult(sp.Scal(norm) / norm.Abs());

            Vector p2 = new Vector(norm.X, norm.Y);
            p2.Mult(osp.Scal(norm) / norm.Abs());

            Vector ost = new Vector(sp.X - p1.X, sp.Y - p1.Y);

            sp.X = p2.X + ost.X;
            sp.Y = p2.Y + ost.Y;
        }
    }
}
