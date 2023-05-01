package Engine.Core;

import Engine.Geometry.Vector;

import java.util.ArrayList;
import java.util.List;

public class Node extends AbstractNode{
    List<AbstractNode> InnerNodes = new ArrayList<>();
    public Node(World w) {
        super(w);
    }
    public void AddInner(AbstractNode nd) {
        InnerNodes.add(nd);
        nd.Parent = this;
    }
    @Override
    public void Start() {
        start();
        for (AbstractNode n: InnerNodes) {
            n.Start();
        }
    }
    @Override
    public void Update(double dt) {
        update(dt);
        for (AbstractNode n: InnerNodes) {
            n.Update(dt);
        }
    }
    @Override
    public void Move(double dx, double dy) {
        super.Move(dx, dy);
        for (AbstractNode n: InnerNodes) {
            n.Move(dx, dy);
        }
    }
    public void start() {

    }
    public void update(double dt) {

    }
}
