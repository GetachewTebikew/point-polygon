import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestIOperations extends AbstractTestPointToPolygonRelationshipWithOrWithoutFile {
    @Before
    public void testPersistPoints() {
        assertEquals(true, IOperations.persistPoints(pointsFilePath, getOctagonTestPoints()));
    }

    @Before
    public void testPersistPolygon() {
        assertEquals(true, IOperations.persistPolygon(polygonFilePath, getOctagon()));
    }

    @Test
    public void testGetPointsFromFile() {

        ArrayList<Point> points = IOperations.getPointsFromFile(pointsFilePath);

        int index = 0;
        for (Point point : getOctagonTestPoints()) {
            assertEquals(true, point.equals(points.get(index)));
            index += 1;
        }
    }

    @Test
    public void testGetPolygonFromFile() {
        Polygon polygon = IOperations.getPolygonFromFile(polygonFilePath);
        int index = 0;
        for (Point point : getOctagon().vertexPoints) {
            assertEquals(true, point.equals(polygon.vertexPoints.get(index)));
            index += 1;
        }
    }

    @Before
    public void testWriteAnalysis() {
        assertEquals(true, IOperations.writeAnalysis(analysisFilePath, getAnalysisResults()));
    }

    @Test
    public void testGetAnalysis() {
        assertEquals(getAnalysisResults().toString(), IOperations.getAnalysis(analysisFilePath).toString());
    }

}
