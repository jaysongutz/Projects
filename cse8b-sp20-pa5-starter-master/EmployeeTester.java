import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test cases for Employee.java
 */
public class EmployeeTester {

    @Test
    public void testConstructor() {
        Employee.numEmployees = 0; //reset numEmployees for correct empId
        Employee employee = new Employee("Winny Wilson");
        int expectedEmpId = 1;
        String expectedName = "Winny Wilson";
        assertEquals(expectedEmpId, employee.getEmpId());
        assertEquals(expectedName, employee.getName());
    }

    @Test
    public void testToString() {
        Employee.numEmployees = 0; //reset numEmployees for correct empId
        Employee employee = new Employee("Winny Wilson");
        String expectedString = "empId=1, name=Winny Wilson";
        assertEquals(expectedString, employee.toString());
    }

    @Test
    public void testGetPay() {
        Employee employee = new Employee("Winny Wilson");
        double expectedPay = 0;
        assertEquals(expectedPay, employee.getPay(), 0.0001);
    }
}
