package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AmountTest {

  private Amount amount1;
  private Amount amount2;

  @BeforeEach
  void setUp() {
    amount1 = new Amount(1, 23);
    amount2 = new Amount(1, 23);
  }

  @Test
  void getDollar() {
    Assertions.assertEquals(amount1.getDollar(), 1);
  }

  @Test
  void getCents() {
    Assertions.assertEquals(amount1.getCents(), 23);
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(amount1, amount2);
  }
}