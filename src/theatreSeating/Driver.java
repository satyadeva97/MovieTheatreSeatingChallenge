package theatreSeating;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//java -jar Program.jar --input.text

/**
 * Driver class from where the execution starts. It contains the main method which handles the
 * input and output.
 */
public class Driver {

  /**
   * It reads the input from the file, calls the fill method of theatre for every row in the input
   * and writes the output to a file.
   * @param args variable arguments
   */

  //C:\Users\satya\Documents\Companies\Walmart\MovieTheatreSeatingChallenge\walmart\input.txt
  public static void main(String[] args) {
    final String input = args[0];
    //To read contents of a file
    try (BufferedReader br = new BufferedReader(new FileReader(input))) {
      TheatreInterface theatre = new Theatre(10);
      StringBuilder result = new StringBuilder();
      String line = br.readLine();
      while (line != null) {
        String[] parse = line.split(" ");
        int numberOfSeats = Integer.parseInt(parse[1]);
        String reservationNumber = parse[0];
        result.append(theatre.fillRows(reservationNumber, numberOfSeats));
        line = br.readLine();
      }

      File file = new File("walmart\\output.txt");
      BufferedWriter bwr = new BufferedWriter(new FileWriter(file));
      //write contents of StringBuffer to a file
      bwr.write(result.toString());
      //flush the stream
      bwr.flush();
      //close the stream
      bwr.close();
//      System.out.println(result.toString());
      System.out.println("\nOutput File Path: "+file.getAbsoluteFile());
      System.out.println("\n// TESTING //\n");
      new TheatreTest().testAll();
    }
    catch (FileNotFoundException e) {
      System.out.println("Caught a File not found exception");
      e.printStackTrace();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }
}

