package problem1;

/**
 * Represent an abstract exterior class
 * @author Shengguo Zhou
 * @version 1.0
 */
public abstract class Exterior extends Service{
  protected int base = Interior.BASENUMBER;
  protected int hourKind;
  protected double discount10;
  protected double monthlyDiscount;
  private int ONE = 1;
  private int TWO = 2;
  private int FOUR = 4;

  /**
   * Constructor that creates a new exterior object.
   */
  public Exterior(String address, Size size, boolean carryout, Integer number) {
    super(address, size, carryout, number);
    if(size == Size.small) hourKind = ONE;
    else if(size == Size.medium) hourKind = TWO;
    else hourKind = FOUR;

    if(this.number % Interior.TENINTEGER == Interior.NINEINTEGER) discount10 = Interior.DICOUNT3;
    else discount10 = Interior.DICOUNT0;

    if(carryout && discount10 == Interior.DICOUNT0) monthlyDiscount = Interior.DICOUNT4;
    else monthlyDiscount = Interior.DICOUNT0;
  }

}
