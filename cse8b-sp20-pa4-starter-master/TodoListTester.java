import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TodoListTester {

    @Test
    public void testNoArgsConstructor() {
        TodoList todoList = new TodoList();
        TodoItem[] expectedItems = new TodoItem[10];
        int expectedMaxItems = 10;
        int expectedCount = 0;

        assertArrayEquals(expectedItems, todoList.getItems());
        assertEquals(expectedCount, todoList.getCount());
        assertEquals(expectedMaxItems, todoList.getMaxItems());
    }

    @Test
    public void testInitalizeMaxItemsConstructor() {
        // Testing when max item is negative
        TodoList todoList1 = new TodoList(-1);
        TodoItem[] expectedItems1 = new TodoItem[10];
        int expectedMaxItems1 = 10;
        int expectedCount1 = 0;

        assertArrayEquals(expectedItems1, todoList1.getItems());
        assertEquals(expectedCount1, todoList1.getCount());
        assertEquals(expectedMaxItems1, todoList1.getMaxItems());

        // Testing when max item is positive
        TodoList todoList2 = new TodoList(5);
        TodoItem[] expectedItems2 = new TodoItem[5];
        int expectedMaxItems2 = 5;
        int expectedCount2 = 0;

        assertArrayEquals(expectedItems2, todoList2.getItems());
        assertEquals(expectedCount2, todoList2.getCount());
        assertEquals(expectedMaxItems2, todoList2.getMaxItems());

    }

    @Test
    public void testImportFileConstructor() throws FileNotFoundException {
        TodoItem.maxId = 0;
        DateTime dueDate1 =  new DateTime("2020-04-22@16:15");

        TodoItem todoItem1 = new TodoItem("CSE8B PA4", dueDate1);
        TodoItem todoItem2 = new TodoItem("CSE8B RQ08");
        TodoItem todoItem3 = new TodoItem("CSE8B Quiz5");

        //Testing empty TodoList
        TodoList todoList1 = new TodoList(0);
        todoList1.saveTodoListToFile("TodoList1.txt");
        TodoItem.maxId = 0;
        TodoList todoListLoaded1 = new TodoList("TodoList1.txt");

        assertArrayEquals(todoList1.getItems(), todoListLoaded1.getItems());
        assertEquals(todoList1.getCount(), todoListLoaded1.getCount());
        assertEquals(todoList1.getMaxItems(), todoListLoaded1.getMaxItems());

        //Testing non-empty TodoList
        TodoList todoList2 = new TodoList(3);
        todoList2.addItem(todoItem1);
        todoList2.addItem(todoItem2);
        todoList2.addItem(todoItem3);
        TodoItem.maxId = 0;
        todoList2.saveTodoListToFile("TodoList2.txt");
        TodoList todoListLoaded2 = new TodoList("TodoList2.txt");

        assertArrayEquals(todoList2.getItems(), todoListLoaded2.getItems());
        assertEquals(todoList2.getCount(), todoListLoaded2.getCount());
        assertEquals(todoList2.getMaxItems(), todoListLoaded2.getMaxItems());
    }

    @Test
    public void testGetItems() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetCount() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetMaxItems() {
        fail("Not yet implemented");
    }

    @Test
    public void testAddItem() {
        fail("Not yet implemented");
    }

    @Test
    public void testRemoveItem() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateItem() {
        fail("Not yet implemented");
    }

    @Test
    public void testNextItemsToWorkOn() {
        DateTime dueDate1 =  new DateTime("2020-04-22@16:15");
        DateTime dueDate2 =  new DateTime("2020-04-23@16:15");

        TodoItem todoItem1 = new TodoItem("CSE8B PA4", dueDate1);
        TodoItem todoItem2 = new TodoItem("CSE8B RQ08", dueDate1);
        TodoItem todoItem3 = new TodoItem("CSE8B Quiz5", dueDate2);

        //Testing empty TodoList
        TodoList todoList1 = new TodoList();
        TodoItem[] actualItems1 = todoList1.nextItemsToWorkOn();
        TodoItem[] expectedItems1 = null;
        assertArrayEquals(expectedItems1, actualItems1);

        //Testing one item due next
        TodoList todoList2 = new TodoList();
        todoList2.addItem(todoItem1);
        TodoItem[] actualItems2 = todoList2.nextItemsToWorkOn();
        TodoItem[] expectedItems2 = {todoItem1};
        assertArrayEquals(expectedItems2, actualItems2);

        //Testing multiple items in list
        TodoList todoList3 = new TodoList();
        todoList3.addItem(todoItem1);
        todoList3.addItem(todoItem3);
        TodoItem[] actualItems3 = todoList3.nextItemsToWorkOn();
        TodoItem[] expectedItems3 = {todoItem1};
        assertArrayEquals(expectedItems3, actualItems3);

        //Testing multiple items due next
        TodoList todoList4 = new TodoList();
        todoList4.addItem(todoItem1);
        todoList4.addItem(todoItem2);
        todoList4.addItem(todoItem3);
        TodoItem[] actualItems4 = todoList4.nextItemsToWorkOn();
        TodoItem[] expectedItems4 = {todoItem1, todoItem2};
        assertArrayEquals(expectedItems4, actualItems4);
    }

    @Test
    public void testGetUnfinishedItems() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetOverdueItems() {
        DateTime dueDate1 =  new DateTime("2020-04-22@16:15");
        DateTime dueDate2 =  new DateTime("2020-04-24@16:15");
        DateTime currDate = new DateTime("2020-04-23@16:15");

        TodoItem todoItem1 = new TodoItem("CSE8B PA4", dueDate1);
        TodoItem todoItem2 = new TodoItem("CSE8B RQ08", dueDate1);
        TodoItem todoItem3 = new TodoItem("CSE8B Quiz5", dueDate2);

        //Testing empty TodoList
        TodoList todoList1 = new TodoList();
        TodoItem[] actualItems1 = todoList1.getOverdueItems(currDate);
        TodoItem[] expectedItems1 = null;
        assertArrayEquals(expectedItems1, actualItems1);

        //Testing one item overdue
        TodoList todoList2 = new TodoList();
        todoList2.addItem(todoItem1);
        TodoItem[] actualItems2 = todoList2.getOverdueItems(currDate);
        TodoItem[] expectedItems2 = {todoItem1};
        assertArrayEquals(expectedItems2, actualItems2);

        //Testing multiple items in list
        TodoList todoList3 = new TodoList();
        todoList3.addItem(todoItem1);
        todoList3.addItem(todoItem3);
        TodoItem[] actualItems3 = todoList3.getOverdueItems(currDate);
        TodoItem[] expectedItems3 = {todoItem1};
        assertArrayEquals(expectedItems3, actualItems3);

        //Testing multiple items overdue
        TodoList todoList4 = new TodoList();
        todoList4.addItem(todoItem1);
        todoList4.addItem(todoItem2);
        todoList4.addItem(todoItem3);
        TodoItem[] actualItems4 = todoList4.getOverdueItems(currDate);
        TodoItem[] expectedItems4 = {todoItem1, todoItem2};
        assertArrayEquals(expectedItems4, actualItems4);
    }

    @Test
    public void testFindItemsByTime() {
        DateTime dueDate1 =  new DateTime("2020-04-22@16:15");
        DateTime dueDate2 =  new DateTime("2020-04-23@16:15");
        DateTime dueDate3 = new DateTime("2020-04-24@16:15");

        TodoItem todoItem1 = new TodoItem("CSE8B PA4", dueDate1);
        TodoItem todoItem2 = new TodoItem("CSE8B RQ08", dueDate2);
        TodoItem todoItem3 = new TodoItem("CSE8B Quiz5", dueDate3);

        //Testing empty TodoList
        TodoList todoList1 = new TodoList();
        TodoItem[] actualItems1 = todoList1.findItems(dueDate1, dueDate2);
        TodoItem[] expectedItems1 = null;
        assertArrayEquals(expectedItems1, actualItems1);

        //Testing one item in range
        TodoList todoList2 = new TodoList();
        todoList2.addItem(todoItem1);
        TodoItem[] actualItems2 = todoList2.findItems(dueDate1, dueDate2);
        TodoItem[] expectedItems2 = {todoItem1};
        assertArrayEquals(expectedItems2, actualItems2);

        //Testing multiple items in list, only one in range
        TodoList todoList3 = new TodoList();
        todoList3.addItem(todoItem1);
        todoList3.addItem(todoItem3);
        TodoItem[] actualItems3 = todoList3.findItems(dueDate1, dueDate2);
        TodoItem[] expectedItems3 = {todoItem1};
        assertArrayEquals(expectedItems3, actualItems3);

        //Testing multiple items in range
        TodoList todoList4 = new TodoList();
        todoList4.addItem(todoItem1);
        todoList4.addItem(todoItem2);
        todoList4.addItem(todoItem3);
        TodoItem[] actualItems4 = todoList4.findItems(dueDate1, dueDate2);
        TodoItem[] expectedItems4 = {todoItem1, todoItem2};
        assertArrayEquals(expectedItems4, actualItems4);
    }

    @Test
    public void testFindItemsByDescription() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindItemsById() {
        fail("Not yet implemented");
    }


    @Test
    public void testToString() {
        fail("Not yet implemented");
     }

    @Test
    public void testSaveTodoListToFile() throws FileNotFoundException {
        fail("Not yet implemented");
    }
}
