package problem1;

/**
 * Represent a electrical class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Electrical extends Specialist{
  private int MLE = 4;

  /**
   * Constructor that creates a new electrical object.
   */
  public Electrical(String address, Size size, boolean carryout, Integer number,
      Integer numberOfLicensedEmployee, Boolean complexOrNot) throws arguementError {
    super(address, size, carryout, number, numberOfLicensedEmployee, complexOrNot);

    if(numberOfLicensedEmployee > MLE) throw new arguementError("invalid num od licesed employ");
  }

}
