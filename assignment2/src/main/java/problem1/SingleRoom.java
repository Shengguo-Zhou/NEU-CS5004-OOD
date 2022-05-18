package problem1;

/**
 * Represent a SingleRoom class extends from Room
 * SingleRoom class has a max_occupancy of 1
 * @author Shengguo Zhou
 * @version 1.0
 */
public class SingleRoom extends Room{
  private static final int MAX_OCCUPANCY = 1;

  /**
   * Constructor that creates a new SingleRoom object.
   * @param maxOccupancy - max of occupancy.
   * @param price - room price.
   * @param numberOfGuest - number of guest.
   */
  public SingleRoom(int maxOccupancy, double price, int numberOfGuest) {
    super(MAX_OCCUPANCY, price, numberOfGuest);
  }

}
