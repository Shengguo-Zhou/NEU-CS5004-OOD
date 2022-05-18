package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {
  private SingleRoom singleRoom1 = new SingleRoom(1, 100.00, 0);
  private SingleRoom singleRoom2 = new SingleRoom(1, 100.00, 0);
  private SingleRoom singleRoom3 = new SingleRoom(2, 100.00, 0);
  private SingleRoom singleRoom4 = new SingleRoom(1, 100.00, 0);

  private DoubleRoom doubleRoom1 = new DoubleRoom(2, 200.00, 0);
  private DoubleRoom doubleRoom2 = new DoubleRoom(2, 200.00, 0);
  private DoubleRoom doubleRoom3 = new DoubleRoom(0, 200.00, 0);

  private FamilyRoom familyRoom1 = new FamilyRoom(4, 100.00, 0);
  private FamilyRoom familyRoom2 = new FamilyRoom(4, 100.00, 0);
  private FamilyRoom familyRoom3 = new FamilyRoom(0, 100.00, 0);
  private int TEST = 1;

  @Test
  void testConstruction(){
    assertThrows(IllegalArgumentException.class, () ->{
      new SingleRoom(1, -100.00, 0);
    });
    assertThrows(IllegalArgumentException.class, () ->{
      new SingleRoom(1, 100.00, 10);
    });
    assertThrows(IllegalArgumentException.class, () ->{
      new DoubleRoom(1, 100.00, 10);
    });
  }

  @Test
  void testEquals() {
    assertEquals(singleRoom1, singleRoom2);
    assertEquals(singleRoom1, new SingleRoom(1,100,0));
    assertNotEquals(doubleRoom1, new DoubleRoom(2,100,0));
    singleRoom4.bookRoom(TEST);
    assertNotEquals(singleRoom4, singleRoom1);
    assertNotEquals(doubleRoom1, singleRoom1);
    assertEquals(singleRoom1, singleRoom1);
    assertEquals(singleRoom1, singleRoom3);
    assertEquals(doubleRoom1, doubleRoom3);
    assertEquals(familyRoom1, familyRoom3);
    assertNotEquals(singleRoom1, TEST);
  }

  @Test
  void testHashCode() {
    assertEquals(singleRoom1.hashCode(), singleRoom2.hashCode());
    assertEquals(singleRoom1.hashCode(), singleRoom3.hashCode());
    assertEquals(doubleRoom3.hashCode(), doubleRoom2.hashCode());
    assertEquals(familyRoom1.hashCode(), familyRoom2.hashCode());
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(singleRoom1.getMaxOccupancy(), 1);
    assertEquals(singleRoom3.getMaxOccupancy(), 1);
    assertEquals(doubleRoom1.getMaxOccupancy(), 2);
    assertEquals(familyRoom1.getMaxOccupancy(), 4);
  }

  @Test
  void getPrice() {
    assertEquals(singleRoom1.getPrice(), 100.00);
    assertEquals(doubleRoom1.getPrice(), 200.00);
  }

  @Test
  void getNumberOfGuest() {
    assertEquals(singleRoom1.getNumberOfGuest(), 0);
    assertEquals(doubleRoom1.getNumberOfGuest(), 0);
  }

  @Test
  void isAvailable() {
    assertEquals(singleRoom1.isAvailable(), true);
  }

  @Test
  void bookRoom() {
    int TEST_GUEST = 1;
    int INVALID_TEST_GUEST = 10;
    int INVALID_TEST_GUEST2 = -1;

    singleRoom1.bookRoom(TEST_GUEST);
    assertEquals(singleRoom1.getNumberOfGuest(), TEST_GUEST);

    assertThrows(IllegalArgumentException.class, () ->{
      singleRoom1.bookRoom(TEST_GUEST);
    });
    assertThrows(IllegalArgumentException.class, () ->{
      singleRoom1.bookRoom(INVALID_TEST_GUEST);
    });
    assertThrows(IllegalArgumentException.class, () ->{
      singleRoom1.bookRoom(INVALID_TEST_GUEST2);
    });

    doubleRoom1.bookRoom(TEST_GUEST);
    assertEquals(doubleRoom1.getNumberOfGuest(), TEST_GUEST);
    assertThrows(IllegalArgumentException.class, () ->{
      doubleRoom1.bookRoom(TEST_GUEST);
    });
    assertThrows(IllegalArgumentException.class, () ->{
      doubleRoom1.bookRoom(INVALID_TEST_GUEST);
    });

    assertThrows(IllegalArgumentException.class, () ->{
      doubleRoom2.bookRoom(INVALID_TEST_GUEST);
    });
    assertThrows(IllegalArgumentException.class, () ->{
      doubleRoom2.bookRoom(INVALID_TEST_GUEST2);
    });

  }
}