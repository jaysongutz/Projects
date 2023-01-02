///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    Drakiro
// File:               Fighter
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
 * This is an abstract class that defines the different fields of a fighter
 * as well as the different setters and getter methods to access each fighter's
 * fields
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author Jayson Gutierrez
 */
abstract class Fighter implements Moves{
	
	String name; 
	boolean isAlive;
	int health;
	int mana;
	int speed;
	int atkRate;
	int atkMana;
	int manaRate;
	int recoverRate;
	int ultRate;
	int ultManaRate;
	private static final int MAX_HEALTH = 100;
	private static final int MAX_MANA = 100;
	private static final int MAX_SPEED = 100;
	private static final int MIN_HEALTH = 1;
	private static final int MIN_MANA = 1;
	private static final int MIN_SPEED = 1;
	
	/**
	 * Constructor for a fighter
	 */
	public Fighter(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the maximum possible health
	 */
	public static int getMaxHealth() {
		return MAX_HEALTH;
	}
	
	/**
	 * Gets the maximum possible mana
	 */
	public static int getMaxMana() {
		return MAX_MANA;
	}
	
	/**
	 * Gets the maximum possible speed
	 */
	public static int getMaxSpeed() {
		return MAX_SPEED;
	}
	
	/**
	 * Gets the minimum possible health
	 */
	public static int getMinHealth() {
		return MIN_HEALTH;
	}
	
	/**
	 * Gets the minimum possible mana
	 */
	public static int getMinMana() {
		return MIN_MANA;
	}
	
	/**
	 * Gets the minimum possible speed
	 */
	public static int getMinSpeed() {
		return MIN_SPEED;
	}
	
	/**
	 * Assigns this fighter's health to an integer value
	 * 
	 * @param int health, integer representing the fighter's health
	 */
	public void setHealth(int health) {
		if (!(health <= MAX_HEALTH && health >= MIN_HEALTH)) {
			throw new IllegalArgumentException(
					"IllegalArgumentException caused by: " + health);
		}
		else {
			this.health = health;
		}
	}
	
	/**
	 * Gets this fighter's health
	 *
	 * @return this fighter's health or -1 if it hasn't been assigned
	 */
	public int getHealth() {
		if (this.health == 0) {
			System.out.println("Health hasn't been assigned.");
			return -1;
		}
		else {
			return this.health;
		}
	}
	
	/**
	 * Assigns this fighter's mana to an integer value
	 * 
	 * @param int mana, integer representing the fighter's mana
	 */
	public void setMana(int mana) {
		if (!(mana <= MAX_MANA && mana >= MIN_MANA)) {
			throw new IllegalArgumentException(
					"IllegalArgumentException caused by: " + mana);
		}
		else {
			this.mana = mana;
		}
	}
	
	/**
	 * Gets this fighter's mana
	 *
	 * @return this fighter's mana or -1 if it hasn't been assigned
	 */
	public int getMana() {
		if (this.mana == 0) {
			System.out.println("Mana hasn't been assigned.");
			return -1;
		}
		else {
			return this.mana;
		}
	}
	
	/**
	 * Assigns this fighter's speed to an integer value
	 * 
	 * @param int speed, integer representing the fighter's speed
	 */
	public void setSpeed(int speed) {
		if (!(speed <= MAX_SPEED && mana >= MIN_SPEED)) {
			throw new IllegalArgumentException(
					"IllegalArgumentException caused by: " + speed);
		}
		else {
			this.speed = speed;
		}
	}
	
	/**
	 * Gets this fighter's speed
	 *
	 * @return this fighter's speed or -1 if it hasn't been assigned
	 */
	public int getSpeed() {
		if (this.speed == 0) {
			System.out.println("Speed hasn't been assigned.");
			return -1;
		}
		else {
			return this.speed;
		}
	}
	
	/**
	 * Makes sure that this fighter's health is never above 100
	 */
	public void checkHealth() {
		if (this.health > MAX_HEALTH) {
			this.health = MAX_HEALTH;
		}
	}
	
	/**
	 * Makes sure that this fighter's mana is never above 100
	 */
	public void checkMana() {
		if (this.mana > MAX_MANA) {
			this.mana = MAX_MANA;
		}
	}
	
	/**
	 * Makes sure that this fighter's is alive or not
	 */
	public boolean checkAlive() {
		if (this.health <= 0) {
			this.isAlive = false;
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Increases the fighter's mana, called very turn
	 */
	abstract void recoverMana();
	
	/**
	 * Overrides the toString method for Fighter
	 * 
	 * @return The fighter's name, health, mana, and speed
	 */
	public String toString() {
		return "Name : " + this.name + "| Health: " + this.health + " | Mana: "
			   + this.mana + " | Speed: " + this.speed;
	}
}