package problem2;

import java.util.Objects;

/**
 * Represents the Size class
 * @author Shengguo Zhou
 * @version 1.0
 */
public class Size {

  /**
   * width - the width size
   */
  private int width;
  /**
   * height - the height size
   */
  private int height;
  /**
   * depth - the depth size
   */
  private int depth;

  /**
   * Constructor : create the constructor of size
   * @param width - width length
   * @param height - height length
   * @param depth - depth length
   */
  public Size(int width, int height, int depth) {
    this.width = width;
    this.height = height;
    this.depth = depth;
  }

  /**
   * getWidth - get the width
   * @return width - width length
   */
  public int getWidth() {
    return width;
  }

  /**
   * getHeight - get the height
   * @return height - height length
   */
  public int getHeight() {
    return height;
  }

  /**
   * getDepth - get the depth
   * @return depth - depth length
   */
  public int getDepth() {
    return depth;
  }

  /**
   * override the equal function
   * @param o - the object of the function
   * @return if they are equal, return true,
   * else return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Size)) {
      return false;
    }
    Size size = (Size) o;
    return getWidth() == size.getWidth() && getHeight() == size.getHeight()
        && getDepth() == size.getDepth();
  }

  /**
   * override the hashCode function
   * @return if they are equal, return true,
   * else return false
   */
  @Override
  public int hashCode() {
    return Objects.hash(getWidth(), getHeight(), getDepth());
  }
}
