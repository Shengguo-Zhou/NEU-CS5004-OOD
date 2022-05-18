package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AthleteTest {
  private Athlete athlete1;
  private Athlete athlete2;
  private Name name1;
  private Name name2;
  @BeforeEach
  void setUp() {
    this.name1 = new Name("a", "b", "c");
    this.name2 = new Name("d", "e","f");
    this.athlete1 = new Athlete(name1, 1.00, 2.00,"l1");
    this.athlete2 = new Athlete(name2, 3.00, 4.00);
  }

  @Test
  void getAthletesName() {
    Assertions.assertEquals(name1, this.athlete1.getAthletesName());
    Assertions.assertEquals(name2, this.athlete2.getAthletesName());
  }

  @Test
  void getHeight() {
    Assertions.assertEquals(1.00, this.athlete1.getHeight());
    Assertions.assertEquals(3.00, this.athlete2.getHeight());
  }

  @Test
  void getWeight() {
    Assertions.assertEquals(2.00, this.athlete1.getWeight());
    Assertions.assertEquals(4.00, this.athlete2.getWeight());
  }

  @Test
  void getLeague() {
    Assertions.assertEquals("l1", this.athlete1.getLeague());
    Assertions.assertEquals(null, this.athlete2.getLeague());
  }
}