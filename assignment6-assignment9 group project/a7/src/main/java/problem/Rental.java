package problem;

import java.util.Objects;

/**
 * A rental contract is a contract that has a term.
 */
public class Rental extends Contract {

  private Integer term;

  /**
   * A constructor for the Rental class.
   *
   * @param askingPrice       - asking Price
   * @param priceIsNegotiable - price is Negotiable
   * @param term              - term
   */
  public Rental(Double askingPrice, Boolean priceIsNegotiable, Integer term) {
    super(askingPrice, priceIsNegotiable);
    if (term <= 0) {
      throw new IllegalArgumentException();
    }
    this.term = term;
  }

  /**
   * @return The term of the loan.
   */
  public Integer getTerm() {
    return this.term;
  }

  /**
   * > If the term is less than or equal to zero, throw an exception. Otherwise, set the term to the
   * given term
   *
   * @param term The term of the loan.
   */
  public void setTerm(Integer term) {
    if (term <= 0) {
      throw new IllegalArgumentException();
    }
    this.term = term;
  }

  @Override
  public Double calculateCommission(Double commissionRate) {
    if (commissionRate <= Agent.COMMISSION_RATE_MIN
        || commissionRate >= Agent.COMMISSION_RATE_MAX) {
      throw new IllegalArgumentException();
    }
    return this.getAskingPrice() * this.term * commissionRate;
  }

  @Override
  public String toString() {
    return "Rental{" +
        "askingPrice=" + askingPrice +
        ", priceIsNegotiable=" + priceIsNegotiable +
        ", term=" + term +
        "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rental)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Rental rental = (Rental) o;
    return Objects.equals(getTerm(), rental.getTerm());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getTerm());
  }
}
