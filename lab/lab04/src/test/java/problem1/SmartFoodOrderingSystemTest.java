package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class SmartFoodOrderingSystemTest {

  private LocalDateTime now = LocalDateTime.now();
  private LocalDateTime now2 = now.plusHours(3);
  private Meat meat = new Meat("meat",1.00,1,15, now,now2);
  private SmartFoodOrderingSystem smartFoodOrderingSystem = new SmartFoodOrderingSystem("a");
  private LinkedList<Food> list = new LinkedList<>();

  @Test
  void addFoodTest() {
    //add food
    list.add(meat);
    smartFoodOrderingSystem.addFood(meat);
    //get list
    assertEquals(smartFoodOrderingSystem.getDailyList(), list);
  }

  @Test
  void gRFood() {
    assertEquals(smartFoodOrderingSystem.getGroceryRetailer(), "a");
  }
}