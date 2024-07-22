// 329238919 Shalev Wengrowsky

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible to handle the collision mechanics.
 */
public class GameEnvironment {
    private final List<Collidable> collidableList;

    /**
     * Creates new GameEnvironment object.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<>();
    }

    /**
     * Add the given collidable to the environment.
     *
     * @param c collidable to add to the gameEnvironment.
     */
    public void addCollidable(Collidable c) {
        collidableList.add(c);
    }

    /**
     * Remove the given collidable from the environment.
     *
     * @param c collidable to remove from the gameEnvironment.
     */
    public void removeCollidable(Collidable c) {
        collidableList.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory The trajectory of a collidable who we want to check collision for.
     * @return CollisionInfo object with the closest collision info.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Collidable closestCollidable = null;
        Point closestPoint = null;
        double distance = Double.POSITIVE_INFINITY;
        List<Collidable> collidableList = new ArrayList<>(this.collidableList);
        for (Collidable c : collidableList) {
            Point p = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            double d = trajectory.start().distance(p);
            if (d < distance) {
                closestCollidable = c;
                closestPoint = p;
                distance = d;
            }
        }
        if (distance == Double.POSITIVE_INFINITY) {
            return null;
        }
        return new CollisionInfo(closestPoint, closestCollidable);
    }

}