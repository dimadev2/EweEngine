import Engine.Core.Objects.BaseObject;
import Engine.Geometry.Vector;

public class P extends BaseObject {
    Vector Speed;

    {
        Speed = new Vector(0, 0);
    }

    public P(double x, double y, double speed) {
        super(x, y);
        Speed.X = speed;
    }

    @Override
    public void update(double dt) {
        // System.out.println("Object " + ObjectId + ": " + RealPos.X + " " + Pos.X);
        if (RealPos.X <= 0 || RealPos.X >= 450) {
            Speed.X *= -1;
        }
        Move(Speed.X * dt, Speed.Y * dt);
    }
}
