package problem1;

/**
 * Represent a painting class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Painting extends Interior{

  private int TWENTYFOUR = 24;
  private int SHILIU = 16;

  /**
   * Constructor that creates a new Painting object.
   */
  public Painting(String address, Size size, boolean carryout, Integer number,
      Integer petsNumber) {
    super(address, size, carryout, number, petsNumber);

    if(size == Size.large) hourKind = TWENTYFOUR;
    else hourKind = SHILIU;
  }

}
