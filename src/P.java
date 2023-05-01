import Engine.Core.Objects.BaseObject;
import Engine.Geometry.Vector;

public class P extends BaseObject {
    Vector Speed;
    Vector prevSpeed;

    {
        Speed = new Vector(0, 0);
        prevSpeed = new Vector(0, 0);
    }

    public P(double x, double y, Vector sp) {
        super(x, y);
        Speed.X = sp.X;
        Speed.Y = 0.1 * sp.Y;
    }

    @Override
    public void update(double dt) {
        // System.out.println("Object " + ObjectId + ": " + RealPos.X + " " + Pos.X);
        if (RealPos.X <= 0 || RealPos.X >= 450) {
            Speed.X = -Speed.X;
        }
        if (RealPos.Y <= 0 || RealPos.Y >= 450) {
            Speed.Y = -Speed.Y;
        }
        Move(Speed.X * dt, Speed.Y * dt);

        prevSpeed.X = Speed.X;
        prevSpeed.Y = Speed.Y;
    }
}
