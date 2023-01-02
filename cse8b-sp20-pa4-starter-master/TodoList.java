import java.io.*;
import java.util.*;

public class TodoList {

    //DO NOT MODIFY THE INSTANCE/STATIC VARIABLES

    private static final int DEFAULT_MAX_ITEMS = 10;

    TodoItem[] items;
    int count;    // current number of items in the TodoList

    /**
     * No parameter constructor for TodoList
     *
     */
    public TodoList() {
        items = new TodoItem[DEFAULT_MAX_ITEMS];
    }

    /**
     * Constructor that initializes the TodoList with the given number
     * of items
     *
     * @param numItems the maximum number of items the TodoList can hold
     */
    public TodoList(int numItems) {
        items = new TodoItem[numItems];
    }

    /**
     * Constructor that initializes the TodoList using the items
     * specified in the input file.
     *
     * @param inputFile              the input file containing list items
     * @throws FileNotFoundException if the file is not found
     */
    public TodoList(String inputFile) throws FileNotFoundException {
        File inFile = new File(inputFile);
        Scanner scanner = new Scanner(inFile);
        int length = 0;
        while(scanner.hasNextLine()) {
        	length += 1;
        }
        scanner.close();
        items = new TodoItem[length];
        Scanner scanner1 = new Scanner(inFile);
        while (scanner1.hasNextLine()) {
        	System.out.println("line#: " + count);
        	String line = scanner1.nextLine();
        	String[] lineArr = line.split(",");
        	String idStr = lineArr[0].substring(lineArr[0].indexOf("=") + 1);
        	String taskStr = lineArr[1].substring(lineArr[1].indexOf("=") + 1);
        	Boolean complBool = Boolean.parseBoolean(lineArr[2].substring(lineArr[2].indexOf("=") + 1));
        	String dueStr = lineArr[3].substring(lineArr[3].indexOf("=") + 1, 
        					lineArr[3].indexOf("]"));
        	int itemId = Integer.parseInt(idStr);
        	if (dueStr.equals("null")) {
        		TodoItem newItem = new TodoItem(taskStr);
        		newItem.setComplete(complBool);
        		newItem.setId(itemId);
        		System.out.println(newItem.toString());
        		this.addItem(newItem);
        	}
        	else {
	        	DateTime itemDate = new DateTime(dueStr);
	        	TodoItem newItem = new TodoItem(taskStr, complBool, itemDate);
	        	newItem.setId(itemId);
	        	System.out.println(newItem.toString());
	        	this.addItem(newItem);
        	}
        }
        scanner1.close();
       
    }

    /**
     * Method to get the items in the TodoList
     *
     * @return the array of TodoItems
     */
    public TodoItem[] getItems() {
        return this.items;
    }

    /**
     * Method to get the maximum count of items
     * in the TodoList
     *
     * @return the maximum number of items in the TodoList
     */
    public int getMaxItems() {
        return this.items.length;
    }

    /**
     * Method to get the current count of items
     * in the TodoList
     *
     * @return the number of items in the TodoList
     */
    public int getCount() {
        //TODO: Implement this method
        return this.count;
    }

    /**
     * Adds the given item to the TodoList.
     * @param item TodoItem to be added
     * @return     true if item was added successfully, false otherwise
     *             (e.g., when list is full)
     */
    public boolean addItem(TodoItem item) {
        for (int i = 0; i < this.items.length; i++) {
        	if (items[i] == null) {
        		items[i] = item;
        		return true;
        	}
        }
        return false;
    }

    /**
     * Removes the given item from the TodoList.
     * @param item TodoItem to be removed
     * @return     true if item was removed successfully, false otherwise
     *             (e.g., when list is empty or item was not found in the list)
     */
    public boolean removeItem(TodoItem item) {
        //TODO: Implement this method
        return false;
    }

    /**
     * Method to update an existing item in the TodoList.
     * Will not update null items.
     *
     * @param item  the new TodoItem that it has to be updated to
     * @param index the index at which the update should be made
     *              (zero-indexed integer)
     * @return      the previously existing TodoItem at the index
     */
    public TodoItem updateItem(TodoItem item, int index) {
        //TODO: Implement this method
        return null;
    }

    /**
     * Method to get all the unfinished items in the TodoList
     *
     * @return the array of unfinished TodoItems
     */
    public TodoItem[] getUnfinishedItems() {
        //TODO: Implement this method
        return null;
    }

    /**
     * Method to find the items whose task description contains the
     * given word
     *
     * @param word the word that should be matched to the task description
     *             of the item
     * @return     the array of TodoItems that contains the given word
     */
    public TodoItem[] findItems(String word) {
        //TODO: Implement this method
        return null;
    }

    /**
     * Method to retrieve an item based on its unique id
     *
     * @param id the unique id of the Item
     * @return   the TodoItem that has the given id
     */
    public TodoItem findItem(int id) {
        //TODO: Implement this method
        return null;
    }

    /**
     * toString method to print the TodoList
     *
     */
    @Override
    public String toString() {
    	String str = "";
    		for (int i = 0; i < this.items.length; i++) {
    			str += (i + 1) + ". " + items[i].toString();
    		}
        return str;
    }

    /**
     * Method to save the TodoList into a file
     *
     * @param fileName               the file into which the TodoList will
     *                               be stored
     * @return                       true will the save was successful,
     *                               false otherwise
     * @throws FileNotFoundException if the file is not found
     */
    public boolean saveTodoListToFile(String fileName)
            throws FileNotFoundException {
        //TODO: Implement this method
        return false;
    }

    // NOTE: Below methods are optional!

    /**
     * Method to get the unfinished TodoItems to work on
     * with the earliest due dates
     *
     * @return the array of unfinished TodoItems to work on
     *         with the earliest due dates
     */
    public TodoItem[] nextItemsToWorkOn() {
        //TODO: Implement this method
        return null;
    }

    /**
     * Method to get all the items unfinished before the given date
     *
     * @param currentDateTime the due date of the items retrieved should be
     *                        on or before the currentDateTime
     * @return                the array of overdue TodoItems
     */
    public TodoItem[] getOverdueItems(DateTime currentDateTime) {
        //TODO: Implement this method
        return null;
    }


    /**
     * Method to get all the items within a given duration
     *
     * @param fromDateTime the due date of the items retrieved should be
     *                     on or after the fromDateTime
     * @param toDateTime   the due date of the items retrieved should be
     *                     on or before the toDateTime
     * @return             the array of TodoItems within the given duration
     */
    public TodoItem[] findItems(DateTime fromDateTime, DateTime toDateTime) {
        //TODO: Implement this method
        return null;
    }

}
