// 329238919 Shalev Wengrowsky

import java.util.List;

/**
 * Represents a line in a 2D plane.
 */
public class Line {
    private final Point start;
    private final Point end;

    /**
     * Creates new Line object from the two end points.
     *
     * @param start The start point of the line.
     * @param end   The end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Creates new Line object from the x and y coordinates of the end points.
     *
     * @param x1 The x coordinate of the start point of the line.
     * @param y1 The y coordinate of the start point of the line.
     * @param x2 The x coordinate of the end point of the line.
     * @param y2 The y coordinate of the end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Return the length of the line segment.
     *
     * @return The length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return The middle point of the line.
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2,
                (this.start.getY() + this.end.getY()) / 2);
    }

    /**
     * Returns the start point of the line.
     *
     * @return The start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return The end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     *
     * @param other A line to check intersection with.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        /* All the calculations are being preformed using formulas from
         * https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection#Given_two_points_on_each_line_segment */
        double den = (this.start.getX() - this.end.getX()) * (other.start.getY() - other.end.getY())
                - (this.start.getY() - this.end.getY()) * (other.start.getX() - other.end.getX());
        if (den == 0) {
            return false;
        }
        double t = ((this.start.getX() - other.start().getX()) * (other.start().getY() - other.end().getY())
                - (this.start.getY() - other.start().getY()) * (other.start().getX() - other.end().getX())) / den;
        double u = ((this.start.getX() - other.start().getX()) * (this.start.getY() - this.end.getY())
                - (this.start.getY() - other.start().getY()) * (this.start.getX() - this.end.getX())) / den;
        return (0 < t && t <= 1 && 0 <= u && u <= 1);
    }

    /**
     * Returns the intersection point if the lines intersect, null otherwise.
     *
     * @param other A line to find the intersection point with.
     * @return the intersection point if the lines intersect, null otherwise.
     */
    public Point intersectionWith(Line other) {
        /* All the calculations are being preformed using formulas from
         * https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection#Given_two_points_on_each_line_segment */
        if (!isIntersecting(other)) {
            return null;
        }
        double den = (this.start.getX() - this.end.getX()) * (other.start.getY() - other.end.getY())
                - (this.start.getY() - this.end.getY()) * (other.start.getX() - other.end.getX());
        double t = ((this.start.getX() - other.start().getX()) * (other.start().getY() - other.end().getY())
                - (this.start.getY() - other.start().getY()) * (other.start().getX() - other.end().getX())) / den;
        return new Point(this.start.getX() + t * (this.end.getX() - this.start.getX()),
                this.start.getY() + t * (this.end.getY() - this.start.getY()));
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect The rectangle which we want to find the intersection with.
     * @return null if the line does not intersect with the rectangle,
     * or the closest intersection to the start of the line if it does.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        if (intersectionPoints.isEmpty()) {
            return null;
        }
        Point closest = (Point) intersectionPoints.toArray()[0];
        double distance = this.start.distance(closest);
        for (Point point : intersectionPoints) {
            if (this.start.distance(point) < distance) {
                closest = point;
                distance = this.start.distance(point);
            }
        }
        return closest;
    }

    /**
     * Returns true if the two line segment are equal, false otherwise.
     *
     * @param other A line to check equality with.
     * @return true if the two line segment are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return ((this.start == other.start() && this.end == other.end())
                || (this.start == other.end() && this.end == other.start()));
    }
}
