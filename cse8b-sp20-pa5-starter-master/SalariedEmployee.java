///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    (name of main application class)
// File:               (name of this class's file)
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
public class SalariedEmployee extends Employee {
	
	double baseSalary;
	public static final double MINIMUM_SALARY = 27040;
	int numWeeks;
	public static final int MINIMUM_WEEKS = 2;
	public static final int MAXIMUM_WEEKS = 52;
	
	/**
     * The constructor of the program
     * 
     * @param args The first element is the string of the employee's name
     * 			   The second element is a double of the base salary of 
     * 			   the employee
     * 			   The third element is an int of the number of weeks
     * 			   the employee worked
     */
	
	public SalariedEmployee(String name, double baseSalary, int numWeeks) {
		super(name);
		if (baseSalary >= MINIMUM_SALARY) {this.baseSalary = baseSalary;}
		else {this.baseSalary = MINIMUM_SALARY;}
		if (numWeeks >= MINIMUM_WEEKS && numWeeks <= MAXIMUM_WEEKS)
		{this.numWeeks = numWeeks;}
		else if (numWeeks > MAXIMUM_WEEKS) {this.numWeeks = MAXIMUM_WEEKS;}
		else {this.numWeeks = MINIMUM_WEEKS;}
		
	}
	
	/**
     * A getter for the program
     * 
     * @return a double of the employee's base salary
     */
	
	public double getBaseSalary() {
		return this.baseSalary;
	}
	
	/**
     * A setter for the program
     * 
     * @param args double representing base salary of employee
     */
	
	public void setBaseSalary(double baseSalary) {
		if (baseSalary >= MINIMUM_SALARY) {this.baseSalary = baseSalary;}
		else {this.baseSalary = MINIMUM_SALARY;}
	}
	
	/**
     * A getter for the program
     * 
     * @return an int of number of weeks that employee has worked
     */
	
	public int getNumWeeks() {
		return this.numWeeks;
	}
	
	/**
     * A setter for the program
     * 
     * @param args int of number of weeks that employee has worked
     */
	
	public void setNumWeeks(int numWeeks) {
		if (numWeeks >= MINIMUM_WEEKS && numWeeks <= MAXIMUM_WEEKS)
		{this.numWeeks = numWeeks;}
		else if (numWeeks > MAXIMUM_WEEKS) {this.numWeeks = MAXIMUM_WEEKS;}
		else {this.numWeeks = MINIMUM_WEEKS;}
	}
	
	/**
     * A method to return the string representation of an SalariedEmployee object
     * 
     * @return a string representation of this SalariedEmployee object
     * 
     */
	
	public String toString() {
		return "Salaried Employee: " + super.toString() + 
			   ", baseSalary=" + this.baseSalary +
			   ", numWeeks=" + this.numWeeks;
	}
	
	/**
     * A getter method for the program
     * 
     * @return returns a double representing a SalariedEmployee's biweekly pay
     * 
     */
	
	public double getPay() {
		double pay = 0;
		int weeksPaid = 0;
		if ((this.numWeeks % 2) == 0) {weeksPaid = (this.numWeeks) / 2;}
		else {weeksPaid = (this.numWeeks - 1) / 2;}
		pay = this.baseSalary / weeksPaid;
		return pay; 
	}
	
}