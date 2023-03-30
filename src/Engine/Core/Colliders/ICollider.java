package Engine.Core.Colliders;

public interface ICollider {
    public void OnCollision(AbstractCollider other);
    public void SynchronizeShapePos();
}
