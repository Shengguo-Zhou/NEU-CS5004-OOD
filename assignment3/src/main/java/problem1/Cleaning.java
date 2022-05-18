package problem1;

/**
 * Represent a cleaning class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Cleaning extends Interior{

  private int YI = 1;
  private int ER = 2;
  private int SI = 4;

  /**
   * Constructor that creates a new Cleaning object.
   */
  public Cleaning(String address, Size size, boolean carryout, Integer number,
      Integer petsNumber) {
    super(address, size, carryout, number, petsNumber);

    if(size == Size.small) hourKind = YI;
    else if(size == Size.medium) hourKind = ER;
    else hourKind = SI;
  }

}
