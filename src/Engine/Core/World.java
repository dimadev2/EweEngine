package Engine.Core;

import Engine.Core.Objects.AbstractObject;
import Engine.Core.Objects.BaseObject;

import java.util.ArrayList;
import java.util.List;

public class World {
    List<AbstractObject> ObjectList;

    {
        ObjectList = new ArrayList<>();
    }

    public void MainLoop() throws InterruptedException {
        GlobalStart();
        double start = System.currentTimeMillis();
        double end;
        while (true) {
            // Thread render
            // Thread input
            Thread.sleep(100);
            end = System.currentTimeMillis();
            GlobalUpdate((end - start) / 1000);
            start = end;
        }
    }
    public void AddObject(AbstractObject aobj) {
        if (aobj instanceof BaseObject obj) {
            ObjectList.add(obj);
            obj.ObjectId = ObjectList.size();
            obj.ParentId = 0;
        }
        aobj.World = this;
    }
    public void AddObject(AbstractObject aobj, int parent) {
        if (ObjectList.get(parent-1) instanceof BaseObject par) {
            if (aobj instanceof BaseObject obj) {
                par.AddInner(obj);
                ObjectList.add(obj);
                obj.ObjectId = ObjectList.size();
            }
        }
        aobj.World = this;
    }
    public void GlobalStart() {
        // Thread Start call for every obj (not inner)
        for (AbstractObject aobj: ObjectList) {
            if (aobj instanceof BaseObject obj) {
                if (obj.ParentId == 0) {
                    obj.Start();
                }
            }
        }
    }
    public void GlobalUpdate(double dt) {
        // Thread Update call for every obj (not inner)
        for (AbstractObject aobj: ObjectList) {
            if (aobj instanceof BaseObject obj) {
                if (obj.ParentId == 0) {
                    obj.Update(dt);
                }
            }
        }
    }
}
