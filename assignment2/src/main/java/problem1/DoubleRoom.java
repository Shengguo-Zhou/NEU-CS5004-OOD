package problem1;

/**
 * Represent a DoubleRoom class extends from room
 * DoubleRoom class has a max_occupancy of 2
 * @author Shengguo Zhou
 * @version 1.0
 */

public class DoubleRoom extends Room{
  private static final int MAX_OCCUPANCY = 2;

  /**
   * Constructor that creates a new DoubleRoom object.
   * @param maxOccupancy - max of occupancy.
   * @param price - room price.
   * @param numberOfGuest - number of guest.
   */
  public DoubleRoom(int maxOccupancy, double price, int numberOfGuest) {
    super(MAX_OCCUPANCY, price, numberOfGuest);
  }
}
