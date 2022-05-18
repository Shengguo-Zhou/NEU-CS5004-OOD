package problem1;
/**
 * Represent food
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Rice extends NonPerishableFood{

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public Rice(String name, Double currentPricePerUnit, Integer currentlyAvailableQ,
      Integer maxAllowedQ) {
    super(name, currentPricePerUnit, currentlyAvailableQ, maxAllowedQ);
  }
}
