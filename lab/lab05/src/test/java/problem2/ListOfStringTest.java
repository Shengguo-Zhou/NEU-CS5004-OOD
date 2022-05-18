package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListOfStringTest {

  private List<String> list = new LinkedList<>();
  private List<String> list2 = new LinkedList<>();
  private List<String> list3 = new LinkedList<>();
  private List<String> list4 = new LinkedList<>();
  private List<String> list5 = new LinkedList<>();

  private ListOfString ls = new ListOfString();
  private ListOfString ls2 = new ListOfString(list);
  private ListOfString ls3 = new ListOfString(list2);

  @BeforeEach
  void setUp() {
    list.add("abc");
    list.add("abc");
    list.add("abc");
    list.add("dc");
    list.add("dc");

    list2.add("abc");
    list2.add("abc");
    list2.add("abc");
    list2.add("dc");
    list2.add("dc");

    list3.add("abc");
    list3.add("abc");
    list3.add("abc");

    list4.add("abc");
    list4.add("dc");

    list5.add("abc");
    list5.add("abc");
    list5.add("dc");
  }

  @Test
  void isEmpty() {
    assertEquals(ls.isEmpty(), true);
    assertEquals(ls2.isEmpty(), false);
  }

  @Test
  void size() {
    assertEquals(ls.size(), 0);
    assertEquals(ls2.size(), 5);
  }

  @Test
  void contains() {
    assertEquals(ls2.contains("abc"), true);
    assertEquals(ls2.contains("aaa"), false);
  }

  @Test
  void containsAll() {
    assertEquals(ls2.containsAll(ls3), true);
  }

  @Test
  void filerLargerThan() {
    assertEquals(ls2.filerLargerThan(2), new ListOfString(list3));
  }

  @Test
  void hasDuplicates() {
    assertEquals(ls2.hasDuplicates(), true);
  }

  @Test
  void removeDuplicate() {
    assertEquals(ls2.removeDuplicate(), new ListOfString(list4));
  }

}