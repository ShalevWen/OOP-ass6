// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 */
public class LevelIndicator implements Sprite {
    private final String levelName;

    /**
     * Instantiates a new Score indicator.
     *
     * @param levelName the level name
     */
    public LevelIndicator(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        String levelMessage = "Level: " + this.levelName;
        d.drawText(750 - levelMessage.length() * 13, 17, levelMessage, 18);
    }

    @Override
    public void timePassed() { }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
