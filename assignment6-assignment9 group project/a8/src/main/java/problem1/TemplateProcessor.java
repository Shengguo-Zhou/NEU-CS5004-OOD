package problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TemplateProcessor {
  protected ArrayList<String> template = new ArrayList<>();
  protected BufferedReader inputFile;

  public TemplateProcessor() {}
  public ArrayList<String> process(String path) {

    try{
      inputFile = new BufferedReader(new FileReader(path));
      String line;
      while ((line = ((BufferedReader) inputFile).readLine()) != null) {
          template.add(line);
      }

    } catch (
        FileNotFoundException fnfe) {
      System.out.println("File not found : " + fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Sth went wrong : " + ioe.getMessage());
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println("Failed to close the input stream");
        }
      }
    }

    return template;
  }

}
