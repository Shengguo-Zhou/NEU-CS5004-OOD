package problem1;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Represent the abstract Room class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Pledge extends Donation{

  /**
   * now - the now time
   */
  private LocalDateTime now = LocalDateTime.of(2022, Month.MARCH,10,19,34,30);;

  /**
   * Constructor that creates a new Pledge object.
   * @param amount - the amount of money
   */
  public Pledge(Double amount) {
    super(amount);
  }

  /**
   * Constructor that creates a new Pledge object.
   * @param amount - the amount of money
   * @param donationTime - the donation time
   */
  public Pledge(Double amount, LocalDateTime donationTime) {
    super(amount, donationTime);
  }

  /**
   * set donation time
   * @param donationTime - the donation time
   * @throws InvalidDonationTime - throw an invalid donation time
   */
  public void setDonationTime(LocalDateTime donationTime) throws InvalidDonationTime {
    if(donationTime.isAfter(this.now)){
      this.donationTime = donationTime;
    }
    else{
      throw new InvalidDonationTime("invalid donation time");
    }
  }

  /**
   * remove donation time
   */
  public void removeDonationTime(){
    this.donationTime = null;
  }

}
