import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * PointToPolygonRelationshipTest
 */
public class PointToPolygonRelationshipTest {
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
        Point pointOnBorder = new Point(3, 3);
        // POINT INSIDE
        assertEquals(PointStatus.INSIDE_POLYGON,
                triangle.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                triangle.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                triangle.pointToPolygonRelation(pointInside));
        // POINT OUTSIDE
        assertEquals(PointStatus.OUTSIDE_POLYGON,
                triangle.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.INSIDE_POLYGON,
                triangle.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                triangle.pointToPolygonRelation(pointOutside));
        // POINT ON BORDER
        assertEquals(PointStatus.ON_BORDER_OF_POLYGON,
                triangle.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.INSIDE_POLYGON,
                triangle.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                triangle.pointToPolygonRelation(pointOnBorder));
    }

    @Test
    public void testRectangle() {
        ArrayList<Point> vertexPoints = new ArrayList<Point>() {
            {
                add(new Point(0, 0));
                add(new Point(3, 0));
                add(new Point(3, 4));
                add(new Point(0, 4));
            }
        };
        // System.out.println(vertexPoints);

        Polygon rectangle = new Polygon(vertexPoints);
        Point pointInside = new Point(1, 1);
        Point pointOutside = new Point(3, 9);
        Point pointOnBorder = new Point(3, 3);
        // POINT INSIDE
        assertEquals(PointStatus.INSIDE_POLYGON,
                rectangle.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                rectangle.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                rectangle.pointToPolygonRelation(pointInside));
        // POINT OUTSIDE
        assertEquals(PointStatus.OUTSIDE_POLYGON,
                rectangle.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.INSIDE_POLYGON,
                rectangle.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                rectangle.pointToPolygonRelation(pointOutside));
        // POINT ON BORDER
        assertEquals(PointStatus.ON_BORDER_OF_POLYGON,
                rectangle.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.INSIDE_POLYGON,
                rectangle.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                rectangle.pointToPolygonRelation(pointOnBorder));
    }

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
        Polygon octagon = new Polygon(vertexPoints);
        Point pointInside = new Point(1, 1);
        Point pointOutside = new Point(10, 15);
        Point pointOnBorder = new Point(1.5, 0);

        // POINT INSIDE
        assertEquals(PointStatus.INSIDE_POLYGON,
                octagon.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                octagon.pointToPolygonRelation(pointInside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                octagon.pointToPolygonRelation(pointInside));

        // POINT OUTSIDE
        assertEquals(PointStatus.OUTSIDE_POLYGON,
                octagon.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.INSIDE_POLYGON,
                octagon.pointToPolygonRelation(pointOutside));
        assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                octagon.pointToPolygonRelation(pointOutside));

        // POINT ON BORDER
        assertEquals(PointStatus.ON_BORDER_OF_POLYGON,
                octagon.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.INSIDE_POLYGON,
                octagon.pointToPolygonRelation(pointOnBorder));
        assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                octagon.pointToPolygonRelation(pointOnBorder));
    }

    @Test
    public void testOctagonFromFile() {
        ArrayList<Point> testPoints = IOperations
                .getTestPointsFromFile("/home/getish/Desktop/upjs-1/points.txt");
        Polygon octagon = IOperations.getPolygonFromFile("/home/getish/Desktop/upjs-1/polygon.txt");

        ArrayList<PointStatus> analysisResults = new ArrayList<PointStatus>();
        for (Point point : testPoints) {
            PointStatus status = octagon.pointToPolygonRelation(point);
            analysisResults.add(status);
            System.out.println(status.toString());
        }

        IOperations.writeAnalysis("/home/getish/Desktop/upjs-1/analysis.txt", analysisResults);
        String[] expected = new String[] {
                PointStatus.INSIDE_POLYGON.toString(),
                PointStatus.OUTSIDE_POLYGON.toString(),
                PointStatus.OUTSIDE_POLYGON.toString(),
                PointStatus.OUTSIDE_POLYGON.toString()
        };
        assertNotEquals(expected, IOperations.getAnalysis("/home/getish/Desktop/upjs-1/analysis.txt"));
    }

}
