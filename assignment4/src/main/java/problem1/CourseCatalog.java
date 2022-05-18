package problem1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Represent the abstract CourseCaatalog class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class CourseCatalog implements CourseCatalogADT{

  /**
   * DEFAULTLENGTH - length of course.
   */
  private final int DEFAULTLENGTH = 10;
  /**
   * array - array of course.
   */
  public Course[] array;
  /**
   * array - array of course.
   */
  public Course[] array2;
  /**
   * index - index of the course.
   */
  public int index = 0;

  /**
   * constructor - counstruct a coursecatalog class
   */
  public CourseCatalog() {
    array = new Course[DEFAULTLENGTH];
  }

  /**
   * Adds a Course to the end of the CourseCatalog.
   * @param course - the course of the catalog
   */
  @Override
  public void append(Course course) {
    this.array[this.index] = course;
    this.index++;
    checkValid(this.index);
  }

  /**
   * check the array is long enough
   * @param length - the length of array
   * @return true or false, if it is long enough return true,
   * return false otherwise
   */
  public boolean checkValid(int length) {
    if (length >= this.array.length) {
      this.array2 = new Course[array.length + DEFAULTLENGTH];
      for (int i = 0; i < array.length; i++) {
        array2[i] = array[i];
      }
      this.array = this.array2;
      return false;
    }
    return true;
  }

  /**
   * Removes a specified Course from the CourseCatalog.
   * @param course - the course of the catalog
   * @throws CourseNotFoundException - Throw a CourseNotFoundException if the Course doesn’t exist.
   */
  @Override
  public void remove(Course course) throws CourseNotFoundException {
    for(int i = 0; i < this.index; i++){
      if(this.array[i] != course) continue;
      this.array[i] = null;
      moveforward(this.array, i);
      return;
    }
    throw new CourseNotFoundException("The course doesn't exit");
  }

  /**
   * Checks if the specified course exists in the CourseCatalog.
   * @param array - array of course.
   * @param count - index of the course.
   */
  public void moveforward(Course[] array, int count){
    for(int i = count; i < this.index - 1; i++){
      this.array[i] = this.array[i + 1];
    }
    this.index--;
  }

  /**
   * Checks if the specified course exists in the CourseCatalog.
   * @param course - array of course.
   * @return true if it exists, false otherwise
   */
  @Override
  public boolean contains(Course course) {
    for(int i = 0; i < this.index; i++){
      if(this.array[i] != course) continue;
      return true;
    }
    return false;
  }

  /**
   * Checks index of the specified course
   * @param course - array of course.
   * @return index - index of course
   */
  @Override
  public int indexOf(Course course) {
    for(int i = 0; i < this.index; i++){
      if(this.array[i] != course) continue;
      return i;
    }
    return -1;
  }

  /**
   *
   * Checks index of the specified course
   * @return index - index of course
   */
  @Override
  public int count() {
    return index;
  }

  /**
   * Checks index of the specified course
   * @param i - index of course
   * @return course - index of course
   * @throws InvalidIndexException Throw a Exception if the Course doesn’t exist.
   */
  @Override
  public Course get(int i) throws InvalidIndexException {
    if(i > this.index) throw new InvalidIndexException("invalid index");
    return this.array[i - 1];
  }

  /**
   * Checks if the Course Catalog is empty.
   * @return true or false
   */
  @Override
  public boolean isEmpty() {
    if(index == 0) return true;
    else return false;
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
    if (!(o instanceof CourseCatalog)) {
      return false;
    }
    CourseCatalog that = (CourseCatalog) o;
    return index == that.index && array.equals(that.array);
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(array, index);
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public String toString() {
    return "CourseCatalog{" +
        "array=" + array +
        ", index=" + index +
        '}';
  }
}
