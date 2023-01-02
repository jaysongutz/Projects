public class TodoItem {

    // DO NOT MODIFY THE INSTANCE VARIABLES
    String task;
    boolean isComplete;
    DateTime dueDate;
    int id;

    static int maxId = 0;

    /**
     * Constructor for TodoItem which takes in only the task
     *
     */
    public TodoItem(String task) {
        this.task = task;
        this.id++;
    }

    /**
     * Constructor for TodoItem which takes in the task
     * and due date
     *
     * @param task description of the task to be added
     * @param dueDate due date of the task
     */
    public TodoItem(String task, DateTime dueDate) {
        this.task = task;
        this.dueDate = dueDate;
        this.id++;
    }

    /**
     * Constructor for TodoItem which takes in the task,
     * due date and whether is it complete or not
     *
     * @param task description of the task to be added
     * @param isComplete (in)complete status of the task
     * @param dueDate due date of the task
     */
    public TodoItem(String task, boolean isComplete, DateTime dueDate) {
        this.task = task;
        this.isComplete = isComplete;
        this.dueDate = dueDate;
        this.id++;
    }

    /**
     * Method to get the task description
     *
     * @return the task defined in the item
     */
    public String getTask() {
        return this.task;
    }

    /**
     * Method to set the task value of the item
     *
     * @param task the task value for the item
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * Method which checks if the item is complete
     *
     * @return true if the item is complete, false otherwise
     */
    public boolean isComplete() {
        return this.isComplete;
    }

    /**
     * Method to set the value of isComplete for the item
     *
     * @param isComplete the value of the isComplete variable
     *                   of the item
     */
    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    /**
     * Method to get the due date of the item
     *
     * @return the DateTime at which the item is due
     */
    public DateTime getDueDate() {
    	return this.dueDate;
    }

    /**
     * Method to set the due date of the item
     *
     * @param dueDate the due date of the item
     */
    public void setDueDate(DateTime dueDate) {
    	this.dueDate = dueDate;
    }

    /**
     * Method to get the unique id of the item
     *
     * @return the unique id of the item
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Method to set the unique id of the item
     *  
     * @param id the unique id of the item
     */
    public void setId(int id) {
    	this.id = id;
    }

    /**
     * toString method to print the TodoItem
     *
     ** @return A string representation of the TodoItem
     */
    @Override
    public String toString() {
    	if (this.dueDate == null) {
    		return "TodoItem [uniqueId=" + this.id + 
    	        	   ", task=" + this.task + 
    	        	   ", isComplete=" + this.isComplete +
    	        	   ", dueDate=null]";
    	}
    	else {
        return "TodoItem [uniqueId=" + this.id + 
        	   ", task=" + this.task + 
        	   ", isComplete=" + this.isComplete +
        	   ", dueDate=" + dueDate.toString() +
        	   "]";
    	}
    }

    /**
     * equals method to check for TodoItem equality
     *
     * @param other The other object to check the equality
     *
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {return false;}
        if (!(obj instanceof TodoItem)) {return false;}
        TodoItem otherObj = (TodoItem) obj;
        return (this.task.equals(otherObj.task)) && 
        	   (this.isComplete == otherObj.isComplete) &&
        	   (this.dueDate.equals(otherObj.dueDate)) &&
        	   (this.id == otherObj.id);
    }

}
