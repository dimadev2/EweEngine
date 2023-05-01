package Engine.Core;

import Engine.Commands.MoveCommand;
import Engine.Geometry.Vector;

abstract public class AbstractNode {
    public Vector Pos = new Vector(0, 0);
    public AbstractNode Parent;
    final public World World;
    private MoveCommand MoveCommand;
    public AbstractNode(World w) {
        World = w;
    }
    abstract public void Start();
    abstract public void Update(double dt);
    public void Move(double dx, double dy) {
        MoveCommand.updateDS(dx, dy);

        MoveCommand.ExecuteX();
        MoveCommand.ExecuteY();
    }
}
