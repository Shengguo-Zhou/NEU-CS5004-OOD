package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CourseCatalogTest {

  Course course1 = new Course("abc", "ab",1);
  Course course2 = new Course("abc", "ab",2);
  Course course3 = new Course("abc", "ab",3);
  Course course4 = new Course("bc", "ab",1);
  CourseCatalog courseCatalog = new CourseCatalog();
  CourseCatalog courseCatalog2 = new CourseCatalog();

  @Test
  void append() {
    courseCatalog.append(course1);
    assertEquals(courseCatalog.checkValid(1),true);
    assertEquals(courseCatalog.index, 1);
    assertEquals(courseCatalog.checkValid(15),false);
  }

  @Test
  void remove() throws CourseNotFoundException {
    courseCatalog.append(course1);
    courseCatalog.append(course1);
    courseCatalog.append(course2);
    courseCatalog.remove(course1);
    assertEquals(courseCatalog.index, 2);
    assertThrows(CourseNotFoundException.class, () -> {
      courseCatalog.remove(course3);
    });
  }

  @Test
  void moveforward() {
    courseCatalog.append(course1);
    courseCatalog.append(course2);
    int INDEX = 0;
    courseCatalog.moveforward(courseCatalog.array, INDEX);
    assertEquals(courseCatalog.index, 1);
  }

  @Test
  void contains() {
    courseCatalog.append(course1);
    assertEquals(courseCatalog.contains(course1), true);
    assertEquals(courseCatalog.contains(course2), false);
  }

  @Test
  void indexOf() {
    courseCatalog.append(course1);
    assertEquals(courseCatalog.indexOf(course1), 0);
    assertEquals(courseCatalog.indexOf(course2), -1);
  }

  @Test
  void count() {
    courseCatalog.append(course1);
    assertEquals(courseCatalog.count(), 1);
  }

  @Test
  void get() throws InvalidIndexException {
    courseCatalog.append(course1);
    assertEquals(courseCatalog.get(1), course1);
    assertThrows(InvalidIndexException.class, () -> {
      courseCatalog.get(2);
    });

  }

  @Test
  void isEmpty() {
    assertEquals(courseCatalog.isEmpty(), true);
    courseCatalog.append(course1);
    assertEquals(courseCatalog.isEmpty(), false);
  }

  @Test
  void testEquals() {
    courseCatalog2.append(course1);
    assertEquals(courseCatalog, courseCatalog);
    assertEquals(course1, course1);
    assertNotEquals(course2, course1);
    assertNotEquals(course4, course1);
    int a = 123;
    assertNotEquals(course1, a);
    assertNotEquals(courseCatalog, a);
    assertNotEquals(courseCatalog, courseCatalog2);
    assertEquals(courseCatalog2, courseCatalog2);
  }

  @Test
  void testHashCode() {
    courseCatalog2.append(course1);
    assertEquals(courseCatalog.hashCode(), courseCatalog.hashCode());
    assertNotEquals(courseCatalog.hashCode(), courseCatalog2.hashCode());
    assertEquals(courseCatalog2.hashCode(), courseCatalog2.hashCode());
    assertNotEquals(course1.hashCode(), courseCatalog2.hashCode());
    assertEquals(course1.hashCode(), course1.hashCode());
  }

  @Test
  void testToString() {
    courseCatalog.append(course1);
    assertEquals(courseCatalog.toString(), "CourseCatalog{" + "array=" + courseCatalog.array +
        ", index=" + courseCatalog.index + '}');
    assertEquals(course1.toString(), "ab1: abc");
  }
}