package problem;

import java.util.Objects;

/**
 * Residential is a subclass of Property.
 */
public class Residential extends Property {

  private Integer numOfBedroom;
  private Double numOfBathroom;

  /**
   * A constructor for Residential class.
   *
   * @param address       - address
   * @param size          - size
   * @param numOfBedroom  - num of Bedroom
   * @param numOfBathroom - num of Bathroom
   */
  public Residential(String address, Integer size, Integer numOfBedroom,
      Double numOfBathroom) {
    super(address, size);
    if (numOfBathroom < 0 || numOfBedroom < 0) {
      throw new IllegalArgumentException();
    }
    this.numOfBedroom = numOfBedroom;
    this.numOfBathroom = numOfBathroom;
  }

  /**
   * @return The number of bedrooms in the house.
   */
  public Integer getNumOfBedroom() {
    return numOfBedroom;
  }

  /**
   * This function sets the number of bedrooms in the house
   *
   * @param numOfBedroom The number of bedrooms in the property.
   */
  public void setNumOfBedroom(Integer numOfBedroom) {
    this.numOfBedroom = numOfBedroom;
  }

  /**
   * @return The number of bathrooms in the house.
   */
  public Double getNumOfBathroom() {
    return numOfBathroom;
  }

  /**
   * This function sets the value of the numOfBathroom variable
   *
   * @param numOfBathroom The number of bathrooms in the house.
   */
  public void setNumOfBathroom(Double numOfBathroom) {
    this.numOfBathroom = numOfBathroom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Residential)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Residential that = (Residential) o;
    return Objects.equals(getNumOfBedroom(), that.getNumOfBedroom())
        && Objects.equals(getNumOfBathroom(), that.getNumOfBathroom());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getNumOfBedroom(), getNumOfBathroom());
  }

  @Override
  public String toString() {
    return "Residential{" +
        "numOfBedroom=" + numOfBedroom +
        ", numOfBathroom=" + numOfBathroom +
        "} " + super.toString();
  }
}
