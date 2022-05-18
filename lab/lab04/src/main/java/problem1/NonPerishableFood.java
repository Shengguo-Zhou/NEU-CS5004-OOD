package problem1;
/**
 * Represent food
 * @author Shengguo Zhou
 * @version 1.0
 */
public class NonPerishableFood extends Food{
  private static final Integer MAX_ALLOWED = 250;

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public NonPerishableFood(String name, Double currentPricePerUnit,
      Integer currentlyAvailableQ, Integer maxAllowedQ) {
    super(name, currentPricePerUnit, currentlyAvailableQ, MAX_ALLOWED);
  }
}
