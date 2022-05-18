package problem1;

import java.util.Date;
import java.util.Objects;

/**
 * It's a class that represents a todolist with id, text, completed, due, priority and category
 * field
 */
public class ToDo {

  /**
   * It's a field that represents the id of a todolist.
   */
  protected Integer id;
  /**
   * It's a field that represents the text of a todolist.
   */
  protected String text;
  /**
   * It's a field that represents the completed status of a todolist.
   */
  protected Boolean completed;
  /**
   * It's a field that represents the due of a todolist.
   */
  protected String due;
  /**
   * It's a field that represents the priority of a todolist.
   */
  protected Integer priority;
  /**
   * It's a field that represents the category of a todolist.
   */
  protected String category;

  private static final Integer PRIORITY_3 = 3;
  private static final Integer PRIORITY_2 = 2;
  private static final Integer PRIORITY_1 = 1;

  /**
   * It's a constructor that initializes the fields of a todolist.
   */
  public ToDo() {
  }

  /**
   * Get the todolist from a line of string
   *
   * @param line - the line of string, string
   * @throws RequiredFieldError       when required field error happens
   * @throws IllegalArgumentException when illegal arguments happens
   */
  public void getToDoList(String line) throws RequiredFieldError, IllegalArgumentException {
    String[] eachLine = line.split(",");
    int len = eachLine.length;

    //get ToDolist id
    String idString = eachLine[0];
    if (idString.equals("?")) {
      throw new RequiredFieldError("This is a required field");
    }
    this.id = Integer.valueOf(idString);

    //get ToDolist text (type: String)
    int start = 1;
    int end = len - 5;
    StringBuilder sb = new StringBuilder();
    for (int i = start; i <= end; i++) {
      String temp = eachLine[i];
      sb.append(temp);
      if (i != end) {
        sb.append(",");
      }
    }
    String textString = sb.toString();
    if (start != end) {
      textString = textString.substring(1, textString.length() - 1);
    }
    if (textString.equals("?")) {
      throw new RequiredFieldError("This is a required field");
    } else {
      this.text = textString;
    }

    // get ToDolist category
    String categoryString = eachLine[len - 1];
    if (categoryString.equals("?")) {
      this.category = null;
    } else {
      this.category = categoryString;
    }

    // get ToDolist priority
    String priorityString = eachLine[len - 2];
    if (priorityString.equals("?")) {
      this.priority = PRIORITY_3;
    } else {
      Integer value = Integer.valueOf(priorityString);
      // System.out.println(value);
      if (value.equals(PRIORITY_1) || value.equals(PRIORITY_2) || value.equals(PRIORITY_3)) {
        this.priority = value;
      } else {
        throw new IllegalArgumentException("This value is invalid");
      }
    }

    // get ToDolist due
    String dueString = eachLine[len - 3];
    if (dueString.equals("?")) {
      dueString = null;
    } else {
      this.due = dueString;
    }

    // get ToDolist completed status
    String completedString = eachLine[len - 4];
    System.out.println("completed condition is " + completedString);
    if (completedString.equals("?")) {
      this.completed = false;
    }
    // else if(completedString.equals("FALSE") || completedString.equals("false")) {
    else if (completedString.toLowerCase().equals("false")) {
      this.completed = false;
    } else if (completedString.toLowerCase().equals("true")) {
      this.completed = true;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Get the todolist text
   *
   * @return todolist text, string
   */
  public String getText() {
    return this.text;
  }

  /**
   * Get todolist completed status
   *
   * @return todolist completed status, boolean
   */
  public Boolean getCompleted() {
    return this.completed;
  }

  /**
   * Once a Todolist is created, all fields should be immutable, with the exception of completed.
   *
   * @param completed - set completed status, boolean
   */
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  /**
   * Get the todolist due
   *
   * @return the todolist due, string
   */
  public String getDue() {
    return this.due;
  }

  /**
   * Get the todolist priority
   *
   * @return the todolist priority, integer
   */
  public Integer getPriority() {
    return this.priority;
  }

  /**
   * Get the todolist category
   *
   * @return the todolist category, string
   */
  public String getCategory() {
    return this.category;
  }

  /**
   * Get the todolist id
   *
   * @return the todolist id, integer
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToDo toDo = (ToDo) o;
    return Objects.equals(id, toDo.id) && Objects.equals(text, toDo.text)
        && Objects.equals(completed, toDo.completed) && Objects.equals(due,
        toDo.due) && Objects.equals(priority, toDo.priority) && Objects.equals(
        category, toDo.category);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, text, completed, due, priority, category);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "ToDo{" +
        "id=" + id +
        ", text='" + text + '\'' +
        ", completed=" + completed +
        ", due='" + due + '\'' +
        ", priority=" + priority +
        ", category='" + category +
        '}';
  }
}
