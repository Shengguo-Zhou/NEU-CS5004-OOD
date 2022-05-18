package problem1;

import java.time.LocalDateTime;

/**
 * Represent the onetimedonation class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class OneTimeDonation extends Donation{

  /**
   * constructor the onetimedonation class
   * @param amount - the amount of money
   * @param donationTime - the donation time
   */
  public OneTimeDonation(Double amount, LocalDateTime donationTime) {
    super(amount, donationTime);
  }
}
