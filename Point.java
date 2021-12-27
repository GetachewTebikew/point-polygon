public class Point {
    double x;
    double y;

    public Point(double x_coordinate, double y_coordinate) {
        super();
        this.x = x_coordinate;
        this.y = y_coordinate;
    }

    public boolean equals(Object object) {
        Point point =(Point) object;
        return this.x==point.x && this.y==point.y;
        
    }

}
