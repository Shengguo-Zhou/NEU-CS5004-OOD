package problem1;
/**
 * Represent the abstract InvalidCancellationtime class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class InvalidCancellationTime extends Exception{

  /**
   * Constructs a new exception with the specified detail message.  The cause is not initialized, and
   * may subsequently be initialized by a call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for later retrieval by the {@link
   *                #getMessage()} method.
   */
  public InvalidCancellationTime(String message) {
    super(message);
  }
}
