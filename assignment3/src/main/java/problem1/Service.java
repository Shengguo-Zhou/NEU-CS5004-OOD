package problem1;

import java.util.Objects;
/**
 * Represent an abstract Service class
 * @author Shengguo Zhou
 * @version 1.0
 */
public abstract class Service{

  /**
   * address - address of the service
   */
  protected String address;
  /**
   * size - size of the service
   */
  protected Size size;
  /**
   * carryout - service is carried or not
   */
  protected boolean carryout;
  /**
   * number - preservice number
   */
  protected Integer number;

  /**
   * Constructor that creates a new service object.
   * @param address - address of the service
   * @param size - size of the service
   * @param carryout - service is carried or not
   * @param number - preservice number
   */
  public Service(String address, Size size, boolean carryout, Integer number) {
    this.address = address;
    this.size = size;
    this.carryout = carryout;
    this.number = number;
  }

  /**
   * get address function
   * @return address - address of service
   */
  public String getAddress() {
    return address;
  }

  /**
   * get size function
   * @return size - size of service
   */
  public Size getSize() {
    return size;
  }

  /**
   * iscarryout function
   * @return boolean - whether the service is carried out
   */
  public boolean isCarryout() {
    return carryout;
  }

  /**
   * get number function
   * @return number - number of preservice
   */
  public Integer getNumber() {
    return number;
  }

  /**
   * get pirce function
   */
  public abstract double calculatePrice();

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
    if (!(o instanceof Service)) {
      return false;
    }
    Service service = (Service) o;
    return isCarryout() == service.isCarryout() && getAddress().equals(service.getAddress())
        && getSize() == service.getSize() && getNumber().equals(service.getNumber());
  }

  /**
   * hashcode function, if the two objects are equal, return
   * the same hashcode
   * @return an integer of the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getAddress(), getSize(), isCarryout(), getNumber());
  }
}
