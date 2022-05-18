package problem1;

/**
 * MissCommandLineArgException Class
 */
public class MissCommandLineArgException extends Exception {

  /**
   * A constructor
   *
   * @param message - message based on the given exception
   */
  public MissCommandLineArgException(String message) {
    super(message);
  }
}
