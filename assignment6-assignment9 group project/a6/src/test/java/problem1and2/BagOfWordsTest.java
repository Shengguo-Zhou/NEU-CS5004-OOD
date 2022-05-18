package problem1and2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BagOfWordsTest {

  private BagOfWords bw1, bw2, bw3, bw13, bw14, bw15;
  private String s0, s1, s2, s3, s4, s5, s6, s11, s12, s13, s14, s15;

  @BeforeEach
  void setUp() {
    this.s0 = "";
    this.s1 = "Jim";
    this.s2 = "Tim";
    this.s3 = "Tom";
    this.s4 = "Mom";
    this.s5 = "Ham";
    this.s6 = "Ram";
    this.s11 = "Jim";
    this.s12 = "Tim";
    this.s13 = "Tom";
    this.s14 = "Mom";
    this.s15 = "Jim";

    this.bw1 = new BagOfWords();
    this.bw1 = this.bw1.add(this.s1);

    this.bw2 = new BagOfWords();
    this.bw2 = this.bw2.add(this.s1);
    this.bw2 = this.bw2.add(this.s2);

    this.bw3 = new BagOfWords();
    this.bw3 = this.bw3.add(this.s1);
    this.bw3 = this.bw3.add(this.s2);
    this.bw3 = this.bw3.add(this.s3);

    this.bw13 = new BagOfWords();
    this.bw13 = this.bw13.add(this.s11);
    this.bw13 = this.bw13.add(this.s12);
    this.bw13 = this.bw13.add(this.s13);

    this.bw14 = new BagOfWords();
  }

  @Test
  void emptyBagOfWords() {
    this.bw15 = this.bw1.emptyBagOfWords();
    Assertions.assertEquals("null, null", this.bw15.toString());
  }

  @Test
  void isEmpty() {
    Assertions.assertFalse(this.bw3.isEmpty());
    Assertions.assertTrue(this.bw14.isEmpty());
  }

  @Test
  void size() {
    Assertions.assertEquals(1, this.bw1.size());
    Assertions.assertEquals(3, this.bw3.size());
    Assertions.assertEquals(0, this.bw14.size());
  }

  @Test
  void get() {
    bw1.getFirst();
    bw1.getRest();
    Assertions.assertEquals(1, this.bw1.size());
    Assertions.assertEquals(3, this.bw3.size());
    Assertions.assertEquals(0, this.bw14.size());
  }

  @Test
  void getStringHashCode() {
    Assertions.assertEquals(74509, this.bw1.getStringHashCode(this.s1));
  }

  @Test
  void add() {
    this.bw14 = this.bw14.add(this.s14);
    Assertions.assertEquals("77578:Mom, null", this.bw14.toString());

    Assertions.assertEquals("74509:Jim, 84119:Tim, 84305:Tom, null", this.bw3.toString());
    this.bw3 = this.bw3.add(this.s11);
    Assertions.assertEquals("74509:Jim, 74509:Jim, 84119:Tim, 84305:Tom, null",
        this.bw3.toString());
  }

  @Test
  void contains() {
    Assertions.assertTrue(this.bw3.contains("Tom"));
    Assertions.assertTrue(this.bw3.contains("Jim"));
    Assertions.assertFalse(this.bw3.contains("Jimmy"));
    Assertions.assertFalse(this.bw14.contains(""));
  }

  @Test
  void testToString() {
    Assertions.assertEquals("74509:Jim, null", this.bw1.toString());
    Assertions.assertEquals("74509:Jim, 84119:Tim, null", this.bw2.toString());
    Assertions.assertEquals("74509:Jim, 84119:Tim, 84305:Tom, null", this.bw3.toString());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(this.bw3.equals(this.bw3));
    Assertions.assertTrue(this.bw3.equals(this.bw13));
    Assertions.assertFalse(this.bw13.equals(this.bw2));
    Assertions.assertFalse(this.bw1.equals(this.s1));
    Assertions.assertFalse(this.bw1.equals(this.s2));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.bw3.hashCode(), this.bw13.hashCode());
  }
}