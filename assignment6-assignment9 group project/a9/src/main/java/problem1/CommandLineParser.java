package problem1;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * It's a class that parses the command line arguments and stores them in variables
 */
public class CommandLineParser {

  // The CSV file containing the todos. This option is required.
  private static final String CSV_FILE_COMMAND = "--csv-file";
  // Add a new todo. If this option is provided, then --todo-text must also be provided.
  private static final String ADD_TODO_COMMAND = "--add-todo";
  // --todo-text <description of todo> A description of the todo.
  private static final String TODO_TEXT_COMMAND = "--todo-text";
  // (Optional) Sets the completed status of a new todo to true.
  private static final String COMPLETED_COMMAND = "--completed";
  // (Optional) Sets the due date of a new todo. You may choose how the date should be formatted.
  private static final String DUE_COMMAND = "--due";
  // (Optional) Sets the priority of a new todo. The value only can be 1, 2, or 3.
  private static final String PRIORITY_COMMAND = "--priority";
  // --category <a category name> (Optional) Sets the category of a new todo.
  //  The value can be any String. Categories do not need to be pre-defined.
  private static final String CATEGORY_COMMAND = "--category";
  // --complete-todo <id> Mark the Todo with the provided ID as completed.
  private static final String COMPLETE_TODO_COMMAND = "--complete-todo";
  // Display todos. If none of the following optional arguments are provided, displays all todos.
  private static final String DISPLAY_COMMAND = "--display";
  // --show-incomplete (Optional) If --display is provided, only incomplete todos should be displayed.
  private static final String SHOW_INCOMPLETE_COMMAND = "--show-incomplete";
  // --show-category <category> (Optional) If --display is provided, only todos with the given category should be displayed.
  private static final String SHOW_CATEGORY_COMMAND = "--show-category";
  // --sort-by-date (Optional) If --display is provided, sort the list of todos by date order (ascending). Cannot be combined with --sort-bypriority.
  private static final String SORT_BY_DATE_COMMAND = "--sort-by-date";
  // --sort-by-priority (Optional) If --display is provided, sort the list of todos by priority (ascending). Cannot be combined with --sort-by-date.
  private static final String SORT_BY_PRIORITY_COMMAND = "--sort-by-priority";

  private boolean csv_file_commandRequired = false;
  private boolean add_todo_commandIncluded = false;
  private boolean todo_text_commandRequired = false;
  private String CSVPath;
  private String toDoText = null;
  private Integer priority = 3;
  private Boolean priorityIsIncluded = false;
  private Boolean categoryIsIncluded = false;
  private String category = null;
  private Boolean isCompleted = false;
  private Boolean dueIsIncluded = false;
  private String dueDate = null;
  private Boolean completeToDoIncluded = false;
  private ArrayList<Integer> completedList = new ArrayList<>();

  /**
   * A protected variable that is used to indicate whether the display command is included in the
   * command line arguments.
   */
  protected Boolean displayIncluded = false;
  /**
   * A protected variable that is used to indicate whether the showCategory command is included in
   * the command line arguments.
   */
  protected Boolean showCategory = false;
  private String showCategoryName;
  /**
   * A protected variable that is used to indicate whether the showIncomplete command is included in
   * the command line arguments.
   */
  protected Boolean showIncomplete = false;
  /**
   * A protected variable that is used to indicate whether the sortByDate command is included in the
   * command line arguments.
   */
  protected Boolean sortByDate = false;
  /**
   * A protected variable that is used to indicate whether the sortByPriority command is included in
   * the command line arguments.
   */
  protected Boolean sortByPriority = false;

  /**
   * It's a constructor that parses the command line arguments and stores them in variables
   *
   * @param args -- String args.
   * @throws MissCommandLineArgException when Miss Command Line Arg Exception
   * @throws InvalidRouteException       when Invalid Route Exception
   * @throws InvalidCommandException     when Invalid command happens
   */
  public CommandLineParser(String[] args)
      throws MissCommandLineArgException, InvalidRouteException, InvalidCommandException {
    this.analyzeEachArg(args);
    this.checkMissArg();
    this.isValidPath();
  }

  /**
   * This function iterates through the command line arguments and sets the corresponding fields in
   * the class
   *
   * @param args -- command line string array.
   */
  private void analyzeEachArg(String[] args)
      throws MissCommandLineArgException, InvalidRouteException, InvalidCommandException { // ppt page 23
    int i = 0;
    int len = args.length;
    while (i < len) {
      if (args[i].equals(CSV_FILE_COMMAND)) {
        this.csv_file_commandRequired = true;
        outOfBound(++i, len);
        this.CSVPath = args[i];
        this.isValidPath();

        /**
         * Add new ToDo commands:
         */
      } else if (args[i].equals(ADD_TODO_COMMAND)) {
        this.add_todo_commandIncluded = true;
      } else if (args[i].equals(TODO_TEXT_COMMAND)) {
        this.todo_text_commandRequired = true;
        outOfBound(++i, len);
        this.toDoText = args[i];
      } else if (args[i].equals(COMPLETED_COMMAND)) {
        this.isCompleted = true;

      } else if (args[i].equals(DUE_COMMAND)) {
        this.dueIsIncluded = true;
        outOfBound(++i, len);
        this.dueDate = args[i];

      } else if (args[i].equals(PRIORITY_COMMAND)) {
        this.priorityIsIncluded = true;
        outOfBound(++i, len);
        this.priority = Integer.valueOf(args[i]);

      } else if (args[i].equals(CATEGORY_COMMAND)) {
        this.categoryIsIncluded = true;
        outOfBound(++i, len);
        this.category = args[i];

      } else if (args[i].equals(COMPLETE_TODO_COMMAND)) {
        outOfBound(++i, len);
        this.completeToDoIncluded = true;
        Integer id = Integer.valueOf(args[i]);
        this.completedList.add(id);

        /**
         * Display commands:
         */
      } else if (args[i].equals(DISPLAY_COMMAND)) {
        this.displayIncluded = true;
      } else if (args[i].equals(SHOW_INCOMPLETE_COMMAND)) {
        this.showIncomplete = true;
      } else if (args[i].equals(SHOW_CATEGORY_COMMAND)) {
        outOfBound(++i, len);
        this.showCategory = true;
        this.showCategoryName = args[i];
      } else if (args[i].equals(SORT_BY_DATE_COMMAND)) {
        this.sortByDate = true;
      } else if (args[i].equals(SORT_BY_PRIORITY_COMMAND)) {
        this.sortByPriority = true;
      } else {
        throw new InvalidCommandException();
        // System.out.println("Caution: We got invalid command(s)! >>>>>>>" + args[i]);
      }
      i++;
    }
  }

  /**
   * This function is used to check if the current index is out of bound
   *
   * @param currentIndex the current index of the command line arguments
   * @param maxLength    the length of the command line arguments
   */
  void outOfBound(Integer currentIndex, Integer maxLength)
      throws MissCommandLineArgException {
    if (currentIndex >= maxLength) {
      throw new MissCommandLineArgException("Error: Miss Command Line Arg!");
    }
  }

  /**
   * It checks if the path is valid
   *
   * @throws InvalidRouteException -- Invalid Route Exception
   */
  public void isValidPath() throws InvalidRouteException {
    try {
      Paths.get(this.CSVPath);
    } catch (InvalidPathException | NullPointerException ex) {
      throw new InvalidRouteException("Error: Invalid path!");
    }
  }


  /**
   * If the user did not include the required command line arguments, throw an exception
   */
  private void checkMissArg() throws MissCommandLineArgException {
    if (!csv_file_commandRequired) {
      throw new MissCommandLineArgException("a CSV file is required.");
    }
    if (add_todo_commandIncluded && !todo_text_commandRequired) {
      throw new MissCommandLineArgException("ToDo text is required.");
    }
    if ((!add_todo_commandIncluded) && (todo_text_commandRequired || dueIsIncluded
        || priorityIsIncluded || categoryIsIncluded)) {
      throw new MissCommandLineArgException("--add-todo command is required.");
    }
    if (sortByPriority && sortByDate) {
      throw new MissCommandLineArgException("Sort by priority and date has conflicts.");
    }
  }

  /**
   * This function returns a boolean value that indicates whether the command has a CSV command or
   * not
   *
   * @return The boolean value of the variable haveCSVCommand.
   */
  public boolean HasAddToDoCommand() {
    return this.add_todo_commandIncluded;
  }

  /**
   * If the completeToDoIncluded variable is true, then return true. Otherwise, return false
   *
   * @return The completeToDoIncluded variable is being returned, boolean
   */
  public Boolean completeToDoCommandIncluded() {
    return this.completeToDoIncluded;
  }

  /**
   * This function returns the completed to-do list with id
   *
   * @return the completed to-do list with id, An ArrayList of integers.
   */
  public ArrayList<Integer> getCompletedToDoList() {
    return this.completedList;
  }

  /**
   * Get the todoline string based on the user input
   *
   * @return A string that contains the todolist text, whether it is completed, the due date, the
   * priority, and the category.
   */
  public String getToDoLine() {
    if (add_todo_commandIncluded) {
      StringBuilder res = new StringBuilder();
      res.append(this.toDoText);
      res.append(",");
      if (this.isCompleted) {
        res.append("TRUE,");
      } else {
        res.append("FALSE,");
      }
      if (this.dueIsIncluded) {
        res.append(this.dueDate);
        res.append(",");
      } else {
        res.append("?,");
      }
      if (this.priorityIsIncluded) {
        res.append(this.priority);
        res.append(",");
      } else {
        res.append("3,");
      }
      if (this.categoryIsIncluded) {
        res.append(this.category);
      } else {
        res.append("?");
      }
      return res.toString();
    } else {
      return "No ToDo command Included.";
    }
  }

  /**
   * This function returns the path of the CSV file
   *
   * @return The path of the CSV file.
   */
  public String getCSVPath() {
    return this.CSVPath;
  }

  /**
   * If the displayIncluded variable is true, then return true, otherwise return false.
   *
   * @return The value of the displayIncluded variable, boolean
   */
  public Boolean doDisplay() {
    return this.displayIncluded;
  }

  /**
   * This function returns the value of the showIncomplete variable
   *
   * @return The value of the showIncomplete variable, boolean
   */
  public Boolean getShowIncomplete() {
    return this.showIncomplete;
  }

  /**
   * This function returns the showCategoryName of the showCategory object
   *
   * @return The showCategoryName is being returned, string
   */
  public String getShowCategoryName() {
    return this.showCategoryName;
  }
}
