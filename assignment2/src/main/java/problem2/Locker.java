package problem2;

import java.util.Objects;

/**
 * Represents the Locker class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Locker {

  /**
   * mail - the mail of the locker
   */
  private Mail mail;
  /**
   * maxSize - the maxsize of the locker
   */
  private Size maxSize;

  /**
   * Constructor : create the constructor of locker
   * @param mail - the mail whose default is null
   * @param maxSize - a maxsize
   */
  public Locker(Mail mail, Size maxSize) {
    this.mail = null;

    if(maxSize.getWidth() >=1 && maxSize.getHeight() >= 1 &&
    maxSize.getDepth() >= 1)
      this.maxSize = maxSize;
    else
      throw new IllegalArgumentException("Locker size is not valid");
  }

  /**
   * getMail() - get the mail of the locker
   * @return mail - the mail of the locker
   */
  public Mail getMail() {
    return mail;
  }

  /**
   * getMaxSize() - get the maxsize of the locker
   * @return size - the max size of the locker
   */
  public Size getMaxSize() {
    return maxSize;
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
    if (!(o instanceof Locker)) {
      return false;
    }
    Locker locker = (Locker) o;
    return getMail().equals(locker.getMail()) && getMaxSize().equals(locker.getMaxSize());
  }

  /**
   * override the hashCode function
   * @return if they are equal, return true,
   * else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMail(), getMaxSize());
  }

  /**
   * addMail function - if the locker is valid, then we put a mail in it.
   * @param newMail - put the new mail in it
   */
  void addMail(Mail newMail){
    if(this.mail != null)
      throw new IllegalArgumentException("this locker is not empty, you can not put in it");
    else if(newMail.getSize().getDepth() > maxSize.getDepth() ||
        newMail.getSize().getWidth() > maxSize.getWidth() ||
        newMail.getSize().getHeight()> maxSize.getHeight() )
      throw new IllegalArgumentException("this mail is too large, you can not put in it");
    else 
      this.mail = newMail;
  }

  /**
   * pickupMail function - If there is something in the locker, and the recipient
   * is matched, then get it.
   * @param oneRecipient - the mail's recipient
   * @return returnMail - return the recipient's mail
   */
  Mail pickupMail(Recipient oneRecipient){
    if(this.mail != null && mail.getRecipient().getEmail() == oneRecipient.getEmail()
    && mail.getRecipient().getFirstName() == oneRecipient.getFirstName()
    && mail.getRecipient().getLastName() == oneRecipient.getLastName()){
      Mail returnMail = this.mail;
      this.mail = null;
      return returnMail;
    }
    else
      throw new IllegalArgumentException("there is no mail in it or "
          + "the recipient is not matched.");
  }

}
