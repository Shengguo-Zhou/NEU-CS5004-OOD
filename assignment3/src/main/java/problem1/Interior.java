package problem1;

import java.util.Objects;

/**
 * Represent an abstract interior class
 * @author Shengguo Zhou
 * @version 1.0
 */
public abstract class Interior extends Service{
  /**
   * @param petsNumber - pet number of the service
   */
  private Integer petsNumber;

  public static int BASENUMBER = 80;
  public static double DICOUNT0 = 1.00;
  public static double DICOUNT1 = 1.05;
  public static double DICOUNT2 = 1.07;
  public static double DICOUNT3 = 0.5;
  public static double DICOUNT4 = 0.9;
  public int ONEPET = 1;
  public int TWOPET = 2;
  public static int TENINTEGER = 10;
  public static int NINEINTEGER = 9;
  protected int base = BASENUMBER;
  protected double add;
  protected double discount10;
  protected double monthlyDiscount;
  protected int hourKind;

  /**
   * Constructor that creates a new interior object.
   * @param petsNumber - pet number of the service
   */
  public Interior(String address, Size size, boolean carryout, Integer number, Integer petsNumber) {
    super(address, size, carryout, number);
    this.petsNumber = petsNumber;

    if(this.petsNumber == ONEPET || this.petsNumber == TWOPET) add = DICOUNT1;
    else add = DICOUNT2;

    if(this.number % TENINTEGER == NINEINTEGER) discount10 = DICOUNT3;
    else discount10 = DICOUNT0;

    if(carryout && discount10 == DICOUNT0) monthlyDiscount = DICOUNT4;
    else monthlyDiscount = DICOUNT0;
  }

  /**
   * get petsNumber function
   * @return petsNumber - pet number
   */
  public Integer getPetsNumber() {
    return petsNumber;
  }

  /**
   * get price function
   * @return price - price of service
   */
  public double calculatePrice(){
    return base * hourKind * add * discount10 * monthlyDiscount;
  }

}
