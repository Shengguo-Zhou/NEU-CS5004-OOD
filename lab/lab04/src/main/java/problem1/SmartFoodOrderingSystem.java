package problem1;

import java.util.LinkedList;

/**
 * Represent the abstract order system
 * @author Shengguo Zhou
 * @version 1.0
 */
public class SmartFoodOrderingSystem {
  private LinkedList<Food> list= new LinkedList<>();
  private String groceryRetailer;

  /**
   * Represent the abstract order system
   * @author Shengguo Zhou
   * @version 1.0
   */
  public SmartFoodOrderingSystem(String groceryRetailer) {
    this.groceryRetailer = groceryRetailer;
  }

  /**
   * Represent the get grocery
   * @author Shengguo Zhou
   * @version 1.0
   */
  public String getGroceryRetailer() {
    return groceryRetailer;
  }

  /**
   * Represent food linkedlist
   * @author Shengguo Zhou
   * @version 1.0
   */
  public LinkedList<Food> getDailyList(){
    return list;
  }

  /**
   * Represent add food
   * @author Shengguo Zhou
   * @version 1.0
   */
  public void addFood(Food food){
    list.add(food);
  }
}
