// 329238919 Shalev Wengrowsky.

import java.util.List;
import java.util.ArrayList;

import biuoop.DrawSurface;

/**
 * The type Sprite collection.
 */
public class SpriteCollection {
    private final List<Sprite> spriteList;

    /**
     * Creates new SpriteCollection object.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * Adds s to the spriteCollection.
     *
     * @param s Sprite to add.
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * Removes s from the spriteCollection.
     *
     * @param s Sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteList = new ArrayList<>(this.spriteList);
        for (Sprite s : spriteList) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d A drawSurface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : spriteList) {
            s.drawOn(d);
        }
    }
}