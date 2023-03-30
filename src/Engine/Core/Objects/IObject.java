package Engine.Core.Objects;

import Engine.Geometry.Vector;

public interface IObject {
    public void start();
    public void update(double dt);
    public void Move(Vector ds);
}
