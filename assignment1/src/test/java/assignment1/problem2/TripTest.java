package assignment1.problem2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TripTest {

  private Time startTime;
  private Time endTime;
  private Trip trip;

  @BeforeEach
  void setUp() {
    this.startTime = new Time(2,3,4);
    this.endTime = new Time(4,1,2);
    this.trip = new Trip("North","South", startTime, endTime);
  }

  @Test
  void getDuration() {
    Assertions.assertEquals(trip.getDuration(), new Time(1, 57, 58));
  }

  @Test
  void getStartLocation() {
    Assertions.assertEquals("North", this.trip.getStartLocation());
  }

  @Test
  void getEndLocation() {
    Assertions.assertEquals("South", this.trip.getEndLocation());
  }

  @Test
  void getStartTime() {
    Assertions.assertEquals("2:3:4", this.trip.getStartTime());
  }

  @Test
  void getEndTime() {
    Assertions.assertEquals("4:1:2", this.trip.getEndTime());
  }

}
