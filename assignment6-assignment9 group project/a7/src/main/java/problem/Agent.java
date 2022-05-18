package problem;

import java.util.ArrayList;
import java.util.Objects;

/**
 * An agent has a name, a list of listings, a commission rate, and a total earning.
 */
public class Agent<P extends Property, C extends Contract> {

  private String name;
  private ArrayList<Listing<P, C>> listings;
  private Double commissionRate;
  private Double totalEarning;
  /**
   * A constant that is used to check the validity of the input.
   */
  public static final Double COMMISSION_RATE_MIN = 0.0;
  /**
   * A constant that is used to check the validity of the input.
   */
  public static final Double COMMISSION_RATE_MAX = 1.0;
  /**
   * A constant that is used to check the validity of the input.
   */
  public static final Double TOTAL_EARNING_DEFAULT = 0.0;

  /**
   * A constructor.
   *
   * @param name           - name
   * @param listings       - listings
   * @param commissionRate - commission Rate
   * @param totalEarning   - total Earning
   */
  public Agent(String name, ArrayList<Listing<P, C>> listings, Double commissionRate,
      Double totalEarning) {
    if (commissionRate <= COMMISSION_RATE_MIN || commissionRate >= COMMISSION_RATE_MAX
        || totalEarning < TOTAL_EARNING_DEFAULT || name.equals("")) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.listings = listings;
    this.commissionRate = commissionRate;
    this.totalEarning = totalEarning;
  }

  /**
   * @return The name of the person.
   */
  public String getName() {
    return name;
  }

  /**
   * The function sets the name of the person to the name passed in as a parameter
   *
   * @param name The name of the person.
   */
  public void setName(String name) {
    if (name.equals("")) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  /**
   * This function returns the listings of the current object
   *
   * @return An ArrayList of Listing objects.
   */
  public ArrayList<Listing<P, C>> getListings() {
    return listings;
  }

  /**
   * @return The commissionRate variable is being returned.
   */
  public Double getCommissionRate() {
    return commissionRate;
  }

  /**
   * The function sets the commission rate of the employee to the value passed in as a parameter
   *
   * @param commissionRate The commission rate for the salesperson.
   */
  public void setCommissionRate(Double commissionRate) {
    if (commissionRate <= COMMISSION_RATE_MIN || commissionRate >= COMMISSION_RATE_MAX) {
      throw new IllegalArgumentException();
    }
    this.commissionRate = commissionRate;
  }

  /**
   * @return The totalEarning variable is being returned.
   */
  public Double getTotalEarning() {
    return totalEarning;
  }

  /**
   * This function sets the total earning of the user
   *
   * @param totalEarning The total amount of money earned by the driver.
   */
  public void setTotalEarning(Double totalEarning) {
    if (totalEarning < TOTAL_EARNING_DEFAULT) {
      throw new IllegalArgumentException();
    }
    this.totalEarning = totalEarning;
  }

  /**
   * > Adds a listing to the list of listings
   *
   * @param aListing The listing to add to the list of listings.
   */
  void addListing(Listing<P, C> aListing) {
    this.listings.add(aListing);
  }

  /**
   * > The function `completeListing` removes a listing from the agent's list of listings and adds
   * the commission earned from the listing to the agent's total earnings
   *
   * @param aListing The listing to be completed.
   */
  void completeListing(Listing<P, C> aListing) {
    if (!this.listings.contains(aListing)) {
      throw new IllegalArgumentException();
    }
    this.totalEarning += aListing.getContract().calculateCommission(this.commissionRate);
    this.listings.remove(aListing);
  }

  /**
   * If the listing is not in the list of listings, throw an exception. Otherwise, remove the
   * listing from the list of listings.
   *
   * @param aListing The listing to be dropped.
   */
  public void dropListing(Listing<P, C> aListing) {
    if (!this.listings.contains(aListing)) {
      throw new IllegalArgumentException();
    }
    this.listings.remove(aListing);
  }

  /**
   * > The function `getTotalPortfolioValue` returns the sum of the commissions of all the listings
   * in the portfolio
   *
   * @return The total value of the portfolio.
   */
  public Double getTotalPortfolioValue() {
    Double res = 0.0;
    for (Listing<P, C> aListing : this.listings) {
      res += aListing.getContract().calculateCommission(this.commissionRate);
    }
    return res;
  }

  @Override
  public String toString() {
    return "Agent{" +
        "name='" + name + '\'' +
        ", listings=" + listings +
        ", commissionRate=" + commissionRate +
        ", totalEarning=" + totalEarning +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Agent)) {
      return false;
    }
    Agent<?, ?> agent = (Agent<?, ?>) o;
    return Objects.equals(getName(), agent.getName()) && Objects.equals(
        getListings(), agent.getListings()) && Objects.equals(getCommissionRate(),
        agent.getCommissionRate()) && Objects.equals(getTotalEarning(),
        agent.getTotalEarning()) && Objects.equals(COMMISSION_RATE_MAX,
        agent.COMMISSION_RATE_MAX) && Objects.equals(COMMISSION_RATE_MIN,
        agent.COMMISSION_RATE_MIN);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getListings(), getCommissionRate(), getTotalEarning(),
        COMMISSION_RATE_MAX, COMMISSION_RATE_MIN);
  }
}
