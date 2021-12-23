import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IOperations {
    public static ArrayList<Point> getTestPointsFromFile(String pointsFilePath) {
        ArrayList<Point> points = new ArrayList<Point>();
        File pointsFile = new File(pointsFilePath);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pointsFile));
            String coordinate;// holds x,y in string format "x,y"
            while ((coordinate = bufferedReader.readLine()) != null) {
                Point point = convertStringCoordinateToPoint(coordinate);
                points.add(point);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return points;
    }

    public static Polygon getPolygonFromFile(String polygonFilePath) {
        File polygonFile = new File(polygonFilePath);
        ArrayList<Point> vertexPoints = new ArrayList<Point>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(polygonFile))) {
            String coordinate;
            while ((coordinate = bufferedReader.readLine()) != null) {
                Point point = convertStringCoordinateToPoint(coordinate);
                vertexPoints.add(point);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // construct a polygon from vertex points
        Polygon polygon = new Polygon(vertexPoints);
        return polygon;

    }

    // converts a string coordinate("x,y") to Point(x,y)
    private static Point convertStringCoordinateToPoint(String coordinate) {
        String[] coordinateStringNumbers = coordinate.split(",");
        double x = Double.parseDouble(coordinateStringNumbers[0]);
        double y = Double.parseDouble(coordinateStringNumbers[1]);
        Point point = new Point(x, y);
        return point;
    }

    public static void writeAnalysis(String path, ArrayList<PointStatus> analysisResult) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        File analysisFile = new File(path);
        try {
            if (!analysisFile.exists()) {
                analysisFile.createNewFile();
            }

            fileWriter = new FileWriter(analysisFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (PointStatus pointStatus : analysisResult) {
                bufferedWriter.write(pointStatus + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

    public static ArrayList<String> getAnalysis(String filePath) {
        ArrayList<String> analysis = new ArrayList<String>();

        File pointsFile = new File(filePath);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(pointsFile));
            String pointStatus;// holds x,y in string format "x,y"
            while ((pointStatus = bufferedReader.readLine()) != null) {
                analysis.add(pointStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return analysis;
    }

    public static void persistPoints(String path, ArrayList<Point> points) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        File analysisFile = new File(path);
        try {
            if (!analysisFile.exists()) {
                analysisFile.createNewFile();
            }

            fileWriter = new FileWriter(analysisFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Point point : points) {
                bufferedWriter.write(point.x + "," + point.y + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

    public static void persistPolygon(Polygon polygon) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        File analysisFile = new File("/home/getish/Desktop/upjs-1/polygon.txt");
        try {
            if (!analysisFile.exists()) {
                analysisFile.createNewFile();
            }

            fileWriter = new FileWriter(analysisFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Point point : polygon.vertexPoints) {
                bufferedWriter.write(point.x + "," + point.y + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

}