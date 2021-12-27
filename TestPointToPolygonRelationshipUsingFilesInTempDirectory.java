import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestPointToPolygonRelationshipUsingFilesInTempDirectory
        extends AbstractTestPointToPolygonRelationshipWithOrWithoutFile {

    @Test
    public void testTriangleFromFile() {
        IOperations.persistPolygon(polygonFilePath, getTriangle());
        IOperations.persistPoints("",
                getTriangleTestPoints());
        ArrayList<Point> testPoints = IOperations
                .getPointsFromFile(pointsFilePath);
        Polygon triangle = IOperations.getPolygonFromFile(polygonFilePath);

        ArrayList<PointStatus> analysis = new ArrayList<PointStatus>();
        for (Point point : testPoints) {
            PointStatus status = PointToPolygonRelationship.pointToPolygonRelation(point, triangle);
            analysis.add(status);
        }

        IOperations.writeAnalysis(analysisFilePath, analysis);

        assertEquals(getAnalysisResults(), IOperations.getAnalysis(analysisFilePath));
    }

    @Test
    public void testRectangleFromFile() {
        IOperations.persistPolygon(polygonFilePath, getRectangle());
        IOperations.persistPoints(pointsFilePath,
                getRectangleTestPoints());
        ArrayList<Point> testPoints = IOperations
                .getPointsFromFile(pointsFilePath);
        Polygon rectangle = IOperations.getPolygonFromFile(polygonFilePath);

        ArrayList<PointStatus> analysis = new ArrayList<PointStatus>();
        for (Point point : testPoints) {
            PointStatus status = PointToPolygonRelationship.pointToPolygonRelation(point, rectangle);
            analysis.add(status);
        }

        IOperations.writeAnalysis(analysisFilePath, analysis);

        assertEquals(getAnalysisResults(), IOperations.getAnalysis(analysisFilePath));
    }

    @Test
    public void testOctagonFromFile() {
        IOperations.persistPolygon(polygonFilePath, getOctagon());
        IOperations.persistPoints(pointsFilePath,
                getOctagonTestPoints());
        ArrayList<Point> testPoints = IOperations
                .getPointsFromFile(pointsFilePath);
        Polygon octagon = IOperations.getPolygonFromFile(polygonFilePath);

        ArrayList<PointStatus> analysis = new ArrayList<PointStatus>();
        for (Point point : testPoints) {
            PointStatus status = PointToPolygonRelationship.pointToPolygonRelation(point, octagon);
            analysis.add(status);
            System.out.println(status);
        }

        IOperations.writeAnalysis(analysisFilePath, analysis);

        assertEquals(getAnalysisResults(), IOperations.getAnalysis(analysisFilePath));
    }
}