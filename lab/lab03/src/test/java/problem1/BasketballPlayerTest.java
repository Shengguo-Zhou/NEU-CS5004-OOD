package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasketballPlayerTest {
  private BasketballPlayer b1;
  private BasketballPlayer b2;
  private Name name1;
  private Name name2;

  @BeforeEach
  void setUp() {
    this.name1 = new Name("a", "b", "c");
    this.name2 = new Name("d", "e", "f");
    this.b1 = new BasketballPlayer(name1, 1.00, 2.00, "l1",
        "5.00", 6.00, 1);
    this.b2 = new BasketballPlayer(name2, 3.00, 4.00,
        "7.00", 8.00, 2);
  }

  @Test
  void getAthletesName() {
    Assertions.assertEquals(name1, this.b1.getAthletesName());
    Assertions.assertEquals(name2, this.b2.getAthletesName());
  }

  @Test
  void getHeight() {
    Assertions.assertEquals(1.00, this.b1.getHeight());
    Assertions.assertEquals(3.00, this.b2.getHeight());
  }

  @Test
  void getWeight() {
    Assertions.assertEquals(2.00, this.b1.getWeight());
    Assertions.assertEquals(4.00, this.b2.getWeight());
  }

  @Test
  void getLeague() {
    Assertions.assertEquals("l1", this.b1.getLeague());
    Assertions.assertEquals(null, this.b2.getLeague());
  }

  @Test
  void getTeam() {
    Assertions.assertEquals("5.00", this.b1.getTeam());
    Assertions.assertEquals("7.00", this.b2.getTeam());
  }

  @Test
  void setTeam() {
    b1.setTeam("5.55");
    b2.setTeam("7.77");
    Assertions.assertEquals("5.55", this.b1.getTeam());
    Assertions.assertEquals("7.77", this.b2.getTeam());
  }

  @Test
  void getAverageBatting() {
    Assertions.assertEquals(6.00, this.b1.getAverageBatting());
    Assertions.assertEquals(8.00, this.b2.getAverageBatting());
  }

  @Test
  void setAverageBatting() {
    b1.setAverageBatting(6.66);
    b2.setAverageBatting(8.88);
    Assertions.assertEquals(6.66, this.b1.getAverageBatting());
    Assertions.assertEquals(8.88, this.b2.getAverageBatting());
  }

  @Test
  void getSeasonHomeRuns() {
    Assertions.assertEquals(1, this.b1.getSeasonHomeRuns());
    Assertions.assertEquals(2, this.b2.getSeasonHomeRuns());
  }

  @Test
  void setSeasonHomeRuns() {
    b1.setSeasonHomeRuns(2);
    b2.setSeasonHomeRuns(4);
    Assertions.assertEquals(2, this.b1.getSeasonHomeRuns());
    Assertions.assertEquals(4, this.b2.getSeasonHomeRuns());
  }
}