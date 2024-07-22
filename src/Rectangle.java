// 329238919 Shalev Wengrowsky

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a rectangle in 2D plane.
 */
public class Rectangle {
    private final Point upperLeft;
    private final double width;
    private final double height;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft The top left corner of the rectangle.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Return a (possibly empty) List of intersection points
     * with the given line.
     *
     * @param line The line to find intersection points with.
     *
     * @return A (possibly empty) list of the intersection points with the line.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<>();
        /* Creating an array of the corners of the rectangle. */
        Point[] corners = new Point[4];
        corners[0] = this.upperLeft;
        corners[1] = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        corners[2] = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        corners[3] = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        /* Creating an array of the sides of the rectangle. */
        Line[] sides = new Line[4];
        sides[0] = new Line(corners[0], corners[1]);
        sides[1] = new Line(corners[1], corners[2]);
        sides[2] = new Line(corners[2], corners[3]);
        sides[3] = new Line(corners[3], corners[0]);

        /* Adding the intersection points to the list. */
        for (Line side : sides) {
            Point intersection = line.intersectionWith(side);
            if (intersection != null) {
                intersectionPoints.add(intersection);
            }
        }
        return intersectionPoints;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }


    /**
     * Returns the top left corner of the rectangle.
     *
     * @return The top left corner of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}