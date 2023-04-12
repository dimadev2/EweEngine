import Engine.Core.Colliders.AbstractCollider;
import Engine.Core.Colliders.RectangleCollider;
import Engine.Core.Objects.AbstractObject;

public class Collider extends RectangleCollider {
    public Collider(double x, double y, double w, double h) {
        super(x, y, w, h);
    }
    @Override
    public void OnCollision(AbstractCollider other) {
        //System.out.println(ObjectId + " collided " + other.ObjectId);

        System.out.println("Collider " + ObjectId + ": " + RealPos.X + " " + Pos.X + " " + Shape.Pos.X);

        AbstractObject parent = World.ObjectList.get(ParentId-1);
        if (parent instanceof P p) {
            p.Speed.X *= -1;
        }
    }
}
