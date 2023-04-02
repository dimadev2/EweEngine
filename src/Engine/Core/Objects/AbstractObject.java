package Engine.Core.Objects;

import Engine.Core.Commands.MoveCommand;
import Engine.Core.World;
import Engine.Geometry.Vector;

abstract public class AbstractObject {
    public int ObjectId;
    public int ParentId;
    public Vector Pos;
    public Vector RealPos;
    protected MoveCommand MoveCommand;
    public World World;

    {
        MoveCommand = new MoveCommand(this);
    }

    public AbstractObject(double x, double y) {
        Pos = new Vector(x, y);
        RealPos = new Vector(x, y);
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
    abstract public void Move(double dx, double dy);
}
