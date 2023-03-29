package Engine.Core.Objects;

import Engine.Core.World;
import Engine.Geometry.Vector;

public class AbstractObject {
    public int ObjectId;
    public int ParentId;
    public Vector Pos;
    public World World;
}
