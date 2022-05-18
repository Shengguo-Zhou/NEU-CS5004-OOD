package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {

  private CommandLineParser c0, c1, c2, c3, c4;
  String missArgs0[] = {"--csv-file"};
  String missArgs1[] = {"--csv-file", "todos.csv", "--add-todo", "--completed", "--due",
      "2022/04/26", "--priority", "2", "--category", "home", "--complete-todo",
      "2", "--display", "--show-incomplete", "--show-category", "home", "--sort-by-priority"};
  String missArgs2[] = {"--add-todo", "--completed", "--due", "2022/04/26", "--priority", "2",
      "--category", "home", "--complete-todo", "2", "--display", "--show-incomplete",
      "--show-category", "home", "--sort-by-priority"};

  String missArgs3[] = {"--csv-file", "todos.csv", "--todo-text", "Core Training2",
      "--completed", "--due", "2022/04/26", "--priority", "2", "--category", "home",
      "--complete-todo", "2", "--display", "--show-incomplete", "--show-category", "home",
      "--sort-by-date"};

  String missArgs3_2[] = {"--csv-file", "todos.csv", "--category", "home", "--display",
      "--show-incomplete", "--show-category", "home", "--sort-by-date"};

  String missArgs4[] = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "Core Training2",
      "--completed", "--due", "2022/04/26", "--priority", "2", "--category", "home",
      "--complete-todo", "2", "--sort-by-date", "--display", "--show-incomplete", "--show-category",
      "home", "--sort-by-priority"};

  String errorArgs[] = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "Core Training2",
      "--completed", "--due", "2022/04/26", "--priority", "2", "--category", "home",
      "--complete-todo", "2", "--display", "--show-incomplete", "--show-category", "home",
      "--sort-by-due"}; // "--sort-by-due"

  String completeArgs0[] = {"--csv-file", "todos.csv", "--add-todo", "--todo-text",
      "Core Training2",
      "--completed", "--due", "2022/04/26", "--priority", "2", "--category", "home",
      "--complete-todo",
      "2", "--display", "--show-incomplete", "--show-category", "home", "--sort-by-date"};


  String completeArgs[] = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "Core Training2",
      "--completed", "--due", "2022/04/26", "--priority", "2", "--category", "home",
      "--complete-todo",
      "2", "--display", "--show-incomplete", "--show-category", "home", "--sort-by-priority"};

  String completeArgs3[] = {"--csv-file", "todos.csv", "--add-todo", "--todo-text",
      "Core Training2"};

  String completeArgs4[] = {"--csv-file", "--display", "--show-incomplete"};

  String errorCSVArgs[] = {"--csv-file", "777", "--add-todo", "--todo-text", "Core Training2"};

  ArrayList<Integer> a1 = new ArrayList<Integer>();

  @BeforeEach
  void setUp() throws MissCommandLineArgException, InvalidCommandException, InvalidRouteException {
    this.c1 = new CommandLineParser(completeArgs);
    a1.add(2);
    this.c2 = new CommandLineParser(completeArgs0);
    this.c3 = new CommandLineParser(completeArgs3);
    this.c4 = new CommandLineParser(completeArgs4);
  }

  @Test
  void expectInvalidCommandException() {
    assertThrows(InvalidCommandException.class,
        () -> {
          this.c0 = new CommandLineParser(errorArgs);
        });
  }

  @Test
  void expectMissCommandLineArgException() {
    assertThrows(MissCommandLineArgException.class,
        () -> {
          this.c0 = new CommandLineParser(missArgs0);
        });
  }

//  @Test
//  void expectInvalidPathException() {
//    assertThrows(InvalidPathException.class,
//        () -> {
//          this.c0 = new CommandLineParser(errorCSVArgs);
//        });
//  }


  @Test
  void expectMissCommandLineArgException0() {
    assertThrows(MissCommandLineArgException.class,
        () -> {
          this.c0 = new CommandLineParser(missArgs1);
        });
  }

  @Test
  void expectMissCommandLineArgException1() {
    assertThrows(NullPointerException.class,
        () -> {
          this.c0.outOfBound(11, 10);
        });
  }

  @Test
  void expectMissCommandLineArgException2() {
    assertThrows(MissCommandLineArgException.class,
        () -> {
          this.c0 = new CommandLineParser(missArgs2);
        });
  }

  @Test
  void expectMissCommandLineArgException3() {
    assertThrows(MissCommandLineArgException.class,
        () -> {
          this.c0 = new CommandLineParser(missArgs3);
        });
  }

  @Test
  void expectMissCommandLineArgException3_2() {
    assertThrows(MissCommandLineArgException.class,
        () -> {
          this.c0 = new CommandLineParser(missArgs3_2);
        });
  }

  @Test
  void expectMissCommandLineArgException4() {
    assertThrows(MissCommandLineArgException.class,
        () -> {
          this.c0 = new CommandLineParser(missArgs4);
        });
  }

  @Test
  void hasAddToDoCommand() {
    assertTrue(this.c1.HasAddToDoCommand());
  }

  @Test
  void completeToDoCommandIncluded() {
    assertTrue(this.c1.completeToDoCommandIncluded());
  }

  @Test
  void getCompletedToDoList() {
    assertEquals(a1, this.c1.getCompletedToDoList());
  }

  @Test
  void getToDoLine() {
    assertEquals("Core Training2,TRUE,2022/04/26,2,home", this.c1.getToDoLine());
    assertEquals("Core Training2,FALSE,?,3,?", this.c3.getToDoLine());
    assertEquals("No ToDo command Included.", this.c4.getToDoLine());
  }

  @Test
  void getCSVPath() {
    assertEquals("todos.csv", this.c1.getCSVPath());
  }

  @Test
  void processDoDisplay() {
    this.c1.doDisplay();
  }

  @Test
  void getShowIncomplete() {
    assertTrue(this.c1.getShowIncomplete());
  }

  @Test
  void getShowCategoryName() {
    assertEquals("home", this.c1.getShowCategoryName());
  }
}