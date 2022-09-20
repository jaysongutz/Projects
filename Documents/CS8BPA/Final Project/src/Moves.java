///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    Drakiro
// File:               Moves
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
 * This is an interface that defines the moves that each fighter can carry out
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author Jayson Gutierrez
 */
import java.util.*;

interface Moves {
	
	/**
	 * The movement defining a fighter's attack
	 */
	public void attack(Fighter enemy);
	
	/**
	 *The movement defining a fighter's recover
	 */
	public void recover();
	
	/**
	 *The movement defining a fighter's ultimate
	 */
	public void ultimate(Fighter enemy);
	
	/**
	 * Generates a random move that an enemy uses
	 *
	 * @param Fighter user, passes in a fighter for the move to be used on
	 */
	default void enemyMove(Fighter user) {
		ArrayList<String> moves = new ArrayList<String>();
		moves.add("attack");
		moves.add("ultimate");
		moves.add("recover");
		
		//Generates a random integer less than the size of moves
		int moveInt = (new Random()).nextInt(moves.size());
		String move = moves.get(moveInt);
		if (move.equals("attack")) {
			this.attack(user);
		} 
		else if (move.equals("ultimate")) {
			this.ultimate(user);
		}
		else if (move.equals("recover")) {
			this.recover();
		}
	}
	
}