package problem1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class LetterGenerator{
  private static final Integer FIRST_LINE = 0;
  private static final Integer SECOND_LINE = 1;
  private static final Integer THIRD_LINE = 2;
  private static final Integer FOURTH_LINE = 3;
  private static final Integer FIFTH_LINE = 4;
  public LetterGenerator() {}

  public void generate(String path, LinkedHashSet<Information> set, ArrayList<String> letterTemplate) {
    try {
      for (Information info : set) {
        String[] filledLetter = new String[letterTemplate.size()];
        filledLetter[FIRST_LINE] = info.getFirstName() + " " + info.getLastName();
        filledLetter[SECOND_LINE] = info.getAddress();
        filledLetter[THIRD_LINE] = info.getCity() + ", " + info.getState() + ", " + info.getZip();
        filledLetter[FOURTH_LINE] = "Dear " + info.getFirstName() + " " + info.getLastName() + ",";
        for (int i = FIFTH_LINE; i < letterTemplate.size(); i++)
          filledLetter[i] = letterTemplate.get(i);
        Path out = Paths.get(path + info.getFirstName() + "-letter.txt");
        Files.write(out, List.of(filledLetter));

      }

    } catch (IOException e) {
      System.out.println("Failed to close the input stream");
    }

  }

}
