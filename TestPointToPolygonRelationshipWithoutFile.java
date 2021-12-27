import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * TestPointToPolygonRelationshipWithOrWithoutFile
 */

public class TestPointToPolygonRelationshipWithoutFile extends AbstractTestPointToPolygonRelationshipWithOrWithoutFile {
        @Test
        public void testTriangle() {
                Polygon triangle = getTriangle();
                ArrayList<Point> testPoints = getTriangleTestPoints();
                // POINT INSIDE
                assertEquals(PointStatus.INSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(testPoints.get(0), triangle));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(testPoints.get(0), triangle));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(testPoints.get(0), triangle));
                // POINT OUTSIDE
                assertEquals(PointStatus.OUTSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(testPoints.get(1), triangle));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(testPoints.get(1), triangle));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(testPoints.get(1), triangle));
                // POINT ON BORDER
                assertEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(testPoints.get(2), triangle));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(testPoints.get(2), triangle));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(testPoints.get(2), triangle));
        }

        @Test
        public void testRectangle() {
                Polygon rectangle = getRectangle();
                ArrayList<Point> rectangleTestPoints = getRectangleTestPoints();
                // POINT INSIDE
                assertEquals(PointStatus.INSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(rectangleTestPoints.get(0),
                                                rectangle));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(rectangleTestPoints.get(0),
                                                rectangle));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(rectangleTestPoints.get(0),
                                                rectangle));
                // POINT OUTSIDE
                assertEquals(PointStatus.OUTSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(rectangleTestPoints.get(1),
                                                rectangle));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(rectangleTestPoints.get(1),
                                                rectangle));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(rectangleTestPoints.get(1),
                                                rectangle));
                // POINT ON BORDER
                assertEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(rectangleTestPoints.get(2),
                                                rectangle));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(rectangleTestPoints.get(2),
                                                rectangle));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(rectangleTestPoints.get(2),
                                                rectangle));
        }

        @Test
        public void testOctagon() {
                Polygon octagon = getOctagon();
                ArrayList<Point> octagonTestPoints = getOctagonTestPoints();
                // POINT INSIDE
                assertEquals(PointStatus.INSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(octagonTestPoints.get(0), octagon));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(octagonTestPoints.get(0), octagon));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(octagonTestPoints.get(0), octagon));

                // POINT OUTSIDE
                assertEquals(PointStatus.OUTSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(octagonTestPoints.get(1), octagon));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(octagonTestPoints.get(1), octagon));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(octagonTestPoints.get(1), octagon));

                // POINT ON BORDER
                assertEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(octagonTestPoints.get(2), octagon));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(octagonTestPoints.get(2), octagon));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                PointToPolygonRelationship.pointToPolygonRelation(octagonTestPoints.get(2), octagon));
        }

}
