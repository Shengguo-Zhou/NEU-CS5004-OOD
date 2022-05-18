package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SoldierTest {
  Farmer farmer = new Farmer("a",10,11);
  Engineer engineer = new Engineer("b",11,2);
  Sniper sniper = new Sniper("c", 15,3);
  Marine marine = new Marine("d",16, 6);

  @Test
  void add() {
    sniper.add(10);
    assertEquals(sniper.stamina, 13);
  }

  @Test
  void testConstructor() {
    assertThrows(IllegalArgumentException.class, () ->{
      new Sniper("a",10, 2222);
    });
  }

  @Test
  void reduce() {
    sniper.reduce(1);
    assertEquals(sniper.stamina, 2);
  }
}