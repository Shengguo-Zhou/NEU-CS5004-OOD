package problem1;

/**
 * Represent a plumbing class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Plumbing extends Specialist{
  private int PE = 20;

  /**
   * Constructor that creates a new plumbing object.
   */
  public Plumbing(String address, Size size, boolean carryout, Integer number,
      Integer numberOfLicensedEmployee, Boolean complexOrNot) {
    super(address, size, carryout, number, numberOfLicensedEmployee, complexOrNot);
    extracharge = PE;
  }

}
