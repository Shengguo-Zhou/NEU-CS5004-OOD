package problem1and2;

import java.util.Objects;

/**
 * This is an element class. It represents an object that has a priority and a value
 */
public class Element {

  /**
   * Creating a private instance variable called `priority` that is of type `Integer`.
   */
  private Integer priority;
  /**
   * Creating a private instance variable called `value` that is of type `String`.
   */
  private String value;

  /**
   * Constructor for element with priority and value
   * @param priority - the priority of the element, integer
   * @param value    - the value of the element, string
   */
  public Element(Integer priority, String value) {
    this.priority = priority;
    this.value = value;
  }

  /**
   * Return the priority of the element
   * @return the priority of the element, integer
   */
  public Integer getPriority() {
    return this.priority;
  }

  /**
   * Return the value of the element
   * @return the value of the element, string
   */
  public String getValue() {
    return this.value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return priority + ":" + value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Element)) {
      return false;
    }
    Element element = (Element) o;
    return Objects.equals(getPriority(), element.getPriority()) && Objects.equals(
        getValue(), element.getValue());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(getPriority(), getValue());
  }
}
