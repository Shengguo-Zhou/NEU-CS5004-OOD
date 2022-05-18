package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SetTest {

  private int DEFAULTLENGTH = 20;
  private int[] array = new int[DEFAULTLENGTH];
  private int LING = 0;

  private Set set = new Set(array, LING);
  private Set set2 = new Set(array, LING);
  private Set set4 = new Set();

  @Test
  void emptySet() {
    Set set3 = set.emptySet();
    assertEquals(set3.isEmpty(),true);
    assertEquals(set3.checkValidIndex(1),true);
    assertEquals(set3.checkValidIndex(15),false);
  }

  @Test
  void isEmpty() {
    assertEquals(set2.isEmpty(), true);
    set2.add(1);
    assertEquals(set2.isEmpty(), false);
  }

  @Test
  void add() {
    set2.add(1);
    assertEquals(set2.index, 1);
    set2.add(1);
    assertEquals(set2.index, 1);
  }

  @Test
  void contains() {
    set2.add(1);
    assertEquals(set2.contains(1), true);
    assertEquals(set2.contains(2), false);
  }

  @Test
  void remove() {
    set2.add(1);
    set2.add(2);
    set2.remove(1);
    assertEquals(set2.index, 1);
    set2.remove(3);
    assertEquals(set2.index, 1);
  }

  @Test
  void size() {
    set2.add(1);
    set2.add(2);
    assertEquals(set2.size(), 2);
  }

  @Test
  void testEquals() {
    set.emptySet();
    assertEquals(set, set2);
    assertEquals(set, set);
    set.add(1);
    set2.add(2);
    Set set10 = new Set();
    Set set11 = new Set();
    set10.add(1);
    assertNotEquals(set10, set11);
    set11.add(2);
    assertNotEquals(set10, set11);
    assertNotEquals(set, "1243");
  }

  @Test
  void testHashCode() {
    set.emptySet();
    assertEquals(set.hashCode(), set2.hashCode());
    assertEquals(set.hashCode(), set.hashCode());
    set.add(1);
    assertNotEquals(set.hashCode(), "1243");
    assertNotEquals(set.hashCode(), set2.hashCode());
  }
}