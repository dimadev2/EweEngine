package Engine.Core;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class World {
    List<BaseObject> ObjectList;

    {
        ObjectList = new ArrayList<>();
    }

    public void MainLoop() throws InterruptedException {
        GlobalStart();
        double start = System.currentTimeMillis();
        double end, dt;
        while (true) {
            // Thread render
            // Thread input
            Thread.sleep(100);
            end = System.currentTimeMillis();
            dt = (end - start) / 1000;
            GlobalUpdate(dt);
            start = end;
        }
    }
    public void AddObject(BaseObject obj) {
        ObjectList.add(obj);
        obj.ObjectId = ObjectList.size();
        obj.ParentId = 0;
    }
    public void AddObject(BaseObject obj, int parent) {
        ObjectList.get(parent-1).AddInner(obj);
        ObjectList.add(obj);
        obj.ObjectId = ObjectList.size();
    }
    public void GlobalStart() {
        // Thread Start call for every obj (not inner)
        for (BaseObject obj: ObjectList) {
            obj.Start();
        }
    }
    public void GlobalUpdate(double dt) {
        // Thread Update call for every obj (not inner)
        for (BaseObject obj: ObjectList) {
            obj.Update(dt);
        }
    }
}
