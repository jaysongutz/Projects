///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    EmployeeMain.java
// File:               CommissionEmployee.java
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
public class CommissionEmployee extends Employee {
	
	double grossSales;
	double commissionRate;
	public static final double MINIMUM_COMMISSION_RATE = .01;
	
	/**
     * The constructor of the program
     * 
     * @param args The first element is the string of the employee's name
     * 			   The second element is a double of the base salary of 
     * 			   the employee
     * 			   The third element is an int of the number of weeks
     * 			   the employee worked
     */
	
	public CommissionEmployee(String name, double grossSales, 
							  double commissionRate) {
		super(name);
		if (grossSales >= 0) {this.grossSales = grossSales;}
		else {this.grossSales = 0;}
		if (commissionRate >= MINIMUM_COMMISSION_RATE) {this.commissionRate = 
														commissionRate;}
		else {this.commissionRate = MINIMUM_COMMISSION_RATE;}
	}
	
	/**
     * A getter for the program
     * 
     * @return a double of the employee's gross sales
     */
	
	public double getGrossSales() {
		return this.grossSales;
	}
	
	/**
     * A setter for the program
     * 
     * @param args double representing gross salary of employee
     */
	
	public void setGrossSales(double grossSales) {
		if (grossSales >= 0) {this.grossSales = grossSales;}
		else {this.grossSales = 0;}
	}
	
	/**
     * A getter for the program
     * 
     * @return a double of the employee's commission rate
     */
	
	public double getCommissionRate() {
		return this.commissionRate;
	}	
	
	/**
     * A setter for the program
     * 
     * @param args double of employee's commission rate
     */
	
	public void setCommissionRate(double commissionRate) {
		if (commissionRate >= MINIMUM_COMMISSION_RATE) {this.commissionRate =
														commissionRate;}
		else {this.commissionRate = MINIMUM_COMMISSION_RATE;}
	}
	
	/**
     * A method to return the string representation of a CommissionEmployee object
     * 
     * @return a string representation of this CommissionEmployee object
     * 
     */
	
	public String toString() {
		return "Commissioned Employee: " + super.toString() +
			   ", grossSales=" + this.grossSales + 
			   ", commissionRate=" + this.commissionRate;
	}
	
	/**
     * A getter method for the program
     * 
     * @return returns a double representing a CommissionEmployee's biweekly pay
     * 
     */
	
	public double getPay() {
		double pay = 0;
		pay = this.grossSales * this.commissionRate;
		return pay;
	}
	
}

