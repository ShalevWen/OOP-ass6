// 329238919 Shalev Wengrowsky

/**
 * The interface Hit listener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the object that's being hit
     * @param hitter   the Ball that's doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}