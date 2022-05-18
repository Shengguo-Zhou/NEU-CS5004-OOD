package problem1;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Represent the nonProfit class
 * @author Shengguo Zhou
 * @version 1.0
 */

public class NonProfit {

  /**
   * name - name of non-profiter
   */
  public String name;
  /**
   * donationlinkedlist - the linkedlist of donation
   */
  public LinkedList<Donation> donationLinkedList;
  /**
   * month in year - the month in a year
   */
  private final int MONTH_IN_YEAR = 12;
  /**
   * extra count - the extra count
   */
  private final int EXTRA_COUNT = 1;
  /**
   * non donation - the non donation
   */
  private final int NO_DONATION = 0;

  /**
   * Constructor that creates a new non profit object.
   * @param name - name of non-profiter
   * @param donationLinkedList - the linkedlist of donation
   */
  public NonProfit(String name, LinkedList<Donation> donationLinkedList) {
    this.name = name;
    this.donationLinkedList = donationLinkedList;
  }

  /**
   * add a donation
   * @param donation - the donation of donater
   */
  public void addDonation(Donation donation){
    this.donationLinkedList.add(donation);
  }

  /**
   * get the total money
   * @param year - the get money year
   * @return the total money
   */
  public double getTotalDonationsForYear(int year){
    double sum = 0;

    for(Donation donation : donationLinkedList){

      if(donation instanceof OneTimeDonation){
        if(year != donation.donationTime.getYear()) continue;
        sum += donation.amount;
      }

      else if(donation instanceof MonthlyDonation){
        int month = 0;
        if(year < donation.donationTime.getYear()) continue;

        if(year == donation.donationTime.getYear()){
          if(((MonthlyDonation) donation).cancellationTime == null ||
              ((MonthlyDonation) donation).cancellationTime.getYear() > year)
            month = MONTH_IN_YEAR - donation.donationTime.getMonthValue() + EXTRA_COUNT;
          else
            month = ((MonthlyDonation) donation).cancellationTime.getMonthValue()
              - donation.donationTime.getMonthValue();
        }
        else{
          if(((MonthlyDonation) donation).cancellationTime == null ||
              ((MonthlyDonation) donation).cancellationTime.getYear() > year)
            month = MONTH_IN_YEAR;
          else if(((MonthlyDonation) donation).cancellationTime.getYear() < year)
            month = NO_DONATION;
          else if(((MonthlyDonation) donation).cancellationTime.getYear() == year)
            month = ((MonthlyDonation) donation).cancellationTime.getMonthValue();
        }
        sum += donation.amount * month;
      }

      else{
        if(donation.donationTime != null && donation.donationTime.getYear() == year)
          sum += donation.amount;
      }
    }

    return sum;
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
    if (!(o instanceof NonProfit)) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return name.equals(nonProfit.name) && donationLinkedList.equals(nonProfit.donationLinkedList);
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, donationLinkedList);
  }

}
