package problem1;

/**
 * Represent a gardening class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Gardening extends Exterior{
  private int TWENTY = 20;
  private final int extracharge = TWENTY;

  /**
   * Constructor that creates a new Painting object.
   */
  public Gardening(String address, Size size, boolean carryout, Integer number) {
    super(address, size, carryout, number);
  }

  /**
   * get price function
   * @return price - price of service
   */
  @Override
  public double calculatePrice() {
    return base * hourKind * discount10 * monthlyDiscount + extracharge;
  }
}
