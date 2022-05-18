package problem1;

/**
 * Represent a windowcleaning class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class WindowCleaning extends Exterior{
  /**
   * floor number - number of floor.
   */
  private Integer floorNumber;
  /**
   * add - add more money.
   */
  private double add;

  private int YI = 1;
  private int THREE = 3;

  /**
   * Constructor that creates a new windowcleaning object.
   */
  public WindowCleaning(String address, Size size, boolean carryout, Integer number,
      Integer floorNumber) throws arguementError {
    super(address, size, carryout, number);

    if(floorNumber > THREE) throw new arguementError("invalid floor number");
    else this.floorNumber = floorNumber;

    if(this.floorNumber > YI) add = Interior.DICOUNT1;
    else add = Interior.DICOUNT0;
  }

  /**
   * get price function
   * @return price - price of service
   */
  @Override
  public double calculatePrice() {
    return base * hourKind * add * discount10 * monthlyDiscount;
  }
}
