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
 * This is an interface that defines what a region consists of
 *
 * @author Jayson Gutierrez
 */
interface Region {
	
	/**
	 * Abstract method for getting area to be implemented
	 */
	public double getArea();
	/**
	 * Abstract method for getting perimeter to be implemented
	 */
	public double getPerimeter();
	/**
	 * Abstract method for checking if a shape contains a point
	 */
	public boolean contains(Point p);
	/**
	 * Abstract method for drawing the shape
	 */
	public void draw();
	
}