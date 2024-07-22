// 329238919 Shalev Wengrowsky

/**
 * Represents a point on a 2D plane.
 */
public class Point {
    private final double x;   //x coordinate of the point.
    private final double y;   //y coordinate of the point.

    /**
     * Creates new Point object.
     *
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance between the two point.
     *
     * @param other The point to which we want to get the distance.
     * @return double The distance between the points.
     */
    public double distance(Point other) {
        if (other == null) {
            return Double.POSITIVE_INFINITY;
        }
        return Math.sqrt((this.x - other.getX()) * (this.x - other.getX())
                + (this.y - other.getY()) * (this.y - other.getY()));
    }

    /**
     * Returns true if the points are the same, or false otherwise.
     *
     * @param other The other point.
     * @return boolean True if the points are the same, or false otherwise.
     */
    public boolean equals(Point other) {
        return (this.x == other.getX() && this.y == other.getY());
    }

    /**
     * Returns the x coordinate of the point.
     *
     * @return double The x coordinate of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Returns the y coordinate of the point.
     *
     * @return double The y coordinate of the point.
     */
    public double getY() {
        return this.y;
    }
}
