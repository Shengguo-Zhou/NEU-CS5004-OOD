package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PosnTest {

  Posn p1;
  Posn p2;
  Posn p3;

  @BeforeEach
  void setUp() {
    p1 = new Posn(1,2);
    p2 = new Posn(1,2);
    p3 = new Posn(2,3);
  }

  @Test
  void getX() {
    Assertions.assertEquals(1,p1.getX());
  }

  @Test
  void getY() {
    Assertions.assertEquals(2,p1.getY());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(p1, p2);
    Assertions.assertNotEquals(p1, p3);
    Assertions.assertNotEquals(null, p3);
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(p1.hashCode(), p2.hashCode());
    Assertions.assertNotEquals(p1.hashCode(), p3.hashCode());
    Assertions.assertNotEquals(0, p3.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Posn{x=1, y=2}", p1.toString());
  }
}