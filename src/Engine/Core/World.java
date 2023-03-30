package Engine.Core;

import Engine.Core.Colliders.AbstractCollider;
import Engine.Core.Objects.AbstractObject;
import Engine.Core.Objects.BaseObject;
import Engine.Geometry.Vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {
    public List<AbstractObject> ObjectList;
    public List<AbstractCollider> ColliderList;

    {
        ObjectList = new ArrayList<>();
        ColliderList = new ArrayList<>();
    }

    public void MainLoop(int waitTime) throws InterruptedException {
        GlobalStart();
        double start = System.currentTimeMillis();
        double end;
        while (true) {
            // Thread render
            // Thread input
            Thread.sleep(waitTime);
            end = System.currentTimeMillis();
            GlobalUpdate((end - start) / 1000);
            start = end;
        }
    }
    public void AddObject(AbstractObject aobj) {
        aobj.World = this;
        if (aobj instanceof BaseObject obj) {
            ObjectList.add(obj);
            obj.ObjectId = ObjectList.size();
            obj.ParentId = 0;
        }
        else if (aobj instanceof AbstractCollider col) {
            ColliderList.add(col);
            col.ObjectId = ColliderList.size();
            col.ParentId = 0;
        }
    }
    public void AddObject(AbstractObject aobj, int parent) {
        if (ObjectList.get(parent-1) instanceof BaseObject par) {
            aobj.World = this;
            if (aobj instanceof BaseObject obj) {
                par.AddInner(obj);
                ObjectList.add(obj);
                obj.ObjectId = ObjectList.size();
            }
            else if (aobj instanceof AbstractCollider col) {
                par.AddInner(col);
                ColliderList.add(col);
                col.ObjectId = ColliderList.size();
            }
        }
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
        CheckCollisions();
    }
    private void CheckCollisions() {
        Iterator<AbstractCollider> iter1 = ColliderList.listIterator();
        int i = 0;
        while (iter1.hasNext()) {
            AbstractCollider col1 = iter1.next();
            col1.SynchronizeShapePos();

            Iterator<AbstractCollider> iter2 = ColliderList.listIterator(i + 1);
            while (iter2.hasNext()) {
                AbstractCollider col2 = iter2.next();
                col2.SynchronizeShapePos();

                if (col1.Shape.CollisionWith(col2.Shape)) {
                    col1.OnCollision(col2);
                    col2.OnCollision(col1);
                }
            }
            i++;
        }
    }
}
