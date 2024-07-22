// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private int count;
    private final SpriteCollection gameScreen;
    private final int framesPerNumber;
    private int framesSinceLastNumber;
    private final AnimationRunner runner;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     * @param runner       the runner
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, AnimationRunner runner) {
        this.count = countFrom;
        this.gameScreen = gameScreen;
        this.framesPerNumber = (int) (numOfSeconds / countFrom * 60);
        this.framesSinceLastNumber = 0;
        this.runner = runner;
    }

    /**
     * Run.
     */
    public void run() {
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        d.setColor(Color.WHITE);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, String.valueOf(this.count), 70);
        framesSinceLastNumber++;
        if (this.framesSinceLastNumber == this.framesPerNumber) {
            this.framesSinceLastNumber = 0;
            count--;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.count == 0;
    }
}