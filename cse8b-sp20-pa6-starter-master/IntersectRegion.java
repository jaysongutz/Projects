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
 * This is a concrete class that extends BaseRegion and defines an intersection
 * between two BaseRegion subclasses
 *
 * @author Jayson Gutierrez
 */
class IntersectRegion extends BaseRegion {
	
	BaseRegion reg1;
	BaseRegion reg2;
	
	/**
	 * Constructor for IntersectRegion
	 *
	 * @param reg1 - BaseRegion representing the first shape 
	 * @param reg2 - BaseRegion representing the second shape
	 */
	public IntersectRegion(BaseRegion reg1, BaseRegion reg2) {
		this.name = "Intersect Region between " + reg1.name + 
					" and " + reg2.name;
		this.reg1 = reg1;
		this.reg2 = reg2;
	}
	
	/**
	 * Method to check if a point lies on this intersection
	 */
	public boolean contains(Point p) {
		if (this.reg1.contains(p) &&
			this.reg2.contains(p)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}