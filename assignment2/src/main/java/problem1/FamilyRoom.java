package problem1;

/**
 * Represent a FamilyRoom class extends from Room
 * FamilyRoom class has a max_occupancy of 4
 * @author Shengguo Zhou
 * @version 1.0
 */
public class FamilyRoom extends Room{
  private static final int MAX_OCCUPANCY = 4;

  /**
   * Constructor that creates a new FamilyRoom object.
   * @param maxOccupancy - max of occupancy.
   * @param price - room price.
   * @param numberOfGuest - number of guest.
   */
  public FamilyRoom(int maxOccupancy, double price, int numberOfGuest) {
    super(MAX_OCCUPANCY, price, numberOfGuest);
  }

}
