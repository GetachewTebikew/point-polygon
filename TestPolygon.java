import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestPolygon {
    
    @Test
    public void testPolygon() {
        ArrayList<Point> vertexPoints = new ArrayList<Point>() {
            {
                    add(new Point(0, 0));
                    add(new Point(3, 0));
                    add(new Point(3, 4));
            }
    };
            Polygon polygon = new Polygon(vertexPoints);
            assertEquals(new Point(0, 0), polygon.vertexPoints.get(0)); 
            assertEquals(new Point(3, 0), polygon.vertexPoints.get(1)); 
            assertEquals(new Point(3, 4), polygon.vertexPoints.get(2)); 
        
    }
}
