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
                Polygon triangle = getTriangle();
                ArrayList<Point> testPoints = getTriangleTestPoints();
                // POINT INSIDE
                assertEquals(PointStatus.INSIDE_POLYGON,
                                triangle.pointToPolygonRelation(testPoints.get(0)));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                triangle.pointToPolygonRelation(testPoints.get(0)));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                triangle.pointToPolygonRelation(testPoints.get(0)));
                // POINT OUTSIDE
                assertEquals(PointStatus.OUTSIDE_POLYGON,
                                triangle.pointToPolygonRelation(testPoints.get(1)));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                triangle.pointToPolygonRelation(testPoints.get(1)));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                triangle.pointToPolygonRelation(testPoints.get(1)));
                // POINT ON BORDER
                assertEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                triangle.pointToPolygonRelation(testPoints.get(2)));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                triangle.pointToPolygonRelation(testPoints.get(2)));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                triangle.pointToPolygonRelation(testPoints.get(2)));
        }

        @Test
        public void testRectangle() {
                Polygon rectangle = getRectangle();
                ArrayList<Point> rectangleTestPoints = getRectangleTestPoints();
                // POINT INSIDE
                assertEquals(PointStatus.INSIDE_POLYGON,
                                rectangle.pointToPolygonRelation(rectangleTestPoints.get(0)));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                rectangle.pointToPolygonRelation(rectangleTestPoints.get(0)));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                rectangle.pointToPolygonRelation(rectangleTestPoints.get(0)));
                // POINT OUTSIDE
                assertEquals(PointStatus.OUTSIDE_POLYGON,
                                rectangle.pointToPolygonRelation(rectangleTestPoints.get(1)));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                rectangle.pointToPolygonRelation(rectangleTestPoints.get(1)));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                rectangle.pointToPolygonRelation(rectangleTestPoints.get(1)));
                // POINT ON BORDER
                assertEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                rectangle.pointToPolygonRelation(rectangleTestPoints.get(2)));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                rectangle.pointToPolygonRelation(rectangleTestPoints.get(2)));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                rectangle.pointToPolygonRelation(rectangleTestPoints.get(2)));
        }

        @Test
        public void testOctagon() {
                Polygon octagon = getOctagon();
                ArrayList<Point> octagonTestPoints = getOctagonTestPoints();
                // POINT INSIDE
                assertEquals(PointStatus.INSIDE_POLYGON,
                                octagon.pointToPolygonRelation(octagonTestPoints.get(0)));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                octagon.pointToPolygonRelation(octagonTestPoints.get(0)));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                octagon.pointToPolygonRelation(octagonTestPoints.get(0)));

                // POINT OUTSIDE
                assertEquals(PointStatus.OUTSIDE_POLYGON,
                                octagon.pointToPolygonRelation(octagonTestPoints.get(1)));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                octagon.pointToPolygonRelation(octagonTestPoints.get(1)));
                assertNotEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                octagon.pointToPolygonRelation(octagonTestPoints.get(1)));

                // POINT ON BORDER
                assertEquals(PointStatus.ON_BORDER_OF_POLYGON,
                                octagon.pointToPolygonRelation(octagonTestPoints.get(2)));
                assertNotEquals(PointStatus.INSIDE_POLYGON,
                                octagon.pointToPolygonRelation(octagonTestPoints.get(2)));
                assertNotEquals(PointStatus.OUTSIDE_POLYGON,
                                octagon.pointToPolygonRelation(octagonTestPoints.get(2)));
        }

        @Test
        public void testTriangleFromFile() {
                IOperations.persistPolygon(getTriangle());
                IOperations.persistPoints("/home/getish/Desktop/upjs-1/points.txt",
                                getTriangleTestPoints());
                ArrayList<Point> testPoints = IOperations
                                .getTestPointsFromFile("/home/getish/Desktop/upjs-1/points.txt");
                Polygon triangle = IOperations.getPolygonFromFile("/home/getish/Desktop/upjs-1/polygon.txt");

                ArrayList<PointStatus> analysis = new ArrayList<PointStatus>();
                for (Point point : testPoints) {
                        PointStatus status = triangle.pointToPolygonRelation(point);
                        analysis.add(status);
                }

                IOperations.writeAnalysis("/home/getish/Desktop/upjs-1/analysis.txt", analysis);
                ArrayList<String> expected = new ArrayList<>() {
                        {
                                add(PointStatus.INSIDE_POLYGON.toString());
                                add(PointStatus.OUTSIDE_POLYGON.toString());
                                add(PointStatus.ON_BORDER_OF_POLYGON.toString());
                        }
                };
                assertEquals(expected, IOperations.getAnalysis("/home/getish/Desktop/upjs-1/analysis.txt"));
        }

        @Test
        public void testRectangleFromFile() {
                IOperations.persistPolygon(getRectangle());
                IOperations.persistPoints("/home/getish/Desktop/upjs-1/points.txt",
                                getRectangleTestPoints());
                ArrayList<Point> testPoints = IOperations
                                .getTestPointsFromFile("/home/getish/Desktop/upjs-1/points.txt");
                Polygon rectangle = IOperations.getPolygonFromFile("/home/getish/Desktop/upjs-1/polygon.txt");

                ArrayList<PointStatus> analysis = new ArrayList<PointStatus>();
                for (Point point : testPoints) {
                        PointStatus status = rectangle.pointToPolygonRelation(point);
                        analysis.add(status);
                }

                IOperations.writeAnalysis("/home/getish/Desktop/upjs-1/analysis.txt", analysis);
                ArrayList<String> expected = new ArrayList<>() {
                        {
                                add(PointStatus.INSIDE_POLYGON.toString());
                                add(PointStatus.OUTSIDE_POLYGON.toString());
                                add(PointStatus.ON_BORDER_OF_POLYGON.toString());
                        }
                };
                assertEquals(expected, IOperations.getAnalysis("/home/getish/Desktop/upjs-1/analysis.txt"));
        }

        @Test
        public void testOctagonFromFile() {
                IOperations.persistPolygon(getOctagon());
                IOperations.persistPoints("/home/getish/Desktop/upjs-1/points.txt",
                                getOctagonTestPoints());
                ArrayList<Point> testPoints = IOperations
                                .getTestPointsFromFile("/home/getish/Desktop/upjs-1/points.txt");
                Polygon octagon = IOperations.getPolygonFromFile("/home/getish/Desktop/upjs-1/polygon.txt");

                ArrayList<PointStatus> analysis = new ArrayList<PointStatus>();
                for (Point point : testPoints) {
                        PointStatus status = octagon.pointToPolygonRelation(point);
                        analysis.add(status);
                        System.out.println(status);
                }

                IOperations.writeAnalysis("/home/getish/Desktop/upjs-1/analysis.txt", analysis);
                ArrayList<String> expected = new ArrayList<>() {
                        {
                                add(PointStatus.INSIDE_POLYGON.toString());
                                add(PointStatus.OUTSIDE_POLYGON.toString());
                                add(PointStatus.ON_BORDER_OF_POLYGON.toString());
                        }
                };
                assertEquals(expected, IOperations.getAnalysis("/home/getish/Desktop/upjs-1/analysis.txt"));
        }

        Polygon getTriangle() {
                ArrayList<Point> vertexPoints = new ArrayList<Point>() {
                        {
                                add(new Point(0, 0));
                                add(new Point(3, 0));
                                add(new Point(3, 4));
                        }
                };

                Polygon triangle = new Polygon(vertexPoints);
                return triangle;
        }

        ArrayList<Point> getTriangleTestPoints() {
                Point pointInside = new Point(1, 1);
                Point pointOutside = new Point(3, 9);
                Point pointOnBorder = new Point(3, 3);
                return new ArrayList<Point>() {
                        {
                                add(pointInside);
                                add(pointOutside);
                                add(pointOnBorder);
                        }
                };
        }

        Polygon getRectangle() {
                ArrayList<Point> vertexPoints = new ArrayList<Point>() {
                        {
                                add(new Point(0, 0));
                                add(new Point(3, 0));
                                add(new Point(3, 4));
                                add(new Point(0, 4));
                        }
                };
                Polygon rectangle = new Polygon(vertexPoints);
                return rectangle;
        }

        ArrayList<Point> getRectangleTestPoints() {
                Point pointInside = new Point(1, 1);
                Point pointOutside = new Point(3, 9);
                Point pointOnBorder = new Point(3, 3);
                return new ArrayList<Point>() {
                        {
                                add(pointInside);
                                add(pointOutside);
                                add(pointOnBorder);
                        }
                };
        }

        Polygon getOctagon() {
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
                return octagon;
        }

        ArrayList<Point> getOctagonTestPoints() {
                Point pointInside = new Point(1, 1);
                Point pointOutside = new Point(10, 15);
                Point pointOnBorder = new Point(1.5, 0);

                ArrayList<Point> testPoints = new ArrayList<Point>() {
                        {
                                add(pointInside);
                                add(pointOutside);
                                add(pointOnBorder);
                        }
                };
                return testPoints;
        }
}
