package problem2;

/**
 * Represent the band class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Book extends Item{

  /**
   * author - the author of book
   */
  public Author author;

  /**
   * constructor a book class
   * @param author - the author of book
   */
  public Book(Author author) {
    this.author = author;
  }
}
