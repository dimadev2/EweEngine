package Engine.Core.Objects;

import Engine.Geometry.Vector;

import java.util.ArrayList;
import java.util.List;

public class BaseObject extends AbstractObject implements IObject{
    public List<AbstractObject> InnerObjects = new ArrayList<>();
    public BaseObject(Vector pos) {
        Pos = new Vector(pos);
    }
    public void Move(double dx, double dy) {
        // TODO: Make move method using MoveCommand pattern,
        //  cooperate with Collider and cancelling Command with the
        //  hierarchy of objects/colliders
    }
    public void AddInner(BaseObject obj) {
        obj.ParentId = ObjectId;
        InnerObjects.add((obj));
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
    public void start() {

    }
    public void update(double dt) {
        // Test case
        System.out.println(ObjectId + " updated, dt = " + dt);
    }
}
