///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    BaseRegion.java
// File:               (name of this class's file)
// Quarter:            (course) Spring 2020
//
// Author:             Jayson Gutierrez, jmgutier@ucsd.edu
// Instructor's Name:  Adalbert Gerald Soosai Raj
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
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
/**
 * This is a concrete class that implements BaseRegion and defines a Rectangle
 *
 * @author Jayson Gutierrez
 */
class Rectangle extends BaseRegion {
	
	Point topLeft;
	double width;
	double height;
	
	/**
	 * Constructor for Rectangle
	 *
	 * @param Point - Point object representing top left corner of Rectangle
	 * @param width - double representing width of Rectangle
	 * @param height - double representing height of Rectangle
	 */
	public Rectangle(Point topLeft, double width, double height) {
		this.name = "Rectangle";
		this.topLeft = new Point(topLeft.x, topLeft.y);
		if(width < 0) {
			this.width = 0;
		}
		else {
			this.width = width;
		}
		if (height < 0) {
			this.height = 0;
		}
		else {
			this.height = height;
		}
	}
	
	/**
	 * Getter method calculating this rectangle's area
	 *
	 * @return area of this rectangle
	 */
	public double getArea() {
		return this.width * this.height;
	}
	
	/**
	 * Getter method calculating this rectangle's perimeter
	 *
	 * @return perimeter of this rectangle
	 */
	public double getPerimeter() {
		return (this.width * 2) + (this.height * 2);
	}
	
	/**
	 * Method to check if a point lies on this rectangle
	 */
	public boolean contains(Point p) {
		double topRightX = this.topLeft.x + this.width;
		double btmLeftY = this.topLeft.y + this.height;
		if ((p.x <= topRightX && p.x >= this.topLeft.x) &&
		    (p.y <= btmLeftY && p.y >= this.topLeft.y)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method to print out the state of this rectangle
	 */
	public void printDetails() {
		super.printDetails();
		System.out.println("area: " + this.getArea());
		System.out.println("perimeter: " + this.getPerimeter());
	}
	
}