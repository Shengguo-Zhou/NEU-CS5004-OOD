package problem2;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Represents the Recipient class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Recipient {

  /**
   * firstName - the first name of recipient
   */
  private String firstName;
  /**
   * lastName - the last name of recipient
   */
  private String lastName;
  /**
   * email - the email of recipient
   */
  private String email;

  /**
   * Constructor : create the constructor of recipient
   * @param firstName - recipient's first name
   * @param lastName - recipient's last name
   * @param email - recipient's email
   */
  public Recipient(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;

    if(patternMatches(email))
      this.email = email;
    else
      throw new IllegalArgumentException("email is not valid");
  }

  /**
   * patternMatch - have a check whether the email address is valid
   * @param email - email address of recipient
   * @return if the email is valid, return true, else, return false
   */
  public boolean patternMatches(String email) {
    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    return Pattern.compile(regexPattern)
        .matcher(email)
        .matches();
  }

  /**
   * getFirstName - get the first name
   * @return firstName - the first name of recipient
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * getLastName - get the last name
   * @return lastName - the last name of recipient
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * getEmail - get the email
   * @return email - the email of recipient
   */
  public String getEmail() {
    return email;
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
    if (!(o instanceof Recipient)) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return getFirstName().equals(recipient.getFirstName()) && getLastName().equals(
        recipient.getLastName()) && getEmail().equals(recipient.getEmail());
  }

  /**
   * override the hashCode function
   * @return if they are equal, return true,
   * else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getEmail());
  }

}
