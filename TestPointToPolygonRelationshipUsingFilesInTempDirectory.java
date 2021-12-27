import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestPointToPolygonRelationshipUsingFilesInTempDirectory extends AbstractTestPointToPolygonRelationshipWithOrWithoutFile {

    @Test
    public void testTriangleFromFile() {
            IOperations.persistPolygon(getTriangle());
            IOperations.persistPoints("/home/getish/Desktop/upjs-1/points.txt",
                            getTriangleTestPoints());
            ArrayList<Point> testPoints = IOperations
                            .getPointsFromFile("/home/getish/Desktop/upjs-1/points.txt");
            Polygon triangle = IOperations.getPolygonFromFile("/home/getish/Desktop/upjs-1/polygon.txt");

            ArrayList<PointStatus> analysis = new ArrayList<PointStatus>();
            for (Point point : testPoints) {
                    PointStatus status =  PointToPolygonRelationship.pointToPolygonRelation(point,triangle);
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
                            .getPointsFromFile("/home/getish/Desktop/upjs-1/points.txt");
            Polygon rectangle = IOperations.getPolygonFromFile("/home/getish/Desktop/upjs-1/polygon.txt");

            ArrayList<PointStatus> analysis = new ArrayList<PointStatus>();
            for (Point point : testPoints) {
                    PointStatus status = PointToPolygonRelationship.pointToPolygonRelation(point,rectangle);
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
                            .getPointsFromFile("/home/getish/Desktop/upjs-1/points.txt");
            Polygon octagon = IOperations.getPolygonFromFile("/home/getish/Desktop/upjs-1/polygon.txt");

            ArrayList<PointStatus> analysis = new ArrayList<PointStatus>();
            for (Point point : testPoints) {
                    PointStatus status = PointToPolygonRelationship.pointToPolygonRelation(point,octagon);
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
}