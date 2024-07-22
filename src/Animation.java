// 32923819 Shalev Wengrowsky

import biuoop.DrawSurface;

/**
 * The interface Animation.
 */
public interface Animation {
    /**
     * In charge of the logic.
     *
     * @param d the drawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * In charge of stopping condition.
     *
     * @return true if the animation loop should stop, false otherwise
     */
    boolean shouldStop();
}