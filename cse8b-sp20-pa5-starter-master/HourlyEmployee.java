import java.io.FileNotFoundException;

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    EmployeeMain.java
// File:               HourlyEmployee.java
// Quarter:            (course) Spring 2020
//
// Author:             Jayson Gutierrez, jmgutier@ucsd.edu
// Instructor's Name:  Adalbert Gerald Soosai Raj
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Pair Partner:       (name of your pair programming partner)
// Email:              (email address of your programming partner)
// Instructor's Name:  (name of your partner's instructor)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////
public class HourlyEmployee extends Employee {
	
	double hoursWorked;
	double wage;
	public static final double MINIMUM_WAGE = 13.00;
	static int maxWorkHours = 80;
	
	/**
     * The constructor of the program
     * 
     * @param args The first element is the string of the employee's name
     * 			   The second element is a double of the hours the employee 
     * 			   worked
     * 			   The third element is a double of the employee's wage
     */
	
	public HourlyEmployee(String name, double hoursWorked, double wage) {
		super(name);
		if (hoursWorked >= 0) {this.hoursWorked = hoursWorked;}
		else {this.hoursWorked = 0;}
		if (wage >= MINIMUM_WAGE) {this.wage = wage;}
		else {this.wage = MINIMUM_WAGE;}
	}
	
	/**
     * A getter for the program
     * 
     * @return a double of the employee's hours worked
     */
	
	public double getHoursWorked() {
		return this.hoursWorked;
	}
	
	/**
     * A setter for the program
     * 
     * @param args double representing hours worked by the employee
     */
	
	public void setHoursWorked(double hoursWorked) {
		if (hoursWorked >= 0) {this.hoursWorked = hoursWorked;}
		else {this.hoursWorked = 0;}
	}
	
	/**
     * A getter for the program
     * 
     * @return a double of the wage of the employee
     */
	
	public double getWage() {
		return this.wage;
	}
	
	/**
     * A setter for the program
     * 
     * @param args double representing the employee's wage
     */
	
	public void setWage(double wage) {
		if (wage >= MINIMUM_WAGE) {this.wage = wage;}
		else {this.wage = MINIMUM_WAGE;}
	}
	
	/**
     * A getter for the program
     * 
     * @return returns the int of the max hours the employee can work
     * 
     */
	
	public static int getMaxWorkHours() {
		return maxWorkHours;
	}
	
	/**
     * A method to return the string representation of an HourlyEmployee object
     * 
     * @return a string representation of this HourlyEmployee object
     * 
     */
	
	public String toString() {
		return "Hourly Employee: " + super.toString() +
			   ", hoursWorked=" + this.hoursWorked + 
			   ", wage=" + this.wage;
	}
	
	/**
     * A getter method for the program
     * 
     * @return returns a double representing an HourlyEmployee's biweekly pay
     * 
     */
	
	public double getPay() {
		double pay = 0;
		if (this.hoursWorked <= maxWorkHours) {
			pay = this.hoursWorked * this.wage;
		}
		else {
			double overtimeHours = this.hoursWorked - maxWorkHours;
			pay = (maxWorkHours * this.wage) + (overtimeHours * 
				  (this.wage * 1.5));
		}
		return pay;
	}
	
}