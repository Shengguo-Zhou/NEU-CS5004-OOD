package problem1;

import java.time.LocalDateTime;
/**
 * Represent food
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Meat extends PerishableFood{

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public Meat(String name, Double currentPricePerUnit, Integer currentlyAvailableQ,
      Integer maxAllowedQ, LocalDateTime orderDate,
      LocalDateTime expirationDate) {
    super(name, currentPricePerUnit, currentlyAvailableQ, maxAllowedQ, orderDate, expirationDate);
  }
}
