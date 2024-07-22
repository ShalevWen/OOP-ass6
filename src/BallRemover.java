// 32923819 Shalev Wengrowsky

/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game           the game
     * @param remainingBalls the remaining balls
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * Remove the hit ball from the game.
     *
     * @param beingHit the object that's being hit
     * @param hitter   the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
