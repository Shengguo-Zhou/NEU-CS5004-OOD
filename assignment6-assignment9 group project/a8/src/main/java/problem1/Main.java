package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String args[]) throws MissCommandLineArgException, InvalidRouteException {
    // --email --email-template "email-template.txt" --letter --letter-template "letter-template.txt" --output-dir "All/" --csv-file "nonprofit-supporters.csv"
    System.out.println(Arrays.toString(args));

    // parser the command line
    CommandLineParser parser = new CommandLineParser(args);
    //create directory
    DirGenerator directory = new DirGenerator();
    directory.generate(parser.getOutputDirPath());
    // process the csv file
    CSVFileProcessor csvProcessor = new CSVFileProcessor();
    LinkedHashSet<Information> personInfo = csvProcessor.processCSV(parser.getCSVPath());
    // if email required
    if (parser.getEmailTemplatePath() != null){
      // process the email template
      System.out.println("loop1");

      TemplateProcessor processEmailTemplate = new TemplateProcessor();
      ArrayList<String> emailTemplate = processEmailTemplate.process(parser.getEmailTemplatePath());
      // write the file
      EmailGenerator generateEmail = new EmailGenerator();
      generateEmail.generate(parser.getOutputDirPath(), personInfo, emailTemplate);
    }
    // if letter required
    if (parser.getLetterTemplatePath() != null){
      // process the email template
      System.out.println("loop2");

      TemplateProcessor processLetterTemplate = new TemplateProcessor();
      ArrayList<String> letterTemplate = processLetterTemplate.process(parser.getLetterTemplatePath());
      // write the file
      LetterGenerator generateLetter = new LetterGenerator();
      generateLetter.generate(parser.getOutputDirPath(), personInfo, letterTemplate);
    }
  }

}
