package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransitTest {
  private TripReport tripreport = new TripReport("bus",1f,2f,3);
  private Bus bus = new Bus("abc",1f,2f,tripreport);
  private Train train = new Train("abc",1f,2f,tripreport);
  private Boat boat = new Boat("abc",1f,2f,tripreport);

  @Test
  void drive() {
    assertEquals(bus.drive(1f,bus), null);
  }

  @Test
  void testDrive() {
    assertEquals(bus.drive(2f), 1);
  }

  @Test
  void testDrive1() {
    assertEquals(bus.drive(1,2), 2F);
  }

  @Test
  void testDrive2() {
    assertEquals(bus.drive(bus), "abc");
  }
}