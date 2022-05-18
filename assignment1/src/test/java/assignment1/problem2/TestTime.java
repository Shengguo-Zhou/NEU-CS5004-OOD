package assignment1.problem2;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeTest {

  private Time time;

  @BeforeEach
  void setUp() {
    time = new Time(1,2,3);
  }

  @Test
  void invalidInput(){
    assertThrows(IllegalArgumentException.class, () -> {
      new Time(100,-1,61);
    });
  }

  @Test
  void getHour() {
    Assertions.assertEquals(1, time.getHour());
  }

  @Test
  void getMinute() {
    Assertions.assertEquals(2, time.getMinute());
  }

  @Test
  void getSecond() {
    Assertions.assertEquals(3, time.getSecond());
  }


}
