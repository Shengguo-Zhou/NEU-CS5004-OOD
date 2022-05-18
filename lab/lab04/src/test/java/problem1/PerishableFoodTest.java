package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class PerishableFoodTest {
  private LocalDateTime now = LocalDateTime.now();
  private LocalDateTime now2 = now.plusHours(3);
  private Meat meat = new Meat("meat",1.00,1,15, now,now2);
  private Fruit fruit = new Fruit("rice",1.00,1,15, now,now2);
  private Vegetable vegetable = new Vegetable("vegetable",1.00,1,15, now,now2);

  @Test
  void getOrderDate() {
    assertEquals(meat.getOrderDate(), now);
  }

  @Test
  void getExpirationDate() {
    assertEquals(meat.getExpirationDate(), now2);
  }
}