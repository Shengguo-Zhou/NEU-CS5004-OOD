package problem;

import java.util.Objects;

/**
 * Commercial is a subclass of Property that has a numOfOffice and a suitableForRetail.
 */
public class Commercial extends Property {

  private Integer numOfOffice;
  private Boolean suitableForRetail;

  /**
   * A constructor that takes in address, size, numOfOffice, and suitableForRetail.
   *
   * @param address           - address
   * @param size              - size
   * @param numOfOffice       - num of office
   * @param suitableForRetail - suitable for retail
   */
  public Commercial(String address, Integer size, Integer numOfOffice,
      Boolean suitableForRetail) {
    super(address, size);
    if (numOfOffice < 0) {
      throw new IllegalArgumentException();
    }
    this.numOfOffice = numOfOffice;
    this.suitableForRetail = suitableForRetail;
  }

  /**
   * @return The number of offices.
   */
  public Integer getNumOfOffice() {
    return numOfOffice;
  }

  /**
   * This function sets the number of offices in the building
   *
   * @param numOfOffice The number of offices in the building.
   */
  public void setNumOfOffice(Integer numOfOffice) {
    if (numOfOffice < 0) {
      throw new IllegalArgumentException();
    }
    this.numOfOffice = numOfOffice;
  }

  /**
   * @return The value of the suitableForRetail field.
   */
  public Boolean getSuitableForRetail() {
    return suitableForRetail;
  }

  /**
   * This function sets the value of the private variable suitableForRetail to the value of the
   * parameter suitableForRetail
   *
   * @param suitableForRetail Whether the product is suitable for retail.
   */
  public void setSuitableForRetail(Boolean suitableForRetail) {
    this.suitableForRetail = suitableForRetail;
  }

  @Override
  public String toString() {
    return "Commercial{" +
        "numOfOffice=" + numOfOffice +
        ", suitableForRetail=" + suitableForRetail +
        "} " + super.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Commercial)) {
      return false;
    }
    Commercial that = (Commercial) o;
    return Objects.equals(getNumOfOffice(), that.getNumOfOffice())
        && Objects.equals(getSuitableForRetail(), that.getSuitableForRetail());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNumOfOffice(), getSuitableForRetail());
  }
}
