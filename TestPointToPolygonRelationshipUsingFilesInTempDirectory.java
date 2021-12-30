import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestPointToPolygonRelationshipUsingFilesInTempDirectory
        extends AbstractTestPointToPolygonRelationshipWithOrWithoutFile {

    @Test
    public void testTriangleFromFile() {
        IOperations.persistPolygon(polygonFilePath, getTriangle());
        IOperations.persistPoints(pointsFilePath,
                getTriangleTestPoints());
        ArrayList<Point> testPoints = IOperations
                .getPointsFromFile(pointsFilePath);
        Polygon triangle = IOperations.getPolygonFromFile(polygonFilePath);

        ArrayList<String> analysis = new ArrayList<String>();
        for (Point point : testPoints) {
            String status = PointToPolygonRelationship.pointToPolygonRelation(point, triangle);
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

        ArrayList<String> analysis = new ArrayList<String>();
        for (Point point : testPoints) {
            String status = PointToPolygonRelationship.pointToPolygonRelation(point, rectangle);
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

        ArrayList<String> analysis = new ArrayList<String>();
        for (Point point : testPoints) {
            String status = PointToPolygonRelationship.pointToPolygonRelation(point, octagon);
            analysis.add(status);
        }

        IOperations.writeAnalysis(analysisFilePath, analysis);

        ArrayList<String> expectedPointStatuses = getAnalysisResults();
        assertEquals(expectedPointStatuses, IOperations.getAnalysis(analysisFilePath));

    }
}
