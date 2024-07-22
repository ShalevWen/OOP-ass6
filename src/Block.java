// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private final Rectangle hitbox;
    private final Color color;
    private final List<HitListener> hitListeners;

    /**
     * Creates new Block object from its top left point, width and height.
     *
     * @param posX   The x position of the tup left corner of the block.
     * @param posY   The y position of the tup left corner of the block.
     * @param width  The width of the block.
     * @param height The height of the block.
     * @param color  The color of the block.
     */
    public Block(double posX, double posY, double width, double height, Color color) {
        this.hitbox = new Rectangle(new Point(posX, posY), width, height);
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.hitbox;
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
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * Removes the block from the game's collidableList and spriteList.
     *
     * @param g GameLevel to remove the block from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        /* If the object hit the left or right sides of the block. */
        if (collisionPoint.getX() == this.hitbox.getUpperLeft().getX()
                || collisionPoint.getX() == this.hitbox.getUpperLeft().getX() + this.hitbox.getWidth()) {
            currentVelocity = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        /* If the object hit the top or bottom sides of the block. */
        if (collisionPoint.getY() == this.hitbox.getUpperLeft().getY()
                || collisionPoint.getY() == this.hitbox.getUpperLeft().getY() + this.hitbox.getHeight()) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        notifyHit(hitter);
        return currentVelocity;
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * Notify all the listeners about the hit.
     *
     * @param hitter the hitting ball
     */
    public void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
