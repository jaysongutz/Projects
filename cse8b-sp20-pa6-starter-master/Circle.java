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
 * This is a concrete class that implements BaseRegion and defines a Circle
 *
 * @author Jayson Gutierrez
 */
class Circle extends BaseRegion {
	
	Point center;
	double radius;
	double SQUARED = 2;
	double PERIMETER_FORMULA = 2;
	/**
	 * Constructor for Circle
	 *
	 * @param Point - Point object representing center of circle
	 * @param radius - double representing radius of circle
	 */
	public Circle(Point center, double radius) {
		this.name = "Circle";
		this.center = new Point(center.x, center.y);
		if (radius < 0) {this.radius = 0;}
		else {this.radius = radius;}
	}
	
	/**
	 * Getter method calculating this circle's area
	 *
	 * @return area of this circle
	 */
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}
	
	/**
	 * Getter method calculating this circle's perimeter
	 *
	 * @return perimeter of this circle
	 */
	public double getPerimeter() {
		return Math.PI * this.radius * PERIMETER_FORMULA;
	}

	/**
	 * Method to check if a point lies on this circle
	 */
	public boolean contains(Point p) {
		double xDistance = this.center.x - p.x;
		double yDistance = this.center.y - p.y;
		double ptDistance = Math.sqrt(Math.pow(xDistance, SQUARED) +
							Math.pow(yDistance, SQUARED));
		if (ptDistance <= this.radius) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method to print out the state of this circle
	 */
	public void printDetails() {
		super.printDetails();
		System.out.println("area: " + this.getArea());
		System.out.println("perimeter: " + this.getPerimeter());
	}
	
}