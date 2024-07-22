// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

/**
 * Represents any type of sprite (ball, block, paddle etc.).
 */
public interface Sprite {

    /**
     * Draw the sprite to the screen.
     *
     * @param d The drawSurface to draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * Notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * add the sprite to the game.
     *
     * @param g the game
     */
    void addToGame(GameLevel g);
}