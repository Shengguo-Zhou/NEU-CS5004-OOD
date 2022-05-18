package problem1;

import java.time.LocalDateTime;

/**
 * Represent the abstract Room class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Vegetable extends PerishableFood{

  /**
   * Represent the abstract vegetable class
   * @author Shengguo Zhou
   * @version 1.0
   */
  public Vegetable(String name, Double currentPricePerUnit, Integer currentlyAvailableQ,
      Integer maxAllowedQ, LocalDateTime orderDate,
      LocalDateTime expirationDate) {
    super(name, currentPricePerUnit, currentlyAvailableQ, maxAllowedQ, orderDate, expirationDate);
  }
}
