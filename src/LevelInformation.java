// 329238919 Shalev Wengrowsky

import java.util.List;

/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls in the level.
     *
     * @return the int
     */
    int numberOfBalls();

    /**
     * Initial ball velocities list.
     *
     * @return the list
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed int.
     *
     * @return the int
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     *
     * @return the int
     */
    int paddleWidth();

    /**
     * The level name will be displayed at the top of the screen.
     *
     * @return the string
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level
     */
    LevelBackground getBackground();

    /**
     * Return a list containing the Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return a list containing the Blocks that make up this level, each block contains
     * its size, color and location.
     */

    List<Block> blocks();

    /**
     * Return the number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return the number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}