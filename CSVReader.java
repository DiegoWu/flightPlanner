import java.io.BufferedReader;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Set;


public class CSVReader {

  private static <T> void println(T x) {
    System.out.println(x);
  }

  private static <T> void print(T x) {
    System.out.print(x);
  }

  ArrayList<AirportInterface> airportList = new ArrayList<AirportInterface>();

  ArrayList<EdgeInterface> edgeList = new ArrayList<EdgeInterface>();


  public List<AirportInterface> getAirportList() {
    return airportList;
  }

  /**
   * Returns list of connecting edges
   *
   * @return edgeList - list of edges in graph
   */

  public List<EdgeInterface> getEdgeList() {
    return edgeList;
  }

  public CSVReader() {


    try (BufferedReader br = new BufferedReader(
        new FileReader("airport.csv"))) {
      String line;
      int cnt = 0, cnt1= 0; 
      Set<String> st = new HashSet<String>();
      Set<String> edgest = new HashSet<String>();
      
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        cnt++;
        if (cnt == 1)
          continue;

       
        values[0] = values[0].replaceAll("\"", "");
        values[1] = values[1].replaceAll("\"", "");
        values[2] = values[2].replaceAll("\"", "");
        values[3] = values[3].replaceAll("\"", "");
        values[4] = values[4].replaceAll("\"", "");

        int edgeWeight = Integer.parseInt(values[9]);
        int sz = Integer.parseInt(values[12]);
        int sz1 = Integer.parseInt(values[11]);
        AirportInterface suc = new AirportDW(values[4], values[1], sz);
        AirportInterface pre = new AirportDW(values[2], values[0], sz1);
        // println(data);
        
        if (!st.contains(values[1])) {
         

          //if (sz >= 200000) {
            this.airportList.add(suc);
            cnt1++; 
          
          //}
        }
        
        if (!st.contains(values[0])) {
       
          //if (sz >= 200000) {
            this.airportList.add(pre);
            cnt1++; 
         // }
        }

        st.add(values[0]);
        st.add(values[1]);
        String data = values[0] + "--" + values[1]; 
        if (!edgest.contains(data)) {
          this.edgeList.add(new EdgeDW(pre, suc, edgeWeight));
          this.edgeList.add(new EdgeDW(suc, pre, edgeWeight));
          
        }
        edgest.add(data);

      }
     // println(cnt1); 

    } catch (Exception e) {
      print(e);
    }

  }

  public static void main(String args[]) {
  }

}
