package problem;

import java.util.Objects;

/**
 * > A listing is a property that is under contract
 */
public class Listing<P extends Property, C extends Contract> {

  private Property property;
  private Contract contract;

  /**
   * A constructor that takes in a property and a contract and sets the property and contract fields
   * to the given property and contract.
   *
   * @param property - property
   * @param contract - contract
   */
  public Listing(P property, C contract) {
    this.property = property;
    this.contract = contract;
  }

  /**
   * @return The property object.
   */
  public Property getProperty() {
    return property;
  }

  /**
   * @return The contract object.
   */
  public Contract getContract() {
    return contract;
  }

  @Override
  public String toString() {
    return "Listing{" +
        "property=" + property +
        ", contract=" + contract +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Listing)) {
      return false;
    }
    Listing<?, ?> listing = (Listing<?, ?>) o;
    return Objects.equals(getProperty(), listing.getProperty()) && Objects.equals(
        getContract(), listing.getContract());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getProperty(), getContract());
  }
}
