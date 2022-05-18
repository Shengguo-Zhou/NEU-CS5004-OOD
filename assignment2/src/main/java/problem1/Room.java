package problem1;

import java.util.Objects;

/**
 * Represent the abstract Room class
 * @author Shengguo Zhou
 * @version 1.0
 */

public abstract class Room {

  /**
   * maxOccupancy - max of occupancy.
   */
  protected int maxOccupancy;
  /**
   * price - room price.
   */
  protected double price;
  /**
   * numberOfGuest - number of guest.
   */
  protected int numberOfGuest;

  /**
   * Constructor that creates a new SingleRoom object.
   * @param maxOccupancy - max of occupancy.
   * @param price - room price.
   * @param numberOfGuest - number of guest.
   */
  public Room(int maxOccupancy, double price, int numberOfGuest) {
    this.maxOccupancy = maxOccupancy;

    if(price <= 0){
      throw new IllegalArgumentException("The price should be greater than 0");
    }
    else{
      this.price = price;
    }

    if(numberOfGuest != 0){
      throw new IllegalArgumentException("The number of guest of a new room should be 0");
    }
    else{
      this.numberOfGuest = 0;
    }

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
    if (!(o instanceof Room)) {
      return false;
    }
    Room room = (Room) o;
    return getMaxOccupancy() == room.getMaxOccupancy()
        && Double.compare(room.getPrice(), getPrice()) == 0
        && getNumberOfGuest() == room.getNumberOfGuest();
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMaxOccupancy(), getPrice(), getNumberOfGuest());
  }

  /**
   * get max occupancy function
   * @return maxOccupancy - max number occupancy
   */
  public int getMaxOccupancy() {
    return maxOccupancy;
  }

  /**
   * get price function
   * @return price - the price of room
   */
  public double getPrice() {
    return price;
  }

  /**
   * get number of guest function
   * @return numberOfGuest - the number of the guest
   */
  public int getNumberOfGuest() {
    return numberOfGuest;
  }

  /**
   * isAvailable - check whether the room is available
   * @return true - the room is available
   * false - the room is not available
   */
  public boolean isAvailable(){
    return numberOfGuest == 0 ? true : false;
  }

  /**
   * bookRoom - hava a check whether they can book a room,
   * if the room is available, set the number of guest
   * @param numberOfGuest - the number of the guest
   */
  public void bookRoom(int numberOfGuest){
    if(this.isAvailable() && numberOfGuest > 0 && numberOfGuest <= this.maxOccupancy){
      this.numberOfGuest = numberOfGuest;
    }
    else{
      throw new IllegalArgumentException("Room is not available or input invalid");
    }
  }

}
