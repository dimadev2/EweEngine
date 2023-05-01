package Engine.Commands;

import Engine.Core.AbstractNode;
import Engine.Geometry.Vector;

import java.awt.*;

public class MoveCommand {
    Vector DS = new Vector(0, 0);
    AbstractNode Node;
    CommandStatus StatusX = CommandStatus.READY;
    CommandStatus StatusY = CommandStatus.READY;
    public MoveCommand(AbstractNode n) {
        Node = n;
    }
    public void updateDS(double dx, double dy) {
        DS.X = dx;
        DS.Y = dy;
    }
    public void ExecuteX() {
        if (StatusX == CommandStatus.READY || StatusX == CommandStatus.CANCELED) {
            Node.Pos.X += DS.X;
            StatusX = CommandStatus.DONE;
        }
    }
    public void ExecuteY() {
        if (StatusY == CommandStatus.READY || StatusY == CommandStatus.CANCELED) {
            Node.Pos.Y += DS.Y;
            StatusY = CommandStatus.DONE;
        }
    }
    public void UndoX() {
        if (StatusX == CommandStatus.DONE) {
            Node.Pos.X -= DS.X;
            StatusX = CommandStatus.CANCELED;
        }
    }
    public void UndoY() {
        if (StatusY == CommandStatus.DONE) {
            Node.Pos.Y -= DS.Y;
            StatusY = CommandStatus.CANCELED;
        }
    }
}
