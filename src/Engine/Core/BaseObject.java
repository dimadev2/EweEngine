package Engine.Core;

import Engine.Geometry.Point;

import java.util.ArrayList;
import java.util.List;

public class BaseObject implements IObject{
    int ObjectId;
    int ParentId;
    public Point Pos;
    private List<BaseObject> InnerObjects = new ArrayList<>();

    public BaseObject(Point pos) {
        Pos = new Point(pos);
    }
    public void Move(double dx, double dy) {
        // TODO: Make move method using MoveCommand pattern,
        //  cooperate with Collider and cancelling Command with the
        //  hierarchy of objects/colliders
    }
    void AddInner(BaseObject obj) {
        obj.ParentId = ObjectId;
        InnerObjects.add((obj));
    }
    void Start() {
        start();
        for (BaseObject obj: InnerObjects) {
            obj.Start();
        }
    }
    void Update(double dt) {
        update(dt);
        for (BaseObject obj: InnerObjects) {
            obj.Update(dt);
        }
    }
    public void start() {

    }
    public void update(double dt) {
        // Test case
        System.out.println(ObjectId + " updated, dt = " + dt);
    }
}
