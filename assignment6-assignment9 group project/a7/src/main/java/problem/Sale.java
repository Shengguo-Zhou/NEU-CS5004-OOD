package problem;

/**
 * Sale is a Contract that has an asking price and a price is negotiable flag.
 */
public class Sale extends Contract {

  /**
   * Calling the constructor of the super class.
   *
   * @param askingPrice       - asking Price
   * @param priceIsNegotiable - price is Negotiable
   */
  public Sale(Double askingPrice, Boolean priceIsNegotiable) {
    super(askingPrice, priceIsNegotiable);
  }

  @Override
  public String toString() {
    return "Sale{" +
        "askingPrice=" + askingPrice +
        ", priceIsNegotiable=" + priceIsNegotiable +
        "}";
  }
}
