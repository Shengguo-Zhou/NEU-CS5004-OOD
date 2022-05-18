package problem;

import java.util.Objects;

/**
 * A Property is a class that represents a property.
 */
public abstract class Property {

  /**
   * Declaring a private variable called address of type String.
   */
  private String address;
  /**
   * size - in square feet, a non-negative integer.
   */
  private Integer size;

  /**
   * A constructor that takes in two parameters, address and size. It checks if the size is less
   * than 0 or if the address is an empty string. If either of these conditions are true, it throws
   * an IllegalArgumentException. If neither of these conditions are true, it sets the address and
   * size to the parameters.
   *
   * @param address - address
   * @param size    - size
   */
  public Property(String address, Integer size) {
    if (size < 0 || address.equals("")) {
      throw new IllegalArgumentException();
    }
    this.address = address;
    this.size = size;
  }

  /**
   * @return The address of the person.
   */
  public String getAddress() {
    return address;
  }

  /**
   * The function sets the address of the person to the address passed in as a parameter
   *
   * @param address The address of the customer.
   */
  public void setAddress(String address) {
    if (address.equals("")) {
      throw new IllegalArgumentException();
    }
    this.address = address;
  }

  /**
   * @return The size of the array.
   */
  public Integer getSize() {
    return size;
  }

  /**
   * If the size is less than zero, throw an IllegalArgumentException. Otherwise, set the size to
   * the given size
   *
   * @param size The size of the array.
   */
  public void setSize(Integer size) {
    if (size < 0) {
      throw new IllegalArgumentException();
    }
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    Property property = (Property) o;
    return Objects.equals(getAddress(), property.getAddress()) && Objects.equals(
        getSize(), property.getSize());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAddress(), getSize());
  }

  @Override
  public String toString() {
    return "Property{" +
        "address='" + address + '\'' +
        ", size=" + size +
        '}';
  }
}

