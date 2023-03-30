import Engine.Core.Objects.BaseObject;
import Engine.Core.World;
import Engine.Geometry.Vector;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        World w = new World();
        w.AddObject(new BaseObject(0, 0));
        w.AddObject(new BaseObject(0, 0));

        w.AddObject(new Collider(0, 0, 10, 10), 1);
        w.AddObject(new Collider(0, 0, 10, 10), 2);

        w.MainLoop(2000);
    }
}
