package problem1;

/**
 * Represent an abstract specialist class
 * @author Shengguo Zhou
 * @version 1.0
 */
public abstract class Specialist extends Service{
  /**
   * numberOfLicensedEmployee - number of licensed employee
   */
  protected Integer numberOfLicensedEmployee;
  /**
   * complexOrNot - whether the task is complex or not
   */
  protected Boolean complexOrNot;

  private final int atLeastEmployee = 1;
  private final int CL = 3;
  private final int CSM = 2;
  protected int base = 200;
  protected int extracharge;

  /**
   * Constructor that creates a new SingleRoom object.
   * @param numberOfLicensedEmployee - number of licensed employee
   * @param complexOrNot - whether the task is complex or not
   */
  public Specialist(String address, Size size, boolean carryout, Integer number,
      Integer numberOfLicensedEmployee, Boolean complexOrNot) {
    super(address, size, carryout, number);

    this.complexOrNot = complexOrNot;

    if(complexOrNot)
      if(size == Size.large) this.numberOfLicensedEmployee = CL;
      else this.numberOfLicensedEmployee = CSM;
    else if(numberOfLicensedEmployee < atLeastEmployee)
      this.numberOfLicensedEmployee = atLeastEmployee;
    else this.numberOfLicensedEmployee = numberOfLicensedEmployee;
  }

  /**
   * get price function
   * @return price - price of service
   */
  public double calculatePrice() {
    return base * this.numberOfLicensedEmployee + extracharge;
  }

}
