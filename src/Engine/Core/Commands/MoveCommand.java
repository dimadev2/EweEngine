package Engine.Core.Commands;

import Engine.Core.Objects.AbstractObject;
import Engine.Geometry.Vector;

public class MoveCommand extends AbstractCommand implements ICommand{
    Vector Ds;
    AbstractObject Object;

    {
        Ds = new Vector(0, 0);
        Status = CommandStatus.Ready;
    }

    public MoveCommand(AbstractObject obj) {
        Object = obj;
    }

    public void UpdateDs(Vector ds) {
        Ds.X = ds.X;
        Ds.Y = ds.Y;

        Status = CommandStatus.Ready;
    }

    public void UpdateDs(double x, double y) {
        Ds.X = x;
        Ds.Y = y;

        Status = CommandStatus.Ready;
    }

    public void Execute() {
        if (Status == CommandStatus.Ready ||
                Status == CommandStatus.Canceled) {
            Object.RealPos.X += Ds.X;
            Object.RealPos.Y += Ds.Y;

            Status = CommandStatus.Done;
        }
    }

    public void Undo() {
        if (Status == CommandStatus.Done) {
            Object.RealPos.X -= Ds.X;
            Object.RealPos.Y -= Ds.Y;

            Status = CommandStatus.Canceled;
        }
    }

}
