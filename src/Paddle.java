// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Represents the paddle, can move left and right according to user input.
 */
public class Paddle implements Sprite, Collidable {
    private Rectangle hitbox;
    private final Color color;
    private final KeyboardSensor keyboard;
    private final double speed;

    /**
     * Creates new Paddle object using the given KeyboardSensor.
     *
     * @param speed    the speed of the paddle
     * @param width    the width of the paddle
     * @param keyboard The keyboardSensor.
     */
    public Paddle(int speed, int width, KeyboardSensor keyboard) {
        this.hitbox = new Rectangle(new Point(400 - (width >> 1), 565), width, 15);
        this.speed = speed;
        this.color = Color.ORANGE;
        this.keyboard = keyboard;
    }

    /**
     * Moves the paddle to the left (if possible).
     */
    public void moveLeft() {
        Point upperLeft = new Point(Math.max(this.hitbox.getUpperLeft().getX() - speed, 25),
                this.hitbox.getUpperLeft().getY());
        this.hitbox = new Rectangle(upperLeft, this.hitbox.getWidth(), this.hitbox.getHeight());
    }

    /**
     * Moves the paddle to the right (if possible).
     */
    public void moveRight() {
        Point upperLeft = new Point(Math.min(this.hitbox.getUpperLeft().getX() + speed, 775 - this.hitbox.getWidth()),
                this.hitbox.getUpperLeft().getY());
        this.hitbox = new Rectangle(upperLeft, this.hitbox.getWidth(), this.hitbox.getHeight());
    }

    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.hitbox.getUpperLeft().getX(), (int) this.hitbox.getUpperLeft().getY(),
                (int) this.hitbox.getWidth(), (int) this.hitbox.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.hitbox.getUpperLeft().getX(), (int) this.hitbox.getUpperLeft().getY(),
                (int) this.hitbox.getWidth(), (int) this.hitbox.getHeight());
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return hitbox;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        /* If the object hit the side of the paddle. */
        if (collisionPoint.getX() == this.hitbox.getUpperLeft().getX()
                || collisionPoint.getX() == this.hitbox.getUpperLeft().getX() + this.hitbox.getWidth()) {
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        /* Assign the collision point a number between 1 and 5 that represents the segment it's in */
        int hitSegment = (int) (5 * this.hitbox.getUpperLeft().distance(collisionPoint) / this.hitbox.getWidth()) + 1;
        /* Calculate the magnitude of the speed */
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        switch (hitSegment) {
            case 1:
                return Velocity.fromAngleAndSpeed(-60, speed);
            case 2:
                return Velocity.fromAngleAndSpeed(-30, speed);
            case 3:
                return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            case 4:
                return Velocity.fromAngleAndSpeed(30, speed);
            default:
                return Velocity.fromAngleAndSpeed(60, speed);
        }
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}