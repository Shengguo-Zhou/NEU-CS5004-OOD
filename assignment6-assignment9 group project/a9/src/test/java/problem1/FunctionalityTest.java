package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FunctionalityTest {

  private Functionality f1, f2;
  private LinkedHashSet<ToDo> info, info2, info4, info5;
  private ToDo todo1, todo2, todo3, todo4, todo5;;
  private String path1, toDoLine, toDoLine1, toDoLine2, toDoLine3, toDoLine4, toDoLine5;

  @BeforeEach
  void setUp() throws RequiredFieldError {
    f1 = new Functionality();
    f2 = new Functionality();
    info = new LinkedHashSet<ToDo>();
    info2 = new LinkedHashSet<ToDo>();
    info4 = new LinkedHashSet<ToDo>();
    info5 = new LinkedHashSet<ToDo>();
    todo1 = new ToDo();
    todo2 = new ToDo();
    todo3 = new ToDo();
    todo4 = new ToDo();
    todo5 = new ToDo();
    path1 = "abc.txt";
    toDoLine = "1,CoreTraining,FALSE,?,2,home";
    toDoLine2 = "2,Core, Training3,?,?,?,?";
    toDoLine1 = "1,CoreTraining,?,?,?,?";
    toDoLine3 = "3,Core,True,2022/04/26,2,?";
    toDoLine4 = "4,?,?,?,1,?";
    toDoLine5 = "1,CoreTraining,FALSE,?,?,home";
    todo1.getToDoList(toDoLine1);
    todo2.getToDoList(toDoLine2);
    todo3.getToDoList(toDoLine3);
    todo5.getToDoList(toDoLine5);
    info2.add(todo1);
    info2.add(todo2);
    info5.add(todo5);

  }

  @Test
  void addNewToDo() {
    f1.addNewToDo(info, path1, toDoLine);
    f1.addNewToDo(info2, path1, toDoLine3);
    f2.addNewToDo(info4, path1, toDoLine3);
    f1.addNewToDo(info5, path1, toDoLine5);
  }

  @Test
  void completeAnExitingToDo() {
    f1.CompleteAnExitingToDo(info, path1, 1);
    f1.CompleteAnExitingToDo(info5, path1, 1);
    info4.add(todo2);
    info4.add(todo3);
    f2.CompleteAnExitingToDo(info4, path1, 2);
  }

  @Test
  void expectRequiredFieldError() {
    assertThrows(RequiredFieldError.class,
        () -> {
          todo4.getToDoList(this.toDoLine4);
        });
  }


  @Test
  void expectNullPointerException() {
    assertThrows(NullPointerException.class,
        () -> {
          info4.add(todo4);
          f2.addNewToDo(info4, path1, toDoLine4);
        });
  }


  @Test
  void display() {
    f1.display(info, true, null, false, false);
    f1.display(info5, true, null, false, false);
    f1.display(info, false, null, true, false);
    f1.display(info, false, null, false, true);
    f2.display(info2, false, null, false, true);
    f2.display(info4, false, null, false, false);
  }
}