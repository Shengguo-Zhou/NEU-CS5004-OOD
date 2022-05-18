package problem2;

import java.util.Objects;

/**
 * Represents the Mail class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Mail {

  /**
   * size - the size
   */
  private Size size;
  /**
   * recipient - the recipient
   */
  private Recipient recipient;
  /**
   * VALID_SIZE - the valid size
   */
  private int VALID_SIZE = 1;

  /**
   * Constructor : create the constructor of mail
   * @param size - the size
   * @param recipient - a recipient
   */
  public Mail(Size size, Recipient recipient) {
    if(size.getDepth() >= VALID_SIZE && size.getHeight() >= VALID_SIZE &&
    size.getWidth() >= VALID_SIZE)
      this.size = size;
    else
      throw new IllegalArgumentException("size is not valid");

    this.recipient = recipient;
  }

  /**
   * getSize() - get the size of the package
   * @return size - the size of the package
   */
  public Size getSize() {
    return size;
  }

  /**
   * getRecipient() - get the recipient of the package
   * @return recipient - the recipient of the package
   */
  public Recipient getRecipient() {
    return recipient;
  }

  /**
   * override the equal function
   * @param o - the object of the function
   * @return if they are equal, return true,
   * else return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Mail)) {
      return false;
    }
    Mail mail = (Mail) o;
    return size.equals(mail.size) && recipient.equals(mail.recipient);
  }

  /**
   * override the hashCode function
   * @return if they are equal, return true,
   * else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(size, recipient);
  }
}
