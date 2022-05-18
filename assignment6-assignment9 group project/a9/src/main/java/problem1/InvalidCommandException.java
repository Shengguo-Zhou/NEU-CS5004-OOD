package problem1;

/**
 * InvalidCommandException Class
 */

public class InvalidCommandException extends Exception {

  private static final String message = "Invalid Command.";

  /**
   * Constructor, calling the super class constructor with the message.
   */
  public InvalidCommandException() {
    super(message);
  }
}
