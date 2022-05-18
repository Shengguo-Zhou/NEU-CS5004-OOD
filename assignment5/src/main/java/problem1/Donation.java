package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represent the abstract Donation class
 * @author Shengguo Zhou
 * @version 1.0
 */
public abstract class Donation {

  /**
   * amount - the donation of amount
   */
  protected Double amount;
  /**
   * donationTime - the donation time
   */
  protected LocalDateTime donationTime;

  /**
   * Constructor that creates a new Donation object.
   * @param amount - the amount of donation money
   */
  public Donation(Double amount) {
    this.amount = amount;
  }

  /**
   * Constructor that creates a new Donation object.
   * @param amount - the amount of donation money
   * @param donationTime - the donation time
   */
  public Donation(Double amount, LocalDateTime donationTime) {
    this.amount = amount;
    this.donationTime = donationTime;
  }

  /**
   * an override equal function, if two room objects are equal
   * return true, otherwise return false
   * @param o - the object of input
   * @return true or false, if they are equal, return true, otherwise,
   * return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Donation)) {
      return false;
    }
    Donation donation = (Donation) o;
    return amount.equals(donation.amount) && donationTime.equals(donation.donationTime);
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(amount, donationTime);
  }
}
