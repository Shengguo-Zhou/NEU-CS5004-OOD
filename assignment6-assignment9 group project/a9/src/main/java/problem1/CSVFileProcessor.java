package problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;


/**
 * This class is used to process the csv file and store the information in a LinkedHashSet
 */
public class CSVFileProcessor {

  /**
   * Used to read the csv file.
   */
  protected BufferedReader inputFile;
  /**
   * Used to store the information in a LinkedHashSet.
   */
  protected LinkedHashSet<ToDo> set = new LinkedHashSet<>();

  /**
   * A constructor.
   */
  public CSVFileProcessor() {
  }

  /**
   * This function prints out the current directory of the csv file
   */
  public void getCSVDirectory() {
    System.out.println("Current csv file is in: " + System.getProperty("user.dir"));
  }

  /**
   * This function is used to process the csv file and store the information in a LinkedHashSet
   *
   * @param path -- path String type
   * @return information set
   * @throws RequiredFieldError when required field error happens
   */
  public LinkedHashSet<ToDo> processCSV(String path) throws RequiredFieldError {
    try {
      inputFile = new BufferedReader(new FileReader(path));
      String line = ((BufferedReader) inputFile).readLine(); // pass the first line

      while ((line = ((BufferedReader) inputFile).readLine()) != null) {
        if (line.length() == 0 || line.charAt(0) == ',') {
          break; // if a line in csv is null pass it
        }
        ToDo toDo = new ToDo();
        toDo.getToDoList(line);
        set.add(toDo);
        // end condition
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("File not found : " + fnfe.getMessage());
    } catch (IOException ioe) {
      // System.out.println("Something went wrong : " + ioe.getMessage());
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          // System.out.println("Failed to close the input stream");
        }
      }
    }
    return set;
  }
}