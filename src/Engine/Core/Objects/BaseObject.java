package Engine.Core.Objects;

import Engine.Geometry.Vector;

import java.util.ArrayList;
import java.util.List;

public class BaseObject extends AbstractObject implements IObject{
    public List<AbstractObject> InnerObjects = new ArrayList<>();
    public BaseObject(double x, double y) {
        super(x, y);
    }
    @Override
    public void Move(double dx, double dy) {
        // TODO
        MoveCommand.UpdateDs(dx, dy);
        MoveCommand.Execute();
        for (AbstractObject aobj: InnerObjects) {
            aobj.Move(dx, dy);
        }
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
                obj.Update(dt);
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
