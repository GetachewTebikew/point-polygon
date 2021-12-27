public class PointToPolygonRelationship {
     // A point is on the interior of this polygons if it is always
    // on the same side of all the line segments making up the path.

    // Given a line segment between P0 (x0,y0) and P1 (x1,y1),
    // another point P (x,y) has the following relationship to the line segment.

    // Compute
    // (y - y0) (x1 - x0) - (x - x0) (y1 - y0)
    // if it is less than 0 then P is to the right of the line segment,
    // if greater than 0 it is to the left, if equal to 0 then it lies on the line
    // segment

    public static PointStatus pointToPolygonRelation(Point point, Polygon polygon) {
        boolean leftSide = false;
        boolean rightSide = false;

        for (int i = 0; i < polygon.vertexPoints.size(); i++) {
            Point currentVertex = polygon.vertexPoints.get(i);
            Point nextVertex = i < polygon.vertexPoints.size() - 1 ? polygon.vertexPoints.get(i + 1) : polygon.vertexPoints.get(0);

            int currentSide = (int) ((point.y - currentVertex.y)
                    * (nextVertex.x - currentVertex.x)
                    - (point.x - currentVertex.x)
                            * (nextVertex.y - currentVertex.y));

            if (currentSide == 0) { // on border line
                // check if the point is bounded between vertices
                boolean boundedOnX = currentVertex.x <= point.x && point.x <= nextVertex.x;
                boolean boundedOnY = currentVertex.y <= point.y && point.y <= nextVertex.y;
                if (boundedOnX && boundedOnY) { // on border of polygon
                    return PointStatus.ON_BORDER_OF_POLYGON;
                }
            }

            if (currentSide < 0) { // point is to right side of the tracing line
                rightSide = true;
            } else { // point is to left side of the tracing line
                leftSide = true;
            }
        }

        if (rightSide ^ leftSide) { // no direction change
            return PointStatus.INSIDE_POLYGON;
        } else { // direction change
            return PointStatus.OUTSIDE_POLYGON;
        }
    }
}
