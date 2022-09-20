import static org.junit.Assert.*;

import org.junit.Test;

public class DateTimeTester {

    @Test
    public void testFiveArgsConstructor() {
        DateTime dateTime = new DateTime(2020,12,01,13,20);
        int expectedYear = 2020;
        int expectedMonth = 12;
        int expectedDay = 01;
        int expectedHours = 13;
        int expectedMins = 20;
        
        assertEquals(expectedYear, dateTime.getYear());
        assertEquals(expectedMonth, dateTime.getMonth());
        assertEquals(expectedDay, dateTime.getDay());
        assertEquals(expectedHours, dateTime.getHours());
        assertEquals(expectedMins, dateTime.getMins());
    }
    
    @Test
    public void testStringConstructor() {
        DateTime dateTime = new DateTime("2020-12-01@13:20");
        int expectedYear = 2020;
        int expectedMonth = 12;
        int expectedDay = 01;
        int expectedHours = 13;
        int expectedMins = 20;
        
        assertEquals(expectedYear, dateTime.getYear());
        assertEquals(expectedMonth, dateTime.getMonth());
        assertEquals(expectedDay, dateTime.getDay());
        assertEquals(expectedHours, dateTime.getHours());
        assertEquals(expectedMins, dateTime.getMins());
    }
    
    @Test
    public void testGetYear() {
        DateTime dateTime = new DateTime("2020-12-01@13:20");
        int expectedYear = 2020;        
        assertEquals(expectedYear, dateTime.getYear());
    }
    
    @Test
    public void testGetMonth() {
        DateTime dateTime = new DateTime("2020-12-01@13:20");
        int expectedMonth = 12;
        assertEquals(expectedMonth, dateTime.getMonth());
    }
    
    @Test
    public void testGetDay() {
        DateTime dateTime = new DateTime("2020-12-01@13:20");
        int expectedDay = 01;
        assertEquals(expectedDay, dateTime.getDay());
    }
    
    @Test
    public void testGetHours() {
        DateTime dateTime = new DateTime("2020-12-01@13:20");
        int expectedHours = 13;
        assertEquals(expectedHours, dateTime.getHours());
    }
    
    @Test
    public void testGetMins() {
        DateTime dateTime = new DateTime("2020-12-01@13:20");
        int expectedMins = 20;
        assertEquals(expectedMins, dateTime.getMins());
    }
    
    @Test
    public void testToString() {
        DateTime dateTime = new DateTime("2020-12-01@13:20");
        String expectedString = "2020-12-01@13:20";
        assertEquals(expectedString, dateTime.toString());
    }
    
    @Test
    public void testCompare() {
        DateTime dateTime1 = new DateTime("2020-12-01@13:20");
        DateTime dateTime2 = new DateTime("2020-12-01@13:45");
        int expectedResult1 = -1;
        assertEquals(expectedResult1, dateTime1.compare(dateTime2));
        
        int expectedResult2 = 1;
        assertEquals(expectedResult2, dateTime2.compare(dateTime1));
    }
    
    @Test
    public void testEquals() {
        DateTime dateTime1 = new DateTime("2020-12-01@13:20");
        DateTime dateTime2 = new DateTime("2020-12-01@13:20");
        boolean expectedResult1 = true;
        assertEquals(expectedResult1, dateTime1.equals(dateTime2));
    }
    
    

}
