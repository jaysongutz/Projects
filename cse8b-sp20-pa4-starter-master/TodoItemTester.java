import static org.junit.Assert.*;

import org.junit.Test;

public class TodoItemTester {

    @Test
    public void testTaskConstructor() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW");
        String expectedTask = "Complete HW";
        DateTime expectedDueDate = null;
        boolean expectedIsComplete = false;
        int expectedId = 1;
        
        assertEquals(expectedTask, todoItem.getTask());
        assertEquals(expectedDueDate, todoItem.getDueDate());
        assertEquals(expectedIsComplete, todoItem.isComplete());
        assertEquals(expectedId, todoItem.getId());
    }
    
    @Test
    public void testTaskDueDateConstructor() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", new DateTime("2020-04-25@19:30"));
        String expectedTask = "Complete HW";
        DateTime expectedDueDate = new DateTime("2020-04-25@19:30");
        boolean expectedIsComplete = false;
        int expectedId = 1;
        
        assertEquals(expectedTask, todoItem.getTask());
        assertEquals(expectedDueDate, todoItem.getDueDate());
        assertEquals(expectedIsComplete, todoItem.isComplete());
        assertEquals(expectedId, todoItem.getId());
    }
    
    @Test
    public void testTaskIsCompleteDueDateConstructor() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        String expectedTask = "Complete HW";
        DateTime expectedDueDate = new DateTime("2020-04-25@19:30");
        boolean expectedIsComplete = true;
        int expectedId = 1;
        
        assertEquals(expectedTask, todoItem.getTask());
        assertEquals(expectedDueDate, todoItem.getDueDate());
        assertEquals(expectedIsComplete, todoItem.isComplete());
        assertEquals(expectedId, todoItem.getId());
    }
    
    @Test
    public void testGetTask() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        String expectedTask = "Complete HW";
        
        assertEquals(expectedTask, todoItem.getTask());
    }
    
    @Test
    public void testSetTask() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        String expectedTask = "Complete Quiz";
        todoItem.setTask("Complete Quiz");
        assertEquals(expectedTask, todoItem.getTask());
    }
    
    @Test
    public void testIsComplete() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        boolean expectedIsComplete = true;
        
        assertEquals(expectedIsComplete, todoItem.isComplete());
    }
    
    @Test
    public void testSetComplete() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        todoItem.setComplete(false);
        boolean expectedIsComplete = false;
        assertEquals(expectedIsComplete, todoItem.isComplete());
    }
    
    @Test
    public void testGetDueDate() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        DateTime expectedDueDate = new DateTime("2020-04-25@19:30");
        
        assertEquals(expectedDueDate, todoItem.getDueDate());
    }
    
    @Test
    public void testSetDueDate() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        todoItem.setDueDate(new DateTime("2020-04-11@09:30"));
        DateTime expectedDueDate = new DateTime("2020-04-11@09:30");
        assertEquals(expectedDueDate, todoItem.getDueDate());
    }
    
    @Test
    public void testGetId() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        int expectedId = 1;
        assertEquals(expectedId, todoItem.getId());
    }
    
    @Test
    public void testSetId() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));       
        todoItem.setId(2);
        int expectedId = 2;
        assertEquals(expectedId, todoItem.getId());
    }
    
    @Test
    public void testToString() {
        TodoItem.maxId = 0;
        TodoItem todoItem = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        String expectedString = "TodoItem [uniqueId=1, task=Complete HW, isComplete=true, dueDate=2020-04-25@19:30]";
        assertEquals(expectedString, todoItem.toString());
    }
    
    @Test
    public void testEquals() {
        TodoItem.maxId = 0;
        TodoItem todoItem1 = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        TodoItem.maxId = 0;
        TodoItem todoItem2 = new TodoItem("Complete HW", true, new DateTime("2020-04-25@19:30"));
        boolean expectedResult = true;
        assertEquals(expectedResult, todoItem1.equals(todoItem2));
    }

}
