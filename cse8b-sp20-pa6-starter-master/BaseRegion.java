///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              BaseRegion
// Files:              Region.java Point.java 
//					   Circle.java Rectangle.java 
//					   IntersectRegion.java UnionRegion.java
//					   SubtractRegion.java NegateRegion.java
// Quarter:            (course) Spring 2020
//
// Author:             Jayson Gutierrez
// Email:              jmgutier@ucsd.edu
// Instructor's Name:  Adalbert Gerald Soosai Raj
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
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
/**
 * This file is designed for CSE 8B SP20 PA6. 
 * 
 * @author  CSE8B SP20 PA Team
 */

/**
 * This is an abstract class that defines the Base region
 */
public abstract class BaseRegion implements Region {
    
    String name;
    char[][] grid; // 32*32
    
    public static final int ROWS = 32;
    public static final int COLS = 32;
    
    /**
     * No parameter constructor for BaseRegion
     * 
     */
    public BaseRegion() {
        this.name = "BaseRegion";
        grid = new char[ROWS][COLS];
    }
    
    /**
     * Method to get the name of BaseRegion
     * 
     * @return the name of the BaseRegion
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method to get the area of BaseRegion
     * 
     * @return the area of the BaseRegion
     */
    public double getArea() {
        return 0;
    }
    
    /**
     * Method to get the perimeter of BaseRegion
     * 
     * @return the perimeter of the BaseRegion
     */
    public double getPerimeter() {
        return 0;
    }
    
    /**
     * Method to determine whether a given point lies within
     * the BaseRegion
     * 
     * @param p the Point to be checked 
     * @return  true if the point lies within the BaseRegion,
     *          false otherwise
     */
    public abstract boolean contains(Point p);
    
    /**
     * Method to draw the region onto the console
     * 
     */
    public void draw() {
        for (int i = 0; i < this.grid.length; i++) {
        	for (int j = 0; j < this.grid[i].length; j++) {
        		System.out.print(grid[i][j]);
        	}
        	System.out.println();
        }
    }
    
    /**
     * Method to print the details of the BaseRegion
     */
    public void printDetails() {
        System.out.println("name: " + this.name);
    }
    
    /**
     * Method to fill in the grid variable with X or .
     */
    public void fillGrid() {
        for (int i = 0; i < this.grid.length; i++) {
        	for (int j = 0; j < this.grid[i].length; j++) {
//        		checks to see if a point on the grid lies within the region
        		if (this.contains(new Point(j, i))) {
        			this.grid[i][j] = 'X';
        		}
        		else {
        			this.grid[i][j] = '.';
        		}
        	}
        }
    }
}
