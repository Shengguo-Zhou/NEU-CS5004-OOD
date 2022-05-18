package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
  private Main m1, m2;
  private String missArgs0[] = {"--csv-file"};

  private String completeArgs[] = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "Core Training2",
      "--completed", "--due", "2022/04/26","--priority", "2", "--category", "home", "--complete-todo",
      "2", "--display", "--show-incomplete", "--show-category", "home", "--sort-by-priority"};

  private String completeArgs2[] = {"--csv-file", "todos.csv", "--add-todo", "--todo-text", "Core Training2",
      "--completed", "--due", "2022/04/27","--priority", "2", "--category", "home", "--complete-todo",
      "2", "--display", "--show-incomplete", "--show-category", "home", "--sort-by-date"};

  @BeforeEach
  void setUp() {
  Main m1 = new Main();
  Main m2 = new Main();
  }

  @Test
  void main()
      throws MissCommandLineArgException, InvalidCommandException, RequiredFieldError, InvalidRouteException {
    m1.main(completeArgs);
    m2.main(completeArgs2);
  }

  @Test
  void expectMissCommandLineArgException() {
    assertThrows(MissCommandLineArgException.class,
        () -> {
          m2.main(missArgs0);
        });
  }
}