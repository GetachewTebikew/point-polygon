import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestPoint {
    @Test
    public void testPointConstructor() {
      Point point=new Point(10, 20);
      assertEquals(10, point.x);  
      assertEquals(20, point.y);
    }
}
