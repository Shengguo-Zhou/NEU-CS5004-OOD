package problem1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class EmailGenerator {

  private static final Integer FIRST_LINE = 0;
  private static final Integer SECOND_LINE = 1;
  private static final Integer THIRD_LINE = 2;
  private static final Integer FOURTH_LINE = 3;

  public EmailGenerator() {}

  public void generate(String dirPath, LinkedHashSet<Information> set, ArrayList<String> emailTemplate) {
    try {
      for (Information info : set) {
        String[] filledEmail = new String[emailTemplate.size()];
        filledEmail[FIRST_LINE] = "To: " + info.getEmail();
        filledEmail[SECOND_LINE] = emailTemplate.get(1);
        filledEmail[THIRD_LINE] = "Dear " + info.getFirstName() + " " + info.getLastName() + ",";
        for (int i = FOURTH_LINE; i < emailTemplate.size(); i++)
          filledEmail[i] = emailTemplate.get(i);
        Path out = Paths.get(dirPath + info.getFirstName() + "-email.txt");
        Files.write(out, List.of(filledEmail));
      }
    } catch (IOException e) {
      System.out.println("Failed to close the input stream");
    }

  }

}
