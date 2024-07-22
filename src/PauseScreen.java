// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

/**
 * The type Pause screen.
 */
public class PauseScreen implements Animation {
    @Override
    public void doOneFrame(DrawSurface d) {
        String message = "paused -- press space to continue";
        d.drawText((d.getWidth() - message.length() * 13) / 2, d.getHeight() / 2, message, 32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}