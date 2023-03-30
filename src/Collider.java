import Engine.Core.Colliders.AbstractCollider;
import Engine.Core.Colliders.RectangleCollider;

public class Collider extends RectangleCollider {
    public Collider(double x, double y, double w, double h) {
        super(x, y, w, h);
    }
    @Override
    public void OnCollision(AbstractCollider other) {
        System.out.println(ObjectId + " collided " + other.ObjectId);
    }
}
