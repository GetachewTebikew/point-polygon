import java.util.ArrayList;

public class Polygon {
    ArrayList<Point> vertexpPoints;
    public Polygon(ArrayList<Point> vertexPoints) {
        super();
        this.vertexpPoints = vertexPoints;
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

        for (int i = 0; i < vertexpPoints.size() - 1; i++) {
            Point currentVertex = vertexpPoints.get(i);
            Point nextVertex = vertexpPoints.get(i+1);

            int currentSide = (int) ((point.y - currentVertex.y) * (nextVertex.x - currentVertex.x)
                    - (point.x - currentVertex.x) * (nextVertex.y - currentVertex.y));

            if (currentSide > 0) {
                rightSide = true;
            } else if (currentSide == 0) {
                return PointStatus.ON_BORDER_OF_POLYGON;
            }else
            {
                leftSide = true;
            }
        }

        if ((rightSide == true && !leftSide) || (rightSide == false && leftSide)) {
            return PointStatus.INSIDE_POLYGON;
        } else {
            return PointStatus.OUTSIDE_POLYGON;
        }
    }
}
