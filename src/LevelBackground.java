import biuoop.DrawSurface;

/**
 * The type Level background.
 */
public abstract class LevelBackground implements Sprite {
    @Override
    public abstract void drawOn(DrawSurface d);

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
