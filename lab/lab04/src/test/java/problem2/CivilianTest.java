package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CivilianTest {

  Farmer farmer = new Farmer("a",10,11);
  Engineer engineer = new Engineer("b",11,2);
  Sniper sniper = new Sniper("c", 15,3);
  Marine marine = new Marine("d",16, 6);

  @Test
  void addCurrent() {
    farmer.addCurrent(10);
    assertEquals(farmer.wealth,21);
  }

  @Test
  void reduceCurrent() {
    farmer.reduceCurrent(10);
    assertEquals(farmer.wealth,1);
  }
}