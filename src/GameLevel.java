// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The main class of the game, all the animation and movement id done from here.
 */
public class GameLevel implements Animation {
    private final SpriteCollection sprites;
    private final GameEnvironment environment;
    private final Counter remainingBlocksToRemove;
    private final Counter remainingBalls;
    private final Counter currentScore;
    private final AnimationRunner runner;
    private boolean running;
    private final KeyboardSensor keyboard;
    private final LevelInformation levelInformation;


    /**
     * Instantiates a new GameLevel.
     *
     * @param levelInformation the level information
     * @param keyboard         the keyboard
     * @param runner           the runner
     * @param score            the total score counter
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard,
                     AnimationRunner runner, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocksToRemove = new Counter();
        this.remainingBlocksToRemove.increase(levelInformation.numberOfBlocksToRemove());
        this.remainingBalls = new Counter();
        this.remainingBalls.increase(levelInformation.numberOfBalls());
        this.currentScore = score;
        this.runner = runner;
        this.running = false;
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;
    }

    /**
     * Add a collidable to the game.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Remove a collidable from the game.
     *
     * @param c the collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Add a sprite to the game.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Remove a sprite from the game.
     *
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        /* Adding listeners. */
        BlockRemover blockListener = new BlockRemover(this, this.remainingBlocksToRemove);
        BallRemover ballListener = new BallRemover(this, this.remainingBalls);
        ScoreTrackingListener scoreListener = new ScoreTrackingListener(this.currentScore);
        /* Adding the walls. */
        Block deathPlane = new Block(19, 19, 762, 581, Color.BLACK);
        deathPlane.addToGame(this);
        deathPlane.addHitListener(ballListener);
        this.levelInformation.getBackground().addToGame(this);
        new Block(0, 0, 800, 20, Color.GRAY).addToGame(this);
        new Block(0, 20, 25, 580, Color.GRAY).addToGame(this);
        new Block(775, 20, 25, 580, Color.GRAY).addToGame(this);
        /* Adding the top HUD elements */
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.currentScore);
        scoreIndicator.addToGame(this);
        new LevelIndicator(this.levelInformation.levelName()).addToGame(this);
        /* Adding the blocks. */
        for (Block block : this.levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(blockListener);
            block.addHitListener(scoreListener);
        }
    }

    /**
     * Run the game -- start the animation loop.
     *
     * @return true if the player won the level, false otherwise
     */
    public boolean run() {
        this.createBallsAndPaddle();
        new CountdownAnimation(2, 3, this.sprites, this.runner).run();
        this.running = true;
        this.runner.run(this);
        // adding score for winning
        if (this.remainingBalls.getValue() == 0) {
            return false;
        }
        this.currentScore.increase(100);
        return true;
    }

    /**
     * Create the balls and the paddle.
     */
    void createBallsAndPaddle() {
        /* Adding the balls. */
        for (Velocity v : this.levelInformation.initialBallVelocities()) {
            Ball ball = new Ball(400, 550, 5, Color.WHITE, this.environment);
            ball.setVelocity(v);
            ball.addToGame(this);
        }
        /* Adding the paddle. */
        Paddle paddle = new Paddle(this.levelInformation.paddleSpeed(),
                this.levelInformation.paddleWidth(), keyboard);
        paddle.addToGame(this);
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "space", new PauseScreen()));
        }

        if (this.remainingBlocksToRemove.getValue() == 0 || this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
    }
}