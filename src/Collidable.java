// 329238919 Shalev Wengrowsky

/**
 * Represents an object that can collide with other shapes.
 */
public interface Collidable {

    /**
     * Return the hitbox of the object.
     *
     * @return A rectangle that represents the hitbox of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     *
     * @param collisionPoint  The point where the object hit.
     * @param currentVelocity The velocity of the collided object.
     * @param hitter          the hitting ball
     * @return The new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}