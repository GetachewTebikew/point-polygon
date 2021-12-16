import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Polygon
 */
public class Main {

    public static void main(String[] args) {

        File pointsFile = new File("/home/getish/Desktop/upwork-java--screening--1/points.txt");
        File polygonFile = new File("/home/getish/Desktop/upwork-java--screening--1/polygon.txt");
        File analysisFile = new File("/home/getish/Desktop/upwork-java--screening--1/analsis.txt");
        ArrayList<Point> vertexPoints = new ArrayList<Point>();
        Polygon polygon;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(polygonFile))) {
            String cordinate;
            while ((cordinate = bufferedReader.readLine()) != null) {
                System.out.println(cordinate);
                String[] cordinateStringNumbers = cordinate.split(",");
                double x = Double.parseDouble(cordinateStringNumbers[0]);
                double y = Double.parseDouble(cordinateStringNumbers[1]);
                Point point = new Point(x, y);
                vertexPoints.add(point);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        polygon = new Polygon(vertexPoints);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pointsFile))) {

            if (!analysisFile.exists()) {
                analysisFile.createNewFile();
            }
            fileWriter = new FileWriter(analysisFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            String cordinate;
            while ((cordinate = bufferedReader.readLine()) != null) {
                // System.out.println(st);
                String[] cordinateStringNumbers = cordinate.split(",");
                double x = Double.parseDouble(cordinateStringNumbers[0]);
                double y = Double.parseDouble(cordinateStringNumbers[1]);
                Point point = new Point(x, y);
                bufferedWriter.write(polygon.pointToPolygonRelation(point).toString() + "\n");
                // bufferedWriter.write("" + x + "," + y);
            }
            bufferedWriter.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
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