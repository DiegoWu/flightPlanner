/*
 *05/26/2023
 *author: Diego
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class CSVtoDOT {

  private static <T> void println(T x) {
    System.out.println(x);
  }

  private static <T> void print(T x) {
    System.out.print(x);
  }

  public static double distance(double lat1, double lat2, double lon1, double lon2) {

    final int R = 6371; // Radius of the earth

    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
      + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
      * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c * 1000; // convert to meters

    // double height = el1 - el2;

    // distance = Math.pow(distance, 2) + Math.pow(height, 2);

    return distance;
  }

  public static void main(String[] args) {

    File file = null;
    FileWriter filewriter = null;
    file = new File("/Users/diego/eclipse-workspace/csv_to_dot/src/csv_to_dot/airport.txt");
    // Creating Object of FileWriter class

    try (BufferedReader br = new BufferedReader(
          new FileReader("/Users/diego/eclipse-workspace/csv_to_dot/src/csv_to_dot/airport.csv"))) {
      String line;
      int cnt = 0;
      filewriter = new FileWriter(file);

      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        cnt++;
        if (cnt == 1)
          continue;

        String data = values[2] + "--" + values[3] +" [label=" + "\"" + values[7] + "\" "
          + "distance=" + values[7] + "];";
        Set<String> st = new HashSet<String>();
        values[0]= values[0].replaceAll("\"", ""); 
        values[1]= values[1].replaceAll("\"", ""); 
        values[2]= values[2].replaceAll("\"", ""); 
        values[3]= values[3].replaceAll("\"", ""); 


        // Writing to the file

        filewriter.write(data);

        // println(data);
        if (!st.contains(values[1])) {
          data = values[3] + " [label=" + values[1] + " size=" + values[10] + " abbreviation= \""
            + values[3] + "\"]";
          filewriter.write(data);
          //println(data); 
        }
        if (!st.contains(values[0])) {
          data = values[2] + " [label=" + values[0] + " size=" + values[9] + " abbreviation= \""
            + values[2] + "\"]";
          filewriter.write(data);

        }

        st.add(values[0]);
        st.add(values[1]);

      }
      filewriter.close();
      println(cnt);
    } catch (Exception e) {
      print(e);
    }
  }
}
