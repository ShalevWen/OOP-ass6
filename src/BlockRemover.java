// 329238919 Shalev Wengrowsky

/**
 *  A BlockRemover is in charge of removing blocks from the game, as well as keeping count
 *  of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param game             the game
     * @param remainingBlocks the remaining blocks counter
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * Remove the hit block from the game.
     *
     * @param beingHit the object that's being hit
     * @param hitter   the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
    }
}