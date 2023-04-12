import Engine.Core.Colliders.AbstractCollider;
import Engine.Core.World;
import Engine.Geometry.Shapes.Rectangle;

public class MyWorld1 extends World {
    public MyWorld1() {
        AddObject(new P(10, 50, 150));
        AddObject(new P(420, 50, -150));

        Collider col1 = new Collider(0, 0, 50, 50);
        Collider col2 = new Collider(0, 0, 50, 50);

        AddObject(col1, 1);
        AddObject(col2, 2);
    }
}
