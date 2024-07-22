// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private final Counter currentScore;

    /**
     * Instantiates a new Score indicator.
     *
     * @param currentScore the current score counter
     */
    public ScoreIndicator(Counter currentScore) {
        this.currentScore = currentScore;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(350, 17, "Score: " + this.currentScore.getValue(), 18);
    }

    @Override
    public void timePassed() { }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
