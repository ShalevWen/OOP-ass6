//329238919 Shalev Wengrowsky

/**
 * Used as part of an animated object, used to mark the speed of the object and move it.
 */
public class Velocity {
    private final double dx; // The x component of the velocity
    private final double dy; // The y component of the velocity.

    /**
     * Creates new Velocity object.
     *
     * @param dx The x component of the velocity.
     * @param dy The y component of the velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Creates new Velocity object from angle and speed.
     *
     * @param angle The direction of the velocity.
     * @param speed The magnitude of the velocity.
     * @return The new Velocity object.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        /* (angle in degrees) = (angle in radians) * Math.PI / 180 */
        double dx = Math.sin(angle * Math.PI / 180) * speed;
        double dy = -Math.cos(angle * Math.PI / 180) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * Returns the x component of the velocity.
     *
     * @return The x component of the velocity.
     */
    public double getDx() {
        return dx;
    }

    /**
     * Returns the y component of the velocity.
     *
     * @return The y component of the velocity.
     */
    public double getDy() {
        return dy;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p A point to apply velocity to.
     * @return A new point with the velocity applied to it.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }
}