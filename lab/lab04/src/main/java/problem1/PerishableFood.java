package problem1;

import java.time.LocalDateTime;
/**
 * Represent food
 * @author Shengguo Zhou
 * @version 1.0
 */
public class PerishableFood extends Food{
  private LocalDateTime orderDate;
  private LocalDateTime expirationDate;
  private static final Integer MAX_ALLOWED = 100;

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public PerishableFood(String name, Double currentPricePerUnit,
      Integer currentlyAvailableQ, Integer maxAllowedQ, LocalDateTime orderDate,
      LocalDateTime expirationDate) {
    super(name, currentPricePerUnit, currentlyAvailableQ, MAX_ALLOWED);
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public LocalDateTime getExpirationDate() {
    return expirationDate;
  }
}
