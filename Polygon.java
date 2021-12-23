import java.util.ArrayList;

public class Polygon {
    ArrayList<Point> vertexPoints;

    public Polygon(ArrayList<Point> vertexPoints) {
        this.vertexPoints = vertexPoints;
    }

    // A point is on the interior of this polygons if it is always
    // on the same side of all the line segments making up the path.

    // Given a line segment between P0 (x0,y0) and P1 (x1,y1),
    // another point P (x,y) has the following relationship to the line segment.

    // Compute
    // (y - y0) (x1 - x0) - (x - x0) (y1 - y0)
    // if it is less than 0 then P is to the right of the line segment,
    // if greater than 0 it is to the left, if equal to 0 then it lies on the line
    // segment

    public PointStatus pointToPolygonRelation(Point point) {
        boolean leftSide = false;
        boolean rightSide = false;
        // System.out.println("Point:" + point.x + " , " + point.y);
        // System.out.println(vertexPoints);
        for (int i = 0; i < vertexPoints.size(); i++) {
            Point currentVertex = vertexPoints.get(i);
            // System.out.println("Current vertex:" + currentVertex + " , " +
            // currentVertex.y);

            Point nextVertex = i < vertexPoints.size() - 1 ? vertexPoints.get(i + 1) : vertexPoints.get(0);

            int currentSide = (int) ((point.y - currentVertex.y)
                    * (nextVertex.x - currentVertex.x)
                    - (point.x - currentVertex.x)
                            * (nextVertex.y - currentVertex.y));

            System.out.println(currentSide);

            if (currentSide == 0) {
                // check if the point is bounded between vertices
                boolean boundedOnX = currentVertex.x <= point.x && point.x <= nextVertex.x;
                boolean boundedOnY = currentVertex.y <= point.y && point.y <= nextVertex.y;
                if (boundedOnX && boundedOnY) { // on border line
                    return PointStatus.ON_BORDER_OF_POLYGON;
                }
            }

            if (currentSide < 0) { // right side
                rightSide = true;
            } else { // left side
                leftSide = true;
            }
        }

        // System.out.println("#############################");
        if (rightSide ^ leftSide) { // no direction change
            return PointStatus.INSIDE_POLYGON;
        } else { // there is direction change
            return PointStatus.OUTSIDE_POLYGON;
        }
    }
}
