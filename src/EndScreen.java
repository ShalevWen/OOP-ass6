// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private final String message;

    /**
     * Instantiates a new Pause screen.
     *
     * @param message the message
     */
    public EndScreen(String message) {
        this.message = message;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText((d.getWidth() - this.message.length() * 13) / 2, d.getHeight() / 2, this.message, 32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}