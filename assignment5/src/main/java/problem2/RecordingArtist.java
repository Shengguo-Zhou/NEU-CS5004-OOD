package problem2;

import java.util.Objects;

/**
 * Represent the recording artist class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class RecordingArtist extends Individual{

  /**
   * firstname - the first name of the recording artist
   */
  public String firstName;
  /**
   * lastname - the last name of the recording artist
   */
  public String LastName;

  /**
   * constructor - create a recordingartist class
   * @param firstName - the first name of the class
   * @param LastName - the last name of the class
   */
  public RecordingArtist(String firstName, String LastName) {
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
    if (!(o instanceof RecordingArtist)) {
      return false;
    }
    RecordingArtist that = (RecordingArtist) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(LastName,
        that.LastName);
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
