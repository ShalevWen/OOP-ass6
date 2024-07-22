//329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Represents a ball (circle with velocity) on a 2D plane
 * and its behavior in the GameEnvironment.
 */
public class Ball implements Sprite {
    private Point center;                     // The center point of the ball.
    private final int r;                            // The radius of the ball.
    private final Color color;                      // The color of the ball.
    private Velocity v;                       // The velocity of the ball.
    private final GameEnvironment gameEnvironment;  // The GameEnvironment that the ball lives in.

    /**
     * Creates a new Ball object.
     *
     * @param x               The x coordinate of the center point.
     * @param y               The y coordinate of the center point.
     * @param r               The radius of the ball.
     * @param color           The color of the ball.
     * @param gameEnvironment The GameEnvironment in which the ball lives.
     */
    public Ball(int x, int y, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = null;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Returns the x coordinate of the center point.
     *
     * @return The x coordinate of the center point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Returns the y coordinate of the center point.
     *
     * @return The y coordinate of the center point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Returns the radius of the ball.
     *
     * @return The radius of the ball.
     */
    public int getSize() {
        return r;
    }

    /**
     * Returns the velocity of the ball.
     *
     * @return The velocity of the ball.
     */
    public Velocity getVelocity() {
        return v;
    }

    /**
     * Returns the color of the ball.
     *
     * @return The color of the ball.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the velocity of the ball to a given velocity.
     *
     * @param v The given velocity.
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }

    /**
     * Sets the velocity of the ball to a velocity given by its x (dx) and y (dy) components.
     *
     * @param dx The x component of the velocity.
     * @param dy The y component of the velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.getSize());
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.getSize());
    }

    @Override
    public void timePassed() {
        if (this.v == null) {
            return;
        }
        Line trajectory = new Line(this.center, this.v.applyToPoint(this.center));
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo == null) {
            this.center = this.v.applyToPoint(this.center);
            return;
        }
        this.v = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.v);
        this.center = this.v.applyToPoint(this.center);
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Removes the ball from the game's spriteList.
     *
     * @param g GameLevel to remove the ball from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}