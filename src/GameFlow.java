// 329238919 Shalev Wengrowsky

import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private final AnimationRunner animationRunner;
    private final KeyboardSensor keyboardSensor;
    private final Counter totalScore;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar  the animationRunner
     * @param ks  the keyboardSensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.totalScore = new Counter();
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean isWinner = true;
        // ...
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.totalScore);

            level.initialize();

            if (!level.run()) {
                // if the player lost all the balls
                isWinner = false;
                break;
            }

        }
        String message;
        if (isWinner) {
            message = "You Win! Your score is " + this.totalScore.getValue();
        } else {
            message = "Game Over. Your score is " + this.totalScore.getValue();
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                "space", new EndScreen(message)));
    }
}