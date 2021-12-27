import java.util.ArrayList;

public abstract class AbstractTestPointToPolygonRelationshipWithOrWithoutFile {
        String pointsFilePath = "/home/getish/Desktop/upjs-1/points.txt";
        String polygonFilePath = "/home/getish/Desktop/upjs-1/polygon.txt";
        String analysisFilePath = "/home/getish/Desktop/upjs-1/analysis.txt";

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

        ArrayList<PointStatus> getAnalysisResults() {
                ArrayList<PointStatus> pointStatus = new ArrayList<PointStatus>() {
                        {
                                add(PointStatus.INSIDE_POLYGON);
                                add(PointStatus.OUTSIDE_POLYGON);
                                add(PointStatus.ON_BORDER_OF_POLYGON);
                        }
                };
                return pointStatus;

        }
}
