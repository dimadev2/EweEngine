import Engine.Core.Objects.BaseObject;
import Engine.Core.World;
import Engine.Geometry.Vector;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        World w = new World();
        w.AddObject(new P(0, 0, 0.5));
        w.AddObject(new P(12, 0, -0.5));

        w.AddObject(new Collider(0, 0, 2, 10), 1);
        w.AddObject(new Collider(0, 0, 2, 10), 2);

        w.MainLoop(100);
    }
}
