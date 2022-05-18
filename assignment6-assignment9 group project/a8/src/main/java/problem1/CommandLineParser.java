package problem1;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class CommandLineParser {
  private static final String EMAIL_COMMAND = "--email";
  private static final String EMAIL_TEMPLATE_COMMAND = "--email-template";
  private static final String LETTER_COMMAND = "--letter";
  private static final String LETTER_TEMPLATE_COMMAND = "--letter-template";
  private static final String OUTPUT_DIR_COMMAND = "--output-dir";
  private static final String CSV_COMMAND = "--csv-file";

  private boolean emailTemplateRequired = false;
  private boolean letterTemplateRequired = false;
  private boolean haveCSVCommand = false;
  private boolean haveOutputDirCommand = false;
  private String CSVPath;
  private String emailTemplatePath;
  private String letterTemplatePath;
  private String outputDirPath;

  public CommandLineParser(String[] args) throws MissCommandLineArgException, InvalidRouteException {
    this.analyzeEachArg(args);
    this.checkMissArg();
    this.checkValidPath();
  }

  private void analyzeEachArg(String[] args) throws MissCommandLineArgException { // ppt page 23
    int i = 0;
    int length = args.length;
    // iterate the args
    while (i < length) {
      if (args[i].equals(EMAIL_COMMAND)) {
        this.emailTemplateRequired = true;
      } else if (args[i].equals(EMAIL_TEMPLATE_COMMAND)) {
        i++; // get the path
        outOfBound(i, length);
        this.emailTemplatePath = args[i];
      } else if (args[i].equals(LETTER_COMMAND)) {
        this.letterTemplateRequired = true;
      } else if (args[i].equals(LETTER_TEMPLATE_COMMAND)) {
        i++; // get the path
        outOfBound(i, length);
        this.letterTemplatePath = args[i];
      } else if (args[i].equals(OUTPUT_DIR_COMMAND)) {
        haveOutputDirCommand = true;
        i++; // get the path
        outOfBound(i, length);
        this.outputDirPath = args[i];

      } else if (args[i].equals(CSV_COMMAND)) {
        haveCSVCommand = true;
        // System.out.println(haveCSVCommand);
        i++; // get the path
        outOfBound(i, length);
        this.CSVPath = args[i];
      }
      i++;
    }
  }


  private void outOfBound(Integer currentIndex, Integer maxLength) throws MissCommandLineArgException {
    if (currentIndex >= maxLength) {
      throw new MissCommandLineArgException("Error: Miss Command Line Arg!");
    }
  }

  /**
   * Check whether the path is valid
   * @param path
   * @return - abc
   */
  public void isValidPath(String path) throws InvalidRouteException {
    try {
      Paths.get(path);
    } catch (InvalidPathException | NullPointerException ex) {
      throw new InvalidRouteException("Error: Invalid path!");
    }
  }


  private void checkMissArg() throws MissCommandLineArgException{
    if(this.haveOutputDirCommand && this.haveCSVCommand) {
      if (this.emailTemplateRequired && this.emailTemplatePath == null) {
        throw new MissCommandLineArgException(
            "Error: --email provided but no --email-template was given.");
      }
      if (this.letterTemplateRequired && this.letterTemplatePath == null) {
        throw new MissCommandLineArgException(
            "Error: --letter provided but no --letter-template was given.");
      }
    } else {
      throw new MissCommandLineArgException("Error: --csv-file and --output-dir are both required.");
    }
  }



  private void checkValidPath() throws InvalidRouteException{
    if (this.outputDirPath != null) {
      isValidPath(this.outputDirPath);
    }
    if(this.CSVPath != null) {
      isValidPath(this.CSVPath);
    }
    if(this.letterTemplatePath != null) {
      isValidPath(this.letterTemplatePath);
    }
    if(this.emailTemplatePath != null) {
      isValidPath(this.emailTemplatePath);
    }
  }

  public boolean isEmailTemplateRequired() {
    return this.emailTemplateRequired;
  }

  public boolean isLetterTemplateRequired() {
    return this.letterTemplateRequired;
  }

  public boolean isHaveCSVCommand() {
    return this.haveCSVCommand;
  }

  public boolean isHaveOutputDirCommand() {
    return this.haveOutputDirCommand;
  }

  public String getCSVPath() {
    return this.CSVPath;
  }

  public String getEmailTemplatePath() {
    return this.emailTemplatePath;
  }

  public String getLetterTemplatePath() {
    return this.letterTemplatePath;
  }

  public String getOutputDirPath() {
    return this.outputDirPath;
  }
}

