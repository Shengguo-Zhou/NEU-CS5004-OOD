package problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;

public class CSVFileProcessor {

  protected BufferedReader inputFile;
  protected LinkedHashSet<Information> set = new LinkedHashSet<>();

  public CSVFileProcessor() {}

  public void getCSVDirectory(){
    System.out.println("Current csv file is in: " + System.getProperty("user.dir"));
  }

  public LinkedHashSet<Information> processCSV(String path){

    try {
      inputFile = new BufferedReader(new FileReader(path));
      String line = ((BufferedReader) inputFile).readLine(); // pass the first line

      while((line = ((BufferedReader) inputFile).readLine()) != null){
        // put it into a hashset;
        Information information = new Information();
        information.getInformation(line);
        set.add(information);
      }

    } catch(
        FileNotFoundException fnfe){
      System.out.println("File not found : " + fnfe.getMessage());
    } catch(
        IOException ioe){
      System.out.println("Sth went wrong : " + ioe.getMessage());
    } finally {
      if(inputFile != null){
        try{
          inputFile.close();
        } catch (IOException e){
          System.out.println("Failed to close the input stream");
        }
      }
    }

    return set;
  }


}
