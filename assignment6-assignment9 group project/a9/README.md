# Summary of Assignment 9: Processing Todos.csv

#### Name : Jin Zhang, Yiming Ge, Shengguo Zhou

### 1) About the program:

This is a command-line TODO application. The system will allow a user to add and
track the status of their TODOs by due date, category, priority, and status
(complete/incomplete).

### 2) How to run the program:

To easily run Main.main(), here we provide two different args[] samples:

#### Sample command 1:
--csv-file "todos.csv" --add-todo --todo-text "Core Training2" --completed --due "2022/04/27" --priority 2 --category "home" --complete-todo 2 --display --show-incomplete --show-category "home" --sort-by-date

#### Sample command 2:
--csv-file --display --show-incomplete --show-category "home" --sort-by-priority

* REMAINDER of the --due "YYYY/MM/DD" command: 

The input due date format must be YYYY/MM/DD, otherwise, you may not approach the proper sort by date result.

* About some classes:

CommmandLineParser : paser the command line.

CSVFileProcessor : process the original csv file.

Functionality: add a new todo and so on.

### 3) Design Patterns of this program:

Structural design patterns. Our team mainly focused on object composition, relations between objects (e.g. inheritance), and relations between objects and the system as a whole.
Structural design patterns are those that simplify the design of large object structures by identifying relationships between them. We design common ways of composing classes and objects so that they become repeatable as solutions.

### 4) MODEL-VIEW-CONTROLLER (MVC) ARCHITECTURE:

Main and CommandLineParser Class are view and ToDo Class is the controller. Then all the classes in our cvs file are model.
It is this logic, the user uses main and command parser, converts string into todo class, and then todo class changes cvs data through our rewritten cvs class.
Then after we rewrite the cvs data read, it becomes a todo class and then presents it to the user.

### 5) About Testing: JUnit test coverage 95%