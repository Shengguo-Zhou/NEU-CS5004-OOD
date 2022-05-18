package problem1;

import java.util.Objects;
/**
 * Represent food
 * @author Shengguo Zhou
 * @version 1.0
 */
public abstract class Food {
  private String name;
  private Double currentPricePerUnit;
  private Integer currentlyAvailableQ;
  private Integer maxAllowedQ;

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public Food(String name, Double currentPricePerUnit, Integer currentlyAvailableQ,
      Integer maxAllowedQ) {
    this.name = name;
    this.currentPricePerUnit = currentPricePerUnit;
    this.currentlyAvailableQ = currentlyAvailableQ;
    this.maxAllowedQ = maxAllowedQ;
  }

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public String getName() {
    return name;
  }

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public Double getCurrentPricePerUnit() {
    return currentPricePerUnit;
  }

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public Integer getCurrentlyAvailableQ() {
    return currentlyAvailableQ;
  }

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public Integer getMaxAllowedQ() {
    return maxAllowedQ;
  }

  /**
   * Represent food
   * @author Shengguo Zhou
   * @version 1.0
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCurrentPricePerUnit(), getCurrentlyAvailableQ(),
        getMaxAllowedQ());
  }
}
