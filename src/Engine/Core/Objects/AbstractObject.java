package Engine.Core.Objects;

import Engine.Core.World;
import Engine.Geometry.Vector;

public abstract class AbstractObject {
    public int ObjectId;
    public int ParentId;
    public Vector Pos;
    public Vector RealPos;
    public World World;
    public AbstractObject(double x, double y) {
        Pos = new Vector(x, y);
        RealPos = new Vector(0, 0);
        UpdateRealPos();
    }
    public void UpdateRealPos() {
        if (ParentId != 0) {
            AbstractObject parent = World.ObjectList.get(ParentId - 1);
            RealPos.X = Pos.X + parent.RealPos.X;
            RealPos.Y = Pos.Y + parent.RealPos.Y;
        }
        else {
            RealPos.X = Pos.X;
            RealPos.Y = Pos.Y;
        }
    }
}
