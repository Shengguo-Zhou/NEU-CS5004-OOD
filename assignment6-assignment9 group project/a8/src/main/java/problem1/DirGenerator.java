package problem1;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class DirGenerator {

  public void generate(String dirPath){
    File f = new File(dirPath);
    try {
      if (f.mkdir()) {
        System.out.println("Directory Created");
      } else {
        System.out.println("Directory is not created");
      }
    } catch (Exception e) {
      System.out.println("Failed to create the directory");
    }
  }

}

