package problem1;

import java.util.Objects;

/**
 * Represent the abstract Course class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Course {

  /**
   * name - name of course
   */
  private final String name;
  /**
   * prefix - prefix of course
   */
  private final String prefix;
  /**
   * number - number of course
   */
  private final int number;

  /**
   * constructor
   * @param name - name of course
   * @param prefix - prefix of course
   * @param number - number of course
   */
  public Course(String name, String prefix, int number) {
    this.name = name;
    this.prefix = prefix;
    this.number = number;
  }

  /**
   * tostring - print the string of the course
   * @return the string of course
   */
  @Override
  public String toString() {
    return prefix + number + ": " + name;
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
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return number == course.number &&
        name.equals(course.name) &&
        prefix.equals(course.prefix);
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, prefix, number);
  }
}
