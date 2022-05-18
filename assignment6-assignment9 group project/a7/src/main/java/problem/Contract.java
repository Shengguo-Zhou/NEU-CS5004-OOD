package problem;

import java.util.Objects;

/**
 * A Contract is a type of document that is used to formalize a business agreement between two or
 * more parties.
 */
public abstract class Contract {

  /**
   * declaring a variable called askingPrice of type Double.
   */
  protected Double askingPrice;
  /**
   * Declaring a variable called priceIsNegotiable of type Boolean.
   */
  protected Boolean priceIsNegotiable;

  /**
   * A constructor.
   *
   * @param askingPrice       - asking Price
   * @param priceIsNegotiable - price is Negotiable -
   */
  public Contract(Double askingPrice, Boolean priceIsNegotiable) {
    this.askingPrice = askingPrice;
    this.priceIsNegotiable = priceIsNegotiable;
  }

  /**
   * @return The asking price of the property.
   */
  public Double getAskingPrice() {
    return askingPrice;
  }

  /**
   * @return The priceIsNegotiable variable is being returned.
   */
  public Boolean getPriceIsNegotiable() {
    return priceIsNegotiable;
  }

  /**
   * This function sets the asking price of the property
   *
   * @param askingPrice The asking price of the property.
   */
  public void setAskingPrice(Double askingPrice) {
    this.askingPrice = askingPrice;
  }

  /**
   * This function sets the priceIsNegotiable variable to the value of the priceIsNegotiable
   * parameter
   *
   * @param priceIsNegotiable Whether the price is negotiable or not.
   */
  public void setPriceIsNegotiable(Boolean priceIsNegotiable) {
    this.priceIsNegotiable = priceIsNegotiable;
  }

  /**
   * > Calculates the commission for the agent based on the asking price and the commission rate
   *
   * @param commissionRate The commission rate to be used to calculate the commission.
   * @return The commission rate is being returned.
   */
  public Double calculateCommission(Double commissionRate) {
    if (commissionRate <= Agent.COMMISSION_RATE_MIN
        || commissionRate >= Agent.COMMISSION_RATE_MAX) {
      throw new IllegalArgumentException();
    }
    return this.askingPrice * commissionRate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Contract)) {
      return false;
    }
    Contract contract = (Contract) o;
    return Objects.equals(getAskingPrice(), contract.getAskingPrice())
        && Objects.equals(getPriceIsNegotiable(), contract.getPriceIsNegotiable());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAskingPrice(), getPriceIsNegotiable());
  }
}
