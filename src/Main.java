import Engine.Core.BaseObject;
import Engine.Core.World;
import Engine.Geometry.Point;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        World w = new World();
        w.AddObject(new BaseObject(new Point(0, 0)));
        w.AddObject(new BaseObject(new Point(0, 0)));
        w.AddObject(new BaseObject(new Point(0, 0)));
        w.AddObject(new BaseObject(new Point(0, 0)), 2);

        w.MainLoop();
    }
}
