package problem1and2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {

  private Element e1, e2, e3, e4, e5, e11, e12, e13;
  private PriorityQueue p1, p2, p3, p4, p5, p11, p12, p13, p14;

  @BeforeEach
  void setUp() {
    this.e1 = new Element(1, "e1");
    this.e2 = new Element(2, "e2");
    this.e3 = new Element(3, "e3");
    this.e4 = new Element(4, "e4");
    this.e5 = new Element(5, "e5");
    this.e11 = new Element(1, "e11");
    this.e12 = new Element(2, "e12");
    this.e13 = new Element(3, "e13");

    this.p1 = new PriorityQueue(this.e1);
    this.p2 = new PriorityQueue(this.e2, this.p1);
    this.p3 = new PriorityQueue(this.e3, this.p2);
    this.p4 = new PriorityQueue(this.e4, this.p3);
    this.p5 = new PriorityQueue(this.e5, this.p4);
    this.p11 = new PriorityQueue(this.e11);
    this.p12 = new PriorityQueue(this.e12, this.p11);
    this.p13 = new PriorityQueue(this.e13, this.p12);
    this.p14 = new PriorityQueue();
  }

  @Test
  void getElement() {
    Assertions.assertEquals(this.e5, this.p5.getElement());
    Assertions.assertEquals(this.e11, this.p11.getElement());
  }

  @Test
  void getRest() {
    Assertions.assertEquals(this.p4, this.p5.getRest());
    Assertions.assertEquals(this.p12, this.p13.getRest());
    Assertions.assertNull(this.p1.getRest());
  }

  @Test
  void createEmpty() {
    this.p3 = this.p3.createEmpty();
    Assertions.assertNull(this.p3.getElement());
    Assertions.assertNull(this.p3.getRest());
  }

  @Test
  void isEmpty() {
    Assertions.assertTrue(this.p14.isEmpty());
    Assertions.assertFalse(this.p3.isEmpty());
    this.p3 = this.p3.createEmpty();
    Assertions.assertTrue(this.p3.isEmpty());
  }

  @Test
  void add() {
    Assertions.assertEquals("3:e13, 2:e12, 1:e11, null", this.p13.toString());
    this.p13 = this.p13.add(7, "newEle");
    Assertions.assertEquals("7:newEle, 3:e13, 2:e12, 1:e11, null", this.p13.toString());

    Assertions.assertEquals("4:e4, 3:e3, 2:e2, 1:e1, null", this.p4.toString());
    this.p4 = this.p4.add(2, "newEle");
    Assertions.assertEquals("4:e4, 3:e3, 2:e2, 2:newEle, 1:e1, null", this.p4.toString());

    Assertions.assertEquals("null, null", this.p14.toString());
    this.p14 = this.p14.add(2, "newEle");
    Assertions.assertEquals("2:newEle, null", this.p14.toString());
    this.p14 = this.p14.add(1, "anotherEle");
    Assertions.assertEquals("2:newEle, 1:anotherEle, null", this.p14.toString());
  }

  @Test
  void peek() {
    Assertions.assertEquals("e13", this.p13.peek());
    Assertions.assertEquals("e4", this.p4.peek());
  }

  @Test
  void expectIllegalCallerException() {
    assertThrows(IllegalCallerException.class,
        () -> {
          String res = this.p14.peek();
        });
  }

  @Test
  void pop() {
    PriorityQueue pq = this.p13.pop();
    Assertions.assertEquals("3:e13, null", pq.toString());
  }

  @Test
  void expectIllegalCallerException2() {
    assertThrows(IllegalCallerException.class,
        () -> {
          PriorityQueue pq = this.p14.pop();
        });
  }

  @Test
  void testToString() {
    Assertions.assertEquals("3:e13, 2:e12, 1:e11, null", this.p13.toString());
    Assertions.assertEquals("4:e4, 3:e3, 2:e2, 1:e1, null", this.p4.toString());
    Assertions.assertEquals("null, null", this.p14.toString());
  }

  @Test
  void testEquals() {
    Assertions.assertTrue(this.p3.equals(this.p3));
    Assertions.assertFalse(this.p3.equals(this.p13));
    Assertions.assertFalse(this.p4.equals(this.p12));
    String s = "TEST";
    Assertions.assertFalse(this.p4.equals(s));
    Assertions.assertFalse(this.e4.equals(this.p4));
    this.p11 = new PriorityQueue(this.e1);
    Assertions.assertTrue(this.p1.equals(this.p11));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.p3.hashCode(), this.p3.hashCode());
  }
}