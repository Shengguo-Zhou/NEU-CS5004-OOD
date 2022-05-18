package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PiecesTest {

  Farmer farmer = new Farmer("a",10,1);
  Engineer engineer = new Engineer("b",11,2);
  Sniper sniper = new Sniper("c", 15,3);
  Marine marine = new Marine("d",16, 6);

  @Test
  void getName() {
    assertEquals(farmer.getName(), "a");
    assertThrows(IllegalArgumentException.class, () ->{
      new Farmer("a",666, 2);
    });
  }

  @Test
  void testConstructor() {
    assertThrows(IllegalArgumentException.class, () ->{
      new Farmer("a",666, 2);
    });
  }

  @Test
  void getAge() {
    assertEquals(farmer.getAge(),10);
  }

  @Test
  void testHashCode() {
    assertEquals(farmer.hashCode(),farmer.hashCode());
  }
}