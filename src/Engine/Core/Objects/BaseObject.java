package Engine.Core.Objects;

import Engine.Geometry.Vector;

import java.util.ArrayList;
import java.util.List;

public class BaseObject extends AbstractObject implements IObject{
    public List<AbstractObject> InnerObjects = new ArrayList<>();
    public BaseObject(double x, double y) {
        super(x, y);
    }
    public void Move(Vector ds) {
        // TODO: Make move method using MoveCommand pattern,
        //  cooperate with Collider and cancelling Command with the
        //  hierarchy of objects/colliders
    }
    public void AddInner(AbstractObject obj) {
        obj.ParentId = ObjectId;
        InnerObjects.add((obj));
        obj.UpdateRealPos();
    }
    final public void Start() {
        start();
        for (AbstractObject aobj: InnerObjects) {
            if (aobj instanceof BaseObject obj) {
                obj.Start();
            }
        }
    }
    final public void Update(double dt) {
        update(dt);
        for (AbstractObject aobj: InnerObjects) {
            if (aobj instanceof BaseObject obj) {
                obj.Start();
            }
        }
    }
    @Override
    public void start() {

    }
    @Override
    public void update(double dt) {
        // Test case
        System.out.println(ObjectId + " updated, dt = " + dt);
    }
}
