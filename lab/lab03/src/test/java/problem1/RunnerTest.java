package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunnerTest {
  private Runner runner1;
  private Runner runner2;
  private Name name1;
  private Name name2;

  @BeforeEach
  void setUp() {
    this.name1 = new Name("a", "b", "c");
    this.name2 = new Name("d", "e","f");
    this.runner1 = new Runner(name1, 1.00, 2.00,"l1",
        5.00, 6.00, "f1");
    this.runner2 = new Runner(name2, 3.00, 4.00,
        7.00, 8.00, "f2");
  }

  @Test
  void getAthletesName() {
    Assertions.assertEquals(name1, this.runner1.getAthletesName());
    Assertions.assertEquals(name2, this.runner2.getAthletesName());
  }

  @Test
  void getHeight() {
    Assertions.assertEquals(1.00, this.runner1.getHeight());
    Assertions.assertEquals(3.00, this.runner2.getHeight());
  }

  @Test
  void getWeight() {
    Assertions.assertEquals(2.00, this.runner1.getWeight());
    Assertions.assertEquals(4.00, this.runner2.getWeight());
  }

  @Test
  void getLeague() {
    Assertions.assertEquals("l1", this.runner1.getLeague());
    Assertions.assertEquals(null, this.runner2.getLeague());
  }

  @Test
  void getBest5KTime() {
    Assertions.assertEquals(5.00, this.runner1.getBest5KTime());
    Assertions.assertEquals(7.00, this.runner2.getBest5KTime());
  }

  @Test
  void getBestHalfMarathonTime() {
    Assertions.assertEquals(6.00, this.runner1.getBestHalfMarathonTime());
    Assertions.assertEquals(8.00, this.runner2.getBestHalfMarathonTime());
  }

  @Test
  void getFavouriteRunningEvent() {
    Assertions.assertEquals("f1", this.runner1.getFavouriteRunningEvent());
    Assertions.assertEquals("f2", this.runner2.getFavouriteRunningEvent());
  }

  @Test
  void setBest5KTime() {
    runner1.setBest5KTime(1.11);
    runner2.setBest5KTime(1.111);
    Assertions.assertEquals(1.11, this.runner1.getBest5KTime());
    Assertions.assertEquals(1.111, this.runner2.getBest5KTime());
  }

  @Test
  void setBestHalfMarathonTime() {
    runner1.setBestHalfMarathonTime(2.22);
    runner2.setBestHalfMarathonTime(2.222);
    Assertions.assertEquals(2.22, this.runner1.getBestHalfMarathonTime());
    Assertions.assertEquals(2.222, this.runner2.getBestHalfMarathonTime());
  }

  @Test
  void setFavouriteRunningEvent() {
    runner1.setFavouriteRunningEvent("3.33");
    runner2.setFavouriteRunningEvent("3.333 + 1.0");
    Assertions.assertEquals("3.33", this.runner1.getFavouriteRunningEvent());
    Assertions.assertEquals("3.333 + 1.0", this.runner2.getFavouriteRunningEvent());
  }
}