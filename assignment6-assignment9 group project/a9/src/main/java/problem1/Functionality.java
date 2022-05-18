package problem1;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

/**
 * Functionality class, including functions addNewToDo (append new todolist), CompleteAnExitingToDo
 * (change the status of todolist to finished), display (display the todoslists to the user by given
 * restricted info)
 */
public class Functionality {

  /**
   * Constructor
   */
  public Functionality() {
  }

  /**
   * rewrite the whole old TODOs list and append the new line TODOs Example : String todoline =
   * "leetcode practice,FALSE,2022/10/10,1,work"
   *
   * @param set      - the stored old TODOs info, LinkedHashSet
   * @param path     - the output path, string
   * @param todoline - the new todoline wanted to be added, string
   * @return new TODOs info in LinkedHashSet form
   */
  public LinkedHashSet<ToDo> addNewToDo(LinkedHashSet<ToDo> set, String path, String todoline) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(path, false))) {
      // write the whole list again is a such good approach!

      int curIndex = 0;
      out.write("id, text, completed, due, priority, category");

      for (ToDo td : set) {
        StringBuilder sb = new StringBuilder();
        curIndex = td.getId();

        sb.append(td.getId() + ",");

        String text = td.getText();
        if (text.contains(",")) {
          sb.append("\"" + text + "\"" + ",");
        } else {
          sb.append(text + ",");
        }

        sb.append(td.getCompleted() + ",");

        if (td.getDue() == null) {
          sb.append("?,");
        } else {
          sb.append(td.getDue() + ",");
        }

        if (td.getPriority() == null) {
          sb.append("?,");
        } else {
          sb.append(td.getPriority() + ",");
        }
        if (td.getCategory() == null) {
          sb.append("?,");
        } else {
          sb.append(td.getCategory());
        }
        out.newLine();
        out.write(sb.toString());
      }

      String[] newTodoLine = todoline.split(",");
      int len = newTodoLine.length;

      //get new Text String
      int start = 0;
      int end = len - 5;
      StringBuilder stringbuilder = new StringBuilder();
      for (int i = start; i <= end; i++) {
        String temp = newTodoLine[i];
        stringbuilder.append(temp);
        if (i != end) {
          stringbuilder.append(",");
        }
      }
      String newTextString = stringbuilder.toString();
      if (newTextString.equals("?")) {
        throw new RequiredFieldError("This is a required field");
      }

      // get category
      String newcatagoryString = newTodoLine[len - 1];
      if (newcatagoryString.equals("?")) {
        newcatagoryString = null;
      }

      // get priority
      String priorityString = newTodoLine[len - 2];
      int newPriority;
      if (priorityString.equals("?")) {
        newPriority = 3;
      } else {
        int value = Integer.parseInt(priorityString);
        System.out.println("adding function priority is : " + value);
        if (value == 1 || value == 2 || value == 3) {
          newPriority = value;
        } else {
          throw new IllegalArgumentException("This value is invalid");
        }
      }

      // get due
      String dueString = newTodoLine[len - 3];
      if (dueString.equals("?")) {
        dueString = null;
      }

      // get complete or not
      String completedString = newTodoLine[len - 4];
      boolean newComplete;
      System.out.println("completed condition is " + completedString);
      if (completedString.equals("?")) {
        newComplete = false;
      } else {
        newComplete = !completedString.equalsIgnoreCase("false");
      }

      // rewrite the new TODOs list
      StringBuilder sb = new StringBuilder();
      curIndex++;
      sb.append(curIndex + ",");
      sb.append(newTextString + ",");
      sb.append(newComplete + ",");
      sb.append(dueString + ",");
      sb.append(newPriority + ",");
      sb.append(newcatagoryString);

      out.newLine();
      out.write(sb.toString());

      ToDo newToDo = new ToDo();
      newToDo.id = curIndex;
      newToDo.text = newTextString;
      newToDo.completed = newComplete;
      newToDo.due = dueString;
      newToDo.category = newcatagoryString;
      newToDo.priority = newPriority;
      set.add(newToDo);

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException | RequiredFieldError e) {
      e.printStackTrace();
    }

    return set;
  }

  /**
   * rewrite the whole old TODOs and change the TODO list which user has finished into true
   *
   * @param set                   - the whole stored todos info, LinkedHashSet
   * @param path                  - the output path, string
   * @param todoIDYouHaveFinished - the todolist ID have finished
   * @return new whole stored todos info, LinkedHashSet
   */
  public LinkedHashSet<ToDo> CompleteAnExitingToDo(LinkedHashSet<ToDo> set, String path,
      Integer todoIDYouHaveFinished) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(path, false))) {
      // rewrite the first line
      out.write("id, text, completed, due, priority, category");
      // rewrite the set
      for (ToDo td : set) {
        StringBuilder sb = new StringBuilder();
        sb.append(td.getId() + ",");
        String text = td.getText();
        if (text.contains(",")) {
          sb.append("\"" + text + "\"" + ",");
        } else {
          sb.append(text + ",");
        }
        if (td.getId().equals(todoIDYouHaveFinished)) {
          td.completed = true;
          System.out.println("this id false is changed : " + td.getId());
        }
        sb.append(td.getCompleted() + ",");
        if (td.getDue() == null) {
          sb.append("?,");
        } else {
          sb.append(td.getDue() + ",");
        }

        if (td.getPriority() == null) {
          sb.append("?,");
        } else {
          sb.append(td.getPriority() + ",");
        }

        if (td.getCategory() == null) {
          sb.append("?,");
        } else {
          sb.append(td.getCategory());
        }
        out.newLine();
        out.write(sb.toString());
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return set;
  }

  /**
   * display it by write a new csv file which is called "display.csv"
   *
   * @param set            - the stored whole TODOs info, LinkedHashSet
   * @param showInComplete - whether show the complete or incomplete list, boolean
   * @param showCategory   - show specific category, string
   * @param sortByDate     - show it by sorted date, ascending order, boolean
   * @param sortByPriority - show it by sorted priority, ascending order, boolean
   */
  public void display(LinkedHashSet<ToDo> set, Boolean showInComplete, String showCategory,
      Boolean sortByDate, Boolean sortByPriority) {
    // if (sortByDate && sortByPriority) throw new IllegalArgumentException();
    // the display is the CSV result.
    String path = "display.csv";
    ArrayList<ToDo> array = new ArrayList<>(set);

    // sort by priority
    if (sortByPriority != null && sortByPriority) {
      Collections.sort(array, (a, b) -> a.getPriority() - b.getPriority());
    }

    // sort by due date
    if (sortByDate != null && sortByDate) {
      Collections.sort(array, (a, b) -> {
        if (a.getDue() == null) {
          a.due = "9999/12/31";
        }
        if (b.getDue() == null) {
          b.due = "9999/12/31";
        }
        return a.getDue().compareTo(b.getDue());
      });
    }
    try (BufferedWriter out = new BufferedWriter(new FileWriter(path, false))) {
      out.write("id, text, completed, due, priority, category");

      for (ToDo td : array) {
        if (showInComplete != null) {
          // show incomplete or show complete
          if (!showInComplete) {
            if (!td.getCompleted()) {
              continue;
            }
          }
          if (showInComplete) {
            if (td.getCompleted()) {
              continue;
            }
          }
        }

        if (showCategory != null) {
          if (td.getCategory() == null) {
            continue;
          }
          if (!td.getCategory().equals(showCategory)) {
            continue;
          }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(td.getId() + ",");
        String text = td.getText();
        if (text.contains(",")) {
          sb.append("\"" + text + "\"" + ",");
        } else {
          sb.append(text + ",");
        }
        sb.append(td.getCompleted() + ",");
        if (td.getDue() == null) {
          sb.append("?,");
        } else {
          sb.append(td.getDue() + ",");
        }
        if (td.getPriority() == null) {
          sb.append("?,");
        } else {
          sb.append(td.getPriority() + ",");
        }
        if (td.getCategory() == null) {
          sb.append("?");
        } else {
          sb.append(td.getCategory());
        }
        out.newLine();
        out.write(sb.toString());
      }

    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
