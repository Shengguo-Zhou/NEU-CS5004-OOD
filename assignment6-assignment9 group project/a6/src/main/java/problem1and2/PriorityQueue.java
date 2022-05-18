package problem1and2;

import java.util.Objects;

/**
 *This is a class for PriorityQueue. It represents an immutable Priority Queue (PQ),
 * where the elements are ordered by a priority
 */
public class PriorityQueue {

  /**
   * Declaring a private instance variable called element.
   */
  private Element element;
  /**
   * Declaring a private instance variable called rest.
   */
  private PriorityQueue rest;

  /**
   * Constructor for PriorityQueue
   */
  public PriorityQueue() {
  }

  /**
   * Overloaded constructor for the PriorityQueue class.
   * @param element - an element
   */
  public PriorityQueue(Element element) {
    this.element = element;
  }

  /**
   * Overloaded constructor for the PriorityQueue class.
   * @param element - an element
   * @param rest - rest of the PQ.
   */
  public PriorityQueue(Element element, PriorityQueue rest) {
    this.element = element;
    this.rest = rest;
  }

  /**
   * Get the element of the PriorityQueue
   * @return element, Element class
   */
  public Element getElement() {
    return this.element;
  }

  /**
   * Get the rest of the PriorityQueue
   * @return rest, PriorityQueue class
   */
  public PriorityQueue getRest() {
    return this.rest;
  }

  /**
   * Create an Empty priority queue
   * @return an empty priority queue with nothing
   */
  public PriorityQueue createEmpty() {
    return new PriorityQueue();
  }

  /**
   * Check whether the priority queue is empty
   * @return True if element is Null else False, boolean
   */
  public Boolean isEmpty() {
    return this.element == null;
  }

  /**
   * If the priority of the new element is greater than the current element, then the new element
   * becomes the head of the queue. If the priority of the new element is less than the current
   * element, then the new element becomes the tail of the queue.If the priority of the new element
   * is equal to the current element, then the new element becomes the second element in the queue
   *
   * @param priority The priority of the element to be added.
   * @param value    The value to be added to the queue.
   * @return A new PriorityQueue object.
   */
  public PriorityQueue add(Integer priority, String value) {
    Element newEle = new Element(priority, value);
    if (this.element == null) {
      return new PriorityQueue(newEle);
    }
    if (priority > this.element.getPriority()) {
      return new PriorityQueue(newEle, this);
    } else if (this.rest == null) {
      return new PriorityQueue(this.element, new PriorityQueue(newEle));
    } else {
      return new PriorityQueue(this.element, this.rest.add(priority, value));
    }
  }

  /**
   *  Returns the value in the PQ that has the highest priority.
   * @return the value in the PQ that has the highest priority, string
   * @throws IllegalCallerException when the element is empty
   */
  public String peek() throws IllegalCallerException{
    if (this.element == null) {
      throw new IllegalCallerException("there is nothing in this priority");
    }
    return this.element.getValue();
  }

  /**
   * Returns a copy of the PQ without the element with the highest priority.
   * @return a copy of the PQ without the element with the highest priority.
   * @throws IllegalCallerException when the element is empty
   */
  public PriorityQueue pop() throws IllegalCallerException {
    if (this.element == null) {
      throw new IllegalCallerException("there is nothing in this priority");
    }
    return new PriorityQueue(this.element, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return element + ", " + rest;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PriorityQueue)) {
      return false;
    }
    PriorityQueue that = (PriorityQueue) o;
    return Objects.equals(getElement(), that.getElement()) && Objects.equals(
        getRest(), that.getRest());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(getElement(), getRest());
  }
}
