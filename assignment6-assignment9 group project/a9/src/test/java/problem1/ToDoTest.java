package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDoTest {

  private ToDo todo1, todo2, todo3, todo4, todo6, todo7;
  private String line1 = "2,CoreTraining2,TRUE,2022/04/26,3,?";
  private String line2 = "1, CoreTraining,FALSE,?,2,home";
  private String line3 = "?, CoreTraining,FALSE,?,2,home";
  private String line4 = "4,?,FALSE,2,4,home";
  private String line5 = "5, CoreTraining,FALSE,?,5,home";
  private String line6 = "2,CoreTraining2,TRUE,2022/04/26,3,?";
  private String line7 = "2,CoreTraining, 2,Done!,2022/04/26,3,?";

  @BeforeEach
  void setUp() throws RequiredFieldError {
    this.todo1 = new ToDo();
    this.todo1.getToDoList(line1);
    this.todo2 = new ToDo();
    this.todo2.getToDoList(line2);
    this.todo3 = new ToDo();
    this.todo4 = new ToDo();
    this.todo6 = new ToDo();
    this.todo6.getToDoList(line6);
    this.todo7 = new ToDo();

  }

  @Test
  void expectRequiredFieldError() {
    assertThrows(RequiredFieldError.class,
        () -> {
          this.todo3.getToDoList(line3);
        });
  }

  @Test
  void expectRequiredFieldError_1() {
    assertThrows(RequiredFieldError.class,
        () -> {
          this.todo4.getToDoList(line4);
        });
  }

  @Test
  void expectIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class,
        () -> {
          this.todo4.getToDoList(line5);
        });
  }

  @Test
  void expectIllegalArgumentException2() {
    assertThrows(IllegalArgumentException.class,
        () -> {
          this.todo7.getToDoList(line7);
        });
  }

  @Test
  void getToDoList() throws RequiredFieldError {
    this.todo1.getToDoList(line1);
  }

  @Test
  void getText() {
    assertEquals("CoreTraining2", this.todo1.getText());
  }

  @Test
  void getCompleted() {
    assertTrue(this.todo1.getCompleted());
  }

  @Test
  void setCompleted() {
    todo1.setCompleted(false);
    assertFalse(this.todo1.getCompleted());
  }

  @Test
  void getDue() {
    assertEquals("2022/04/26", this.todo1.getDue());
  }

  @Test
  void getPriority() {
    assertEquals(3, this.todo1.getPriority());
  }

  @Test
  void getCategory() {
    assertNull(this.todo1.getCategory());
  }

  @Test
  void getId() {
    assertEquals(2,this.todo1.getId());
  }

  @Test
  void testEquals() {
    assertFalse(todo1.equals(null));
    assertFalse(todo1.equals(todo2));
    assertTrue(todo1.equals(todo1));
    assertTrue(todo1.equals(todo6));
  }

  @Test
  void testHashCode() {
    //test null
    assertFalse(0 == todo1.hashCode());
    //test consistency
    int testHashCode = todo1.hashCode();
    assertEquals(testHashCode, todo1.hashCode());
  }

  @Test
  void testToString() {
    String expected =
        "ToDo{" +
            "id=" + "1" +
            ", text='" + " CoreTraining" + '\'' +
            ", completed=" + "false" +
            ", due='" + "null" + '\'' +
            ", priority=" + "2" +
            ", category='" + "home" +
            '}';
    assertEquals(expected, todo2.toString());
  }
}