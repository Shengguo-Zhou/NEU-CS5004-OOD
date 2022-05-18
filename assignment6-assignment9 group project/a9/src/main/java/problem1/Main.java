package problem1;

import java.util.LinkedHashSet;

/**
 * Main class to start the program.
 */
public class Main {

  /** To run Main.main(), here we provide two different args[] samples */
  // --csv-file "todos.csv" --add-todo --todo-text "Core Training2" --completed --due "2022/04/27" --priority 2 --category "home" --complete-todo 2 --display --show-incomplete --show-category "home" --sort-by-date
  // --csv-file --display --show-incomplete --show-category "home" --sort-by-priority

  /**
   * Main Function
   *
   * @param args - the user input command line
   * @throws RequiredFieldError          when required field error happens
   * @throws MissCommandLineArgException when miss command line arg happens
   * @throws InvalidCommandException     when invalid command line happens
   * @throws InvalidRouteException       when invalid route happens
   */
  public static void main(String[] args)
      throws RequiredFieldError, MissCommandLineArgException, InvalidCommandException, InvalidRouteException {

    // parser the command line
    CommandLineParser parser = new CommandLineParser(args);
    // String defaultPath = "todos.csv";
    String defaultPath = parser.getCSVPath();
    // The set is to store the all TODO infos from CSV.
    LinkedHashSet<ToDo> set = new LinkedHashSet<>();
    CSVFileProcessor csvProcessor = new CSVFileProcessor();
    set = csvProcessor.processCSV(defaultPath);

    // show the whole todolist
    for (ToDo todo : set) {
      System.out.println("id is: " + todo.getId());
      System.out.println("text is: " + todo.getText());
      System.out.println("completed is: " + todo.getCompleted());
      System.out.println("due is: " + todo.getDue());
      System.out.println("priority is: " + todo.getPriority());
      System.out.println("category is: " + todo.getCategory());
      System.out.println("");
    }

    Functionality function = new Functionality();
    if (parser.HasAddToDoCommand()) {
      // add a new todolist
      ToDo tdTest = new ToDo();

      String toDoLine = parser.getToDoLine();
      // String toDoLine2 = "Core Training,TRUE,2022/01/01,1,workout";// no spaces
      set = function.addNewToDo(set, defaultPath, toDoLine);
    }

    // complete the todolist id
    if (parser.completeToDoCommandIncluded()) {
      for (Integer id : parser.getCompletedToDoList()) {
        set = function.CompleteAnExitingToDo(set, defaultPath, id);
      }
    }

    if (parser.doDisplay())
    // function.display(set, null, "home", null, true);
    {
      function.display(set, parser.showIncomplete, parser.getShowCategoryName(), parser.sortByDate,
          parser.sortByPriority);
    }
  }
}
