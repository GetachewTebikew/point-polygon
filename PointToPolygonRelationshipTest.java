import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * PointToPolygonRelationshipTest
 */
public class PointToPolygonRelationshipTest {
    @Test
    public void testOctagon() {
        ArrayList<Point> vertexPoints = new ArrayList<Point>() {
            {
                add(new Point(0, 1));
                add(new Point(1, 0));
                add(new Point(2, 0));
                add(new Point(3, 1));
                add(new Point(3, 2));
                add(new Point(2, 3));
                add(new Point(1, 3));
                add(new Point(0, 2));
            }
        };
        // System.out.println(vertexPoints);

        Polygon octagon = new Polygon(vertexPoints);
        Point pointInside = new Point(1, 1);
        Point pointOutside = new Point(10, 15);
        Point pointOnBorder = new Point(1.5, 0);

        // System.out.println(octagon.pointToPolygonRelation(pointInside));
        assertEquals(PointStatus.INSIDE_POLYGON, octagon.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON, octagon.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON, octagon.pointToPolygonRelation(pointInside));

        assertEquals(PointStatus.OUTSIDE_POLYGON, octagon.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.INSIDE_POLYGON, octagon.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON, octagon.pointToPolygonRelation(pointOutside));

        assertEquals(PointStatus.ON_BORDER_OF_POLYGON, octagon.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.INSIDE_POLYGON, octagon.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON, octagon.pointToPolygonRelation(pointOnBorder));
    }

    @Test
    public void testTriangle() {
        ArrayList<Point> vertexPoints = new ArrayList<Point>() {
            {
                add(new Point(0, 0));
                add(new Point(3, 0));
                add(new Point(3, 4));
            }
        };
        // System.out.println(vertexPoints);

        Polygon triangle = new Polygon(vertexPoints);
        Point pointInside = new Point(1, 1);
        Point pointOutside = new Point(3, 9);
        Point pointOnBorder = new Point(3,3);

        System.out.println(triangle.pointToPolygonRelation(pointInside));
        assertEquals(PointStatus.INSIDE_POLYGON, triangle.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON, triangle.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON, triangle.pointToPolygonRelation(pointInside));

        assertEquals(PointStatus.OUTSIDE_POLYGON, triangle.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.INSIDE_POLYGON, triangle.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON, triangle.pointToPolygonRelation(pointOutside));

        assertEquals(PointStatus.ON_BORDER_OF_POLYGON, triangle.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.INSIDE_POLYGON, triangle.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON, triangle.pointToPolygonRelation(pointOnBorder));
    }
}