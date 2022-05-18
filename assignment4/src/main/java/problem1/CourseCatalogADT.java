package problem1;

/**
 * Represent the abstract CourseCaatalog interface
 * @author Shengguo Zhou
 * @version 1.0
 */
public interface CourseCatalogADT {

  /**
   * append function - append fucntion
   * @param course - course
   */
  public void append(Course course);

  /**
   * append function - append fucntion
   * @param course - course
   * @throws CourseNotFoundException - enception
   */
  public void remove(Course course) throws CourseNotFoundException;

  /**
   * append function - remove fucntion
   * @param course - course
   * @return - course
   */
  public boolean contains(Course course);

  /**
   * append function - contains fucntion
   * @param course append function - append fucntion
   * @return append function - append fucntion
   */
  public int indexOf(Course course);

  /**
   * append function - count fucntion
   * @return append function - append fucntion
   */
  public int count();

  /**
   *
   * append function - get fucntion
   * @param index - course
   * @return return - course
   * @throws InvalidIndexException - exception
   */
  public Course get(int index) throws InvalidIndexException;

  /**
   * append function - isEmpty fucntion
   * @return isEmpty - isEmpty or not
   */
  public boolean isEmpty();
}
