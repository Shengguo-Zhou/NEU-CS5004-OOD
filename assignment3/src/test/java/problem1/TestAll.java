package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAll {
  private Cleaning clean = new Cleaning("abc", Size.small,true,1,1);
  private Cleaning clean2 = new Cleaning("abc", Size.medium,true,1,1);
  private Cleaning clean3 = new Cleaning("abc", Size.large,true,1,1);
  private Cleaning clean4 = new Cleaning("bc", Size.small,true,1,1);
  private Painting paint = new Painting("abc",Size.medium, false, 1,3);
  private Painting paint2 = new Painting("abc",Size.large, false, 1,3);
  private Gardening gardening = new Gardening("abc",Size.large, true,3);
  private WindowCleaning wc2 = new WindowCleaning("abc", Size.medium, true,3,2);
  private Electrical e = new Electrical("abc", Size.medium,false,2,2,true);
  private Plumbing plumbing = new Plumbing("abc", Size.medium,true,1,2,true);
  private Plumbing plumbing2 = new Plumbing("abc", Size.medium,true,1,0,true);
  private Plumbing plumbing3 = new Plumbing("abc", Size.medium,true,1,0,false);
  private WindowCleaning wc, wc3;
  private Electrical e2;

  TestAll() throws arguementError {
  }

  @Test
  void TestAll() throws arguementError {
   wc = new WindowCleaning("abc", Size.small, false, 3,2);
  }

  @Test
  void testArgumentError(){
    assertThrows(arguementError.class, () -> {
      wc3 = new WindowCleaning("abc", Size.small, false, 3,20);
    });
    assertThrows(arguementError.class, () -> {
      e2 = new Electrical("abc", Size.small, false, 3,20,true);
    });
  }

  @Test
  void getAddress() {
    assertEquals(clean.getAddress(), "abc");
  }

  @Test
  void getSize() {
    assertEquals(clean.getSize(), Size.small);
  }

  @Test
  void isCarryout() {
    assertEquals(clean.isCarryout(), true);
    assertEquals(paint.isCarryout(), false);
  }

  @Test
  void getNumber() {
    assertEquals(clean.getNumber(),1);
  }

  @Test
  void calculatePrice() {
    assertEquals(clean.calculatePrice(), 75.60000000000001);
    assertEquals(paint.calculatePrice(), 1369.6000000000001);
    assertEquals(gardening.calculatePrice(), 308.0);
    assertEquals(wc2.calculatePrice(), 151.20000000000002);
    assertEquals(e.calculatePrice(), 400.0);
    assertEquals(plumbing.calculatePrice(), 420.0);
  }

  @Test
  void testEquals() {
    assertEquals(clean, clean);
    assertNotEquals(clean, paint);
    assertNotEquals(clean, clean4);
    assertNotEquals(clean, "abc");
  }

  @Test
  void testHashCode() {
    assertEquals(clean.hashCode(),clean.hashCode());
    assertNotEquals(clean.hashCode(), "abc".hashCode());
  }
}