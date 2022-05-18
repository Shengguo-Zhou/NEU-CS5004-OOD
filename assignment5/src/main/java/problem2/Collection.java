package problem2;

/**
 * Represent the collection class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Collection {

  /**
   * creator - the creator of collection
   */
  public Creator creator;
  /**
   * title - the title of collection
   */
  public String title;
  /**
   * year - the year of collection
   */
  public int year;

  /**
   * constructor - create a collection class
   * @param creator - the creator of collection
   * @param title - the title of collection
   * @param year - the year of collection
   */
  public Collection(Creator creator, String title, int year) {
    this.creator = creator;
    this.title = title;
    this.year = year;
  }
}
