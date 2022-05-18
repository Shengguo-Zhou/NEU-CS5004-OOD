package problem2;

import java.util.Objects;

/**
 * Represent the author class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Author extends Individual{

  /**
   * firstName - first name
   */
  public String firstName;
  /**
   * lastName - last name
   */
  public String LastName;

  /**
   * Constructor that creates a Author object.
   * @param firstName - first name
   * @param LastName - last name
   */
  public Author(String firstName, String LastName) {
    this.firstName = firstName;
    this.LastName = LastName;
  }

  /**
   * an override equal function, if two room objects are equal
   * return true, otherwise return false
   * @param o - the object of input
   * @return true or false, if they are equal, return true, otherwise,
   * return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Author)) {
      return false;
    }
    Author author = (Author) o;
    return firstName.equals(author.firstName) && LastName.equals(author.LastName);
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, LastName);
  }
}
