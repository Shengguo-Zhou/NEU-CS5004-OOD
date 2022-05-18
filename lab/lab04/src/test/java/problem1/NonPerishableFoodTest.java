package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NonPerishableFoodTest {
  private Rice rice = new Rice("rice",1.0,2,3);
  private Pasta pasta = new Pasta("pasta",1.0,2,3);
  @Test
  void getName() {
    assertEquals(rice.getName(), "rice");
    assertEquals(pasta.getName(), "pasta");
  }

  @Test
  void getCurrentPricePerUnit() {
    assertEquals(rice.getCurrentPricePerUnit(), 1.0);
    assertEquals(pasta.getCurrentPricePerUnit(), 1.0);
  }

  @Test
  void getCurrentlyAvailableQ() {
    assertEquals(rice.getCurrentlyAvailableQ(), 2);
    assertEquals(pasta.getCurrentlyAvailableQ(), 2);
  }

  @Test
  void getMaxAllowedQ() {
    assertEquals(rice.getMaxAllowedQ(), 250);
    assertEquals(pasta.getMaxAllowedQ(), 250);
  }

  @Test
  void testHashCode() {
    assertEquals(rice.hashCode(), rice.hashCode());
    assertEquals(pasta.hashCode(), pasta.hashCode());
  }

}