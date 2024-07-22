// 329238919 Shalev Wengrowsky

/**
 * Represents a collision event and store the collision point and het object.
 */
public class CollisionInfo {
    private final Point collisionPoint;
    private final Collidable collisionObject;

    /**
     * Instantiates a new Collision info.
     *
     * @param collisionPoint  the collision point
     * @param collisionObject the collision object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * Return the point at which the collision occurs.
     *
     * @return the point at which the collision occurs
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * Return the collidable object involved in the collision.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}