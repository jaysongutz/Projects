import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Contains a menu based interface for the TodoList program.
 * @author Annie Wai
 *
 */
public class TodoMain {
    public static final String MAIN_MENU = "Welcome to my Todo List: \n"
                                           + "1. Add a task \n"
                                           + "2. Update a task \n"
                                           + "3. Remove a task \n"
                                           + "4. Search a task \n"
                                           + "5. Print my todo list \n"
                                           + "6. Save todo list to a file \n"
                                           + "7. Load todo listfrom a file \n"
                                           + "0. Quit \n"
                                           + "Enter your menu choice: ";
    public static final String INVALID_OPTION = "Invalid menu option.";
    public static final String QUIT = "Quitting from Todo List.";
    public static final String ENTER_TASK_DESCRIPTION =
            "Enter a task description: ";
    public static final String ENTER_DUEDATE =
            "Enter a due date with the format: YYYY-MM-DD@HH:MM :";
    public static final String IS_COMPLETE = "Is this task completed Y/N?";
    public static final String INVALID_TASK_DESCRIPTION =
            "Invalid task description.";
    public static final String PRINT_DUEDATE = "due date is: ";
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String EMPTY_STRING = "";
    
    public static final String ADD_SUCCESS =
            "New item successfully added to your todo list.";
    public static final String ADD_UNSUCCESS =
            "New item addition unsuccessful.";
    
    public static final String UPDATE_ITEM_INDEX =
            "Enter the item index to update: ";
    public static final String UPDATE_SUCCESS =
            "New item successfully updated to your todo list.";
    public static final String UPDATE_UNSUCCESS =
            "New item update unsuccessful.";
    
    public static final String REMOVE_TASK_DESCRIPTION =
            "Enter a task description to remove: ";
    public static final String REMOVE_SUCCESS =
            "Item successfully removed from your todo list.";
    public static final String REMOVE_UNSUCCESS = "Item removal unsuccessful.";
    
    public static final String SEARCH_MENU = 
            "(1) Search by description (2) Search by id \n"
            + "Enter menu option: ";
    public static final String SEARCH_TASK_DESCRIPTION =
            "Enter a task description to search for: ";
    public static final String SEARCH_TASK_ID = "Enter an Id to search for: ";
    
    public static final String PRINT_UNFINISHED_ITEMS =
            "Only print unfinished items Y/N? ";
    public static final String UNFINISHED_ITEMS = "Unfinished Items: ";
    public static final String INVALID_CHOICE = "Invalid choice.";
    
    public static final String SAVE_FILENAME =
            "Enter a file name to save your todo list: ";
    public static final String SAVE_SUCCESS =
            "Todo list successfully saved to a file.";
    public static final String SAVE_UNSUCCESS =
            "Todo list save to file unsuccessful.";

    public static final String LOAD_FILENAME =
            "Enter the file name to load your todo list: ";


    /**
     * The main method that contains a menu based interface.
     * @param args Command line arguments not used
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        TodoList todoList = new TodoList();
        int option = -1;
        Scanner in = new Scanner(System.in);
        while (option != 0) {
            // todo list menu
            System.out.print(MAIN_MENU);
            
            String optionStr = in.nextLine();
            option = Integer.parseInt(optionStr);

            // parsing the user's menu choice.
            switch (option) {
                case 1:
                    addTask(todoList, in);
                    break;
                case 2:
                    updateTask(todoList, in);
                    break;
                case 3:
                    removeTask(todoList, in);
                    break;
                case 4:
                    searchTask(todoList, in);
                    break;
                case 5:
                    printTodoList(todoList, in);
                    break;
                case 6:
                    saveTodoList(todoList, in);
                    break;
                case 7:
                    todoList = loadTodoList(todoList, in);
                    break;
                case 0:
                    System.out.println(QUIT);
                    break;
                default:
                    System.out.println(INVALID_OPTION);
                    break;
            }
        }
    }


    /**
     * Helper method that contains a sub-menu for adding an item
     * @param todoList the todo List to add items to
     * @param in The scanner to ask for user input
     */
    public static void addTask(TodoList todoList, Scanner in) {
        // Sub-menu for adding an item
        System.out.print(ENTER_TASK_DESCRIPTION);
        String description = in.nextLine();
        System.out.print(ENTER_DUEDATE);
        String dueDateStr = in.nextLine();
        System.out.print(IS_COMPLETE);
        String completed = in.nextLine();

        // parsing user input
        if (description.trim().equals(EMPTY_STRING)) {
            System.out.println(INVALID_TASK_DESCRIPTION);
            return;
        }

        TodoItem item = new TodoItem(description);

        if (!dueDateStr.equals(EMPTY_STRING)) {
            System.out.println(PRINT_DUEDATE + dueDateStr);
            DateTime dueDate = new DateTime(dueDateStr);
            item.setDueDate(dueDate);
        }

        if (completed.trim().toUpperCase().equals(YES)) {
            item.setComplete(true);
        }

        // Add item and check if it was successfully added
        boolean success = todoList.addItem(item);
        if (success) {
            System.out.println(ADD_SUCCESS);
        } else {
            System.out.println(ADD_UNSUCCESS);
        }
    }
    

    /**
     * Helper method that contains a sub-menu for updating an item
     * @param todoList the todo List to update items
     * @param in The scanner to ask for user input
     */
    public static void updateTask(TodoList todoList, Scanner in) {
        // Sub-menu for updating an item
        System.out.print(UPDATE_ITEM_INDEX);
        int index = Integer.parseInt(in.nextLine());
        System.out.print(ENTER_TASK_DESCRIPTION);
        String description = in.nextLine();
        System.out.print(ENTER_DUEDATE);
        String dueDateStr = in.nextLine();
        System.out.print(IS_COMPLETE);
        String completed = in.nextLine();

        // parsing user input
        if (description.trim().equals(EMPTY_STRING)) {
            System.out.println(INVALID_TASK_DESCRIPTION);
            return;
        }

        TodoItem item = new TodoItem(description);

        if (!dueDateStr.equals(EMPTY_STRING)) {
            System.out.println(PRINT_DUEDATE + dueDateStr);
            DateTime dueDate = new DateTime(dueDateStr);
            item.setDueDate(dueDate);
        }

        if (completed.trim().toUpperCase().equals(YES)) {
            item.setComplete(true);
        }

        // Update item and check if it was successfully updated
        TodoItem prevItem = todoList.updateItem(item, index);
        if (prevItem != null) {
            System.out.println(UPDATE_SUCCESS);
        } else {
            System.out.println(UPDATE_UNSUCCESS);
        }
    }
    

    /**
     * Helper method that contains a sub-menu for removing an item
     * @param todoList the todo List to remove an item
     * @param in The scanner to ask for user input
     */
    public static void removeTask(TodoList todoList, Scanner in) {
        // Sub-menu for removing an item
        System.out.print(REMOVE_TASK_DESCRIPTION);
        String description = in.nextLine();

        // Check for valid description
        if (description.trim().equals(EMPTY_STRING)) {
            System.out.println(INVALID_TASK_DESCRIPTION);
            return;
        }

        TodoItem item = new TodoItem(description);

        // Remove item and check if it successfully removed
        boolean success = todoList.removeItem(item);
        if (success) {
            System.out.println(REMOVE_SUCCESS);
        } else {
            System.out.println(REMOVE_UNSUCCESS);
        }
    }

    /**
     * Helper method that contains a sub-menu for searching the todo list
     * @param todoList The todoList to search from
     * @param in The scanner to ask for user input
     */
    public static void searchTask(TodoList todoList, Scanner in) {
        // Sub-menu for removing an item
        System.out.print(SEARCH_MENU);
        String optionStr = in.nextLine();
        int option = Integer.parseInt(optionStr);

        // Search by description
        if (option == 1) {
            System.out.print(SEARCH_TASK_DESCRIPTION);
            String description = in.nextLine();

            // Check for valid description
            if (description.trim().equals(EMPTY_STRING)) {
                System.out.println(INVALID_TASK_DESCRIPTION);
                return;
            }

            TodoItem[] items = todoList.findItems(description);
            if (items != null) {
                for (TodoItem item : items) {
                    System.out.println(item.toString());
                }
            }

        // search by id
        } else if (option == 2) {
            System.out.print(SEARCH_TASK_ID);
            String idStr = in.nextLine();
            int id = Integer.parseInt(idStr);
            TodoItem item = todoList.findItem(id);
            if (item != null) {
                System.out.println(item.toString());
            }

        // otherwise, invalid menu option
        } else {
            System.out.println(INVALID_OPTION);
        }
    }

    /**
     * Helper method that contains a sub-menu for printing the todo list
     * @param todoList The todoList to print out
     * @param in The scanner to ask for user input
     */
    public static void printTodoList(TodoList todoList, Scanner in) {
        System.out.print(PRINT_UNFINISHED_ITEMS);
        String unfinished = in.nextLine();
        // print unfinished items
        if (unfinished.trim().toUpperCase().equals(YES)) {
            TodoItem[] unfinishedItems = todoList.getUnfinishedItems();
            System.out.println(UNFINISHED_ITEMS);
            if (unfinishedItems != null) {
                for (TodoItem item : unfinishedItems) {
                    System.out.println(item.toString());
                }
            }
        // otherwise print the whole todo list
        } else if (unfinished.trim().toUpperCase().equals(NO)) {
            System.out.println(todoList.toString());
        } else {
            System.out.println(INVALID_CHOICE);
        }
    }

    /**
     * Helper method that contains a sub-menu for saving the todo list to a
     * file
     * @param todoList The todo list to save to a file
     * @param in The scanner  to ask for user input
     * @throws FileNotFoundException
     */
    public static void saveTodoList(TodoList todoList, Scanner in)
            throws FileNotFoundException {
        System.out.print(SAVE_FILENAME);
        String fileName = in.nextLine();
        boolean success = todoList.saveTodoListToFile(fileName);
        if (success) {
            System.out.println(SAVE_SUCCESS);
        } else {
            System.out.println(SAVE_UNSUCCESS);
        }
    }

    /**
     * Helper method that contains a sub-menu for loading a todo list from a
     * file
     * @param todoList The todo list to save to a file
     * @param in The scanner  to ask for user input
     * @throws FileNotFoundException
     */
    public static TodoList loadTodoList(TodoList todoList, Scanner in)
            throws FileNotFoundException {
        System.out.print(LOAD_FILENAME);
        String fileName = in.nextLine();
        return new TodoList(fileName);
    }
}