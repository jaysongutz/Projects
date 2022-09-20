///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              EmployeeMain
// Files:              Employee.java HourlyEmployee.java SalariedEmployee.java
//					   CommissionEmployee.java
// Quarter:            (course) Spring 2020
//
// Author:             Jayson Gutierrez
// Email:              jmgutier@ucsd.edu
// Instructor's Name:  Adalbert Gerald Soosai Raj
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS
//                   ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in CSE 8B syllabus)
//                   2. choose a partner wisely
//                   3. complete this section for each program file.
//
// Pair Partner:        (name of your pair programming partner)
// Email:               (email address of your programming partner)
// Instructors's Name:  (name of your partner's instructor)
// Lab Section:         (your partner's lab section number)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that contains the main for the Employee program
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
public class EmployeeMain {
    public static final int NUM_ARGS = 2;
    public static final String AVG_PAY_STR = "Average pay of employees: ";
    public static final String CATEGORIES_STR = "Employee category count: ";
    public static final String ERROR_MSG
        = "USAGE: java EmployeeMain <inFile> <outFile>";
    
    /**
     * The main method for the program
     * 
     * @param args The first element is the filename to read from
     *             The second element is the filename to write to
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != NUM_ARGS) {
            System.out.println(ERROR_MSG);
            return;
        }
        // args[0] - inputFile; args[1] - outputFile
        Employee[] employees = readEmployeesFromFile(args[0]);
        System.out.println(AVG_PAY_STR + averagePay(employees));
        System.out.println(CATEGORIES_STR
                            + Arrays.toString(categoryCount(employees)));
        printEmployeeDetails(employees);
        printSpecificDetails(employees);
        writeEmployeesToFile(employees, args[1]);
    }

    /**
     * Reads employee data from a file and stores it in an array of
     * Employees.
     * 
     * @param inputFile The file to read employee data from
     * @return The array of Employees
     * @throws FileNotFoundException
     */
    public static Employee[] readEmployeesFromFile(String inputFile)
            throws FileNotFoundException {
    	if (inputFile == null) {
    		return null;
    	}
        File inFile = new File(inputFile);
        if (inFile.length() == 0) {
        	return new Employee[0];
        }
        Scanner scanner = new Scanner(inFile);
        int length = 0;
        while (scanner.hasNextLine()) {
        	scanner.nextLine();
        	length++;
        }
        Employee[] employees = new Employee[length];
        //int index indicates the position of employees for when I pass in
        //a new Employee subclass object
        int index = 0;
        scanner.close();
        Scanner scanner1 = new Scanner(inFile);
        //iterates through the input file and creates a new object corresponding
        //to the information on each line of the input file
        while (scanner1.hasNextLine()) {
        	String[] line = scanner1.nextLine().split(",");
        	for (int i = 0; i < line.length; i++) {
        		line[i] = line[i].trim();
        	}
        	if (line[0].equals("H")) {
        		HourlyEmployee entry = new HourlyEmployee(line[1],
        						   Double.parseDouble(line[2]),
        						   Double.parseDouble(line[3]));
        		employees[index] = entry;
        		index++;
        	}
        	else if (line[0].equals("S") ) {
        		SalariedEmployee entry = new SalariedEmployee(line[1],
        						   Double.parseDouble(line[2]),
        						   Integer.parseInt(line[3]));
        		employees[index] = entry;
        		index++;
        	}
        	else if (line[0].equals("C")) {
        		CommissionEmployee entry = new CommissionEmployee(line[1],
        						   Double.parseDouble(line[2]),
        						   Double.parseDouble(line[3])/100);
        		System.out.println(entry.toString());
        		employees[index] = entry;
        		index++;
        	}
        	
        }
        
        scanner1.close();
        return employees;
    }

    /**
     * Computes the average biweekly pay for all employees
     * 
     * @param empArr The array of all employees
     * @return The average pay
     */
    public static double averagePay(Employee[] empArr) {
    	if (empArr == null) {return 0;}
    	if (empArr.length == 0) {return 0;}
        int length = empArr.length;
        double totalPay = 0;
        for (int i = 0; i < empArr.length; i++) {
        	totalPay += empArr[i].getPay();
        }
        double avgPay = totalPay/ (double)length;
        return avgPay;
    }

    /**
     * Computes the count of each type of employees and returns
     * the counts in an int array of [hourly, salaried, commission]
     * 
     * @param empArr The array of all employees
     * @return The counts for each type of employee
     */
    public static int[] categoryCount(Employee[] empArr) {
    	if (empArr == null) {
    		return new int[3];
    	}
    	if (empArr.length == 0) {
    		return new int[3];
    	}
    	int[] count = new int[3];
        for (int i = 0; i < empArr.length; i++) {
        	if (empArr[i] instanceof HourlyEmployee) {
        		count[0]++;
        	}
        	else if (empArr[i] instanceof SalariedEmployee) {
        		count[1]++;
        	}
        	else if(empArr[i] instanceof CommissionEmployee) {
        		count[2]++;
        	}
        }
        return count;
    }

    /**
     * Prints the details of all the employees using the same format from
     * the toString method
     * 
     * @param empArr The array of all employees
     */
    public static void printEmployeeDetails(Employee[] empArr) {
    	if (empArr == null) {
    		return;
    	}
    	if (empArr.length == 0) {
    		return;
    	}
    	for (int i = 0; i < empArr.length; i++) {
    		System.out.println(empArr[i].toString());
    	}
    }

    /**
     * Prints the details of all the employees using the same format from
     * the toString method
     *
     * @param empArr The array of all employees
     */
    public static void printSpecificDetails(Employee[] empArr) {
        if (empArr == null) {
        	return;
        }
        if (empArr.length == 0) {
        	return;
        }
        for (int i = 0; i < empArr.length; i++) {
        	if (empArr[i] instanceof HourlyEmployee) {
        		HourlyEmployee index = (HourlyEmployee) empArr[i];
        		System.out.println("Employee id = " + 
        						  empArr[i].getEmpId() + 
        						  "; Hours worked = " +
        						   index.getHoursWorked());
        	}
        	else if (empArr[i] instanceof SalariedEmployee) {
        		SalariedEmployee index = (SalariedEmployee) empArr[i];
        		System.out.println("Employee id = " + 
        						  empArr[i].getEmpId() + 
        						  "; Base Salary = " + 
        						  index.getBaseSalary());
        	}
        	else if (empArr[i] instanceof CommissionEmployee) {
        		CommissionEmployee index = (CommissionEmployee) empArr[i];
        		System.out.println("Employee id = " + 
        						  empArr[i].getEmpId() +
        						  "; Commission Rate = " + 
        						  index.getCommissionRate());
        	}
        }
    }
    
    /**
     * Writes the details of all employees to a file using the same format from
     * the toString method appended with each employees biweekly pay
     * 
     * @param empArr The array of all employees
     * @param outputFile The filename to write to
     * @throws FileNotFoundException
     */
    public static void writeEmployeesToFile(Employee[] empArr,
            String outputFile) throws FileNotFoundException {
    	if (empArr == null) {
    		return;
    	}
    	if (empArr.length == 0) {
    		return;
    	}
    	File outFile = new File(outputFile);
    	PrintWriter writer = new PrintWriter(outFile);
    	for (int i = 0; i < empArr.length; i++) {
    		writer.print(empArr[i].toString());
    		writer.println(", Pay: " + empArr[i].getPay());
    	}

    	writer.close();
    }
}
