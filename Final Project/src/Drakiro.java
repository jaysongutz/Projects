///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Drakiro
// Files:              Moves, Fighter, Ninja, Brawler, Mage
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
 * This is the main class of Drakiro that carries out the encounter and
 * different aspects of the game that are necessary
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author Jayson gutierrez
 */
import java.io.*;
import java.util.*;
class Drakiro {
	
	private static final String encounterBorder = "****************************"
											+ "*******************************";
	public static Fighter user;
	public static Fighter enemy;
	public static final Scanner scanner = new Scanner(System.in);
	public static boolean gameState;
	
	/**
	 * Carries out the main functions of the game itself
	 */
	public static void main(String[] args) {
		
		gameIntro();
		
		//Carries out assigning the user's role
		while (user == null) {
			try {
				String fighterChoice = scanner.next().trim();
				if (fighterArray().containsKey(fighterChoice)) {
					user = fighterArray().get(fighterChoice);
				}
				else {
					throw new IllegalArgumentException("Not a fighter, "
													   + "try again!");
				}
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//Assigns the enemy to a random role
		enemy = randomEnemy();
		encounter(user, enemy);
	}
	
	/**
	 * The method that carries out the encounter between the user and enemy
	 *
	 * @param Fighter user, the Fighter object that represents the user
	 * @param Fighter enemy, the Fighter object that represents the enemy
	 */
	public static void encounter(Fighter user, Fighter enemy) {
		//Displays the user's fighter and the enemy's fighter
		System.out.println(encounterBorder + "\nUser = " + user.toString());
		System.out.println("Enemy = " + enemy.toString() + "\n" 
						   + encounterBorder);
		
		ArrayList<String> moves = moveArray();
		
		//Checks if the user is alive and the enemy is alive
		while (user.checkAlive() == true && enemy.checkAlive() == true)	{
			try {
				encounterHeader(user, enemy);
				String userIn = scanner.next().trim();
				System.out.println(encounterBorder);
				
				//Carries out the move corresponding to the user's input
				if (moves.contains(userIn)) {
					if (userIn.equals("attack")) {
						if (user.speed > enemy.speed) {
							user.attack(enemy);
							if(enemy.checkAlive() == false) {
								scanner.close();
								break;
							}
							enemy.enemyMove(user);
							user.recoverMana();
							enemy.recoverMana();
						}
						else {
							enemy.enemyMove(user);
							if(user.checkAlive() == false) {
								scanner.close();
								break;
							}
							user.attack(enemy);
							user.recoverMana();
							enemy.recoverMana();
						}
					}
					else if (userIn.equals("ultimate")) {
						if (user.speed > enemy.speed) {
							user.ultimate(enemy);
							if(enemy.checkAlive() == false) {
								scanner.close();
								break;
							}
							enemy.enemyMove(user);
							user.recoverMana();
							enemy.recoverMana();
						}
						else {
							enemy.enemyMove(user);
							if(user.checkAlive() == false) {
								scanner.close();
								break;
							}
							user.ultimate(enemy);
							user.recoverMana();
							enemy.recoverMana();
						}
					}
					else if(userIn.equals("recover")) {
						if (user.speed > enemy.speed) {
							user.recover();
							enemy.enemyMove(user);
							if(user.checkAlive() == false) {
								scanner.close();
								break;
							}
							user.recoverMana();
							enemy.recoverMana();
						}
						else {
							enemy.enemyMove(user);
							if(enemy.checkAlive() == false) {
								scanner.close();
								break;
							}
							user.recover();
							user.recoverMana();
							enemy.recoverMana();
						}
					}
				}
				else if (userIn.equals("help")) {
					helpMove();
				}
				//If the user doesn't enter a move, throws an
				//IllegalArgumentException
				else {
					throw new IllegalArgumentException("Invalid input,"
							+ " type help if you need help!");
				}
			}
			catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
				helpMove();
			}
		}
		checkEnd(user, enemy);
	}
	
	/**
	 * This method checks whether the user or the enemy has won the encounter
	 *
	 * @param Fighter user, the Fighter object that represents the user
	 * @param Fighter enemy, the Fighter object that represents the enemy
	 */
	public static void checkEnd(Fighter user, Fighter enemy) {
		System.out.println(encounterBorder + "\nThe encounter has ended!");
		if (user.checkAlive() == true) {
			System.out.println(enemy.name + " has died!");
			System.out.println("You have won the encounter!\n" +
							   encounterBorder);
		}
		else {
			System.out.println(user.name + " has died!");
			System.out.println("You have lost the encounter!\n" +
							   encounterBorder);
		}
	}
	
	/**
	 * Displays a message to help the user understand what they can do during
	 * their turn during an encounter
	 */
	public static void helpMove() {
		System.out.println("Make sure when you type in your move you "
				+ "type the move exactly how it is!");
		System.out.println("If you want to use your ultimate make sure you type"
				+ " in 'ultimate' \nspecifically with no capitalization and"
				+ " then press enter!");
	}
	
	/**
	 * Displays a message giving the user an introduction to the game
	 */
	public static void gameIntro() {
		System.out.println(encounterBorder);
		System.out.println("Welcome to Drakiro made by Jayson Gutierrez!\n");
		System.out.println("This is a turn based game with three classes:\n"
				+ "Brawler, Ninja, and Mage\n\nFirst type in the class you want"
				+ " to choose and make sure\nto capitalize the first letter\n"
				+ "After you choose you character you will be put up against\n"
				+ "an enemy of a random class and the encounter will begin\n\n"
				+ "Once the encounter begins you will have to type either\n"
				+ "attack, ultimate, or recover\nAttack is the basic damage"
				+ " move of each class\nUltimate is the special move of each "
				+ "class\nAnd each class has the ability to recover health"
				+ " with\nthe Recover ability\nAlso, each move costs mana "
				+ "except for recover\n\nThat's all you need to know now "
				+ "choose your character");
		System.out.println(encounterBorder);
	}
	
	/**
	 * The message displayed each turn during the encounter
	 *
	 * @param Fighter user, the Fighter object that represents the user
	 * @param Fighter enemy, the Fighter object that represents the enemy
	 */
	public static void encounterHeader(Fighter user, Fighter enemy) {
		System.out.println(encounterBorder);
		System.out.println("What would you like to do this turn?");
		System.out.println("Type attack, ultimate, or recover");
		System.out.println("User HP: " + user.health + " | Enemy HP: "
				+ enemy.health);
		System.out.println("User Mana: " + user.mana + " | Enemy"
				+ " Mana: " + enemy.mana);
		System.out.println(encounterBorder);
	}
	
	/**
	 * Creates an array that stores the moves a fighter can use
	 */
	public static ArrayList<String> moveArray() {
		ArrayList<String> moves = new ArrayList<String>();
		moves.add("attack");
		moves.add("ultimate");
		moves.add("recover");
		return moves;
	}
	
	/**
	 * Creates an array that stores the different roles a fighter can be
	 */
	public static HashMap<String, Fighter> fighterArray() {
		HashMap<String, Fighter> fighters = new HashMap<String, Fighter>();
		fighters.put("Ninja", new Ninja());
		fighters.put("Brawler", new Brawler());
		fighters.put("Mage", new Mage());
		return fighters;
	}
	
	/**
	 * Generates an enemy of a random role
	 */
	public static Fighter randomEnemy() {
		//Gets the String keys of the fighters in fighterArray()'s return
		Object[] fighterValues = fighterArray().values().toArray();
		//Type casts a random index of fightervalues to a Fighter
		return (Fighter) 
			   fighterValues[(new Random()).nextInt(fighterValues.length)];
	}
}