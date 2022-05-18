package problem1;

import java.time.LocalDateTime;

/**
 * Represent the MonthlyDonation class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class MonthlyDonation extends Donation{

  /**
   * cancellationTime - cancellation time
   */
  public LocalDateTime cancellationTime;

  /**
   * Constructor that creates a new MonthlyDonation object.
   * @param amount - the amount of money
   * @param donationTime - the donation time
   */
  public MonthlyDonation(Double amount, LocalDateTime donationTime) {
    super(amount, donationTime);
  }

  /**
   * set the cancellation time
   * @param cancellationTime - the cancellation time
   * @throws InvalidCancellationTime - throw an invalid cancellation time
   */
  public void setCancellationTime(LocalDateTime cancellationTime) throws InvalidCancellationTime {
    if(cancellationTime.isAfter(this.donationTime))
      this.cancellationTime = cancellationTime;
    else
      throw new InvalidCancellationTime("Invalid Cancellation Time");
  }
}
