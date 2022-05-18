package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SizeTest {

  private Size size1 = new Size(1,2,3);
  private Size size2 = new Size(4,2,3);
  private Size size3 = new Size(1,4,3);
  private Size size4 = new Size(1,2,4);


  @Test
  void testGetWidth() {
    assertEquals(size1.getWidth(), 1);
  }

  @Test
  void testGetHeight() {
    assertEquals(size1.getHeight(), 2);
  }

  @Test
  void testGetDepth() {
    assertEquals(size1.getDepth(), 3);
  }

  @Test
  void testEquals() {
    assertEquals(size1, size1);
    assertNotEquals(size1, size2);
    assertNotEquals(size1, size3);
    assertNotEquals(size1, size4);
  }

  @Test
  void testHashCode() {
    assertEquals(size1.hashCode(), size1.hashCode());
    assertNotEquals(size1.hashCode(), size2.hashCode());
    assertNotEquals(size1.hashCode(), size3.hashCode());
    assertNotEquals(size1.hashCode(), size4.hashCode());
  }
}