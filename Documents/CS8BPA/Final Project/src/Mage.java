///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    Drakiro
// File:               Mage
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
 * This is a specialized child class of fighter that defines the specific traits
 * of the Mage role
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author Jayson Gutierrez
 */
class Mage extends Fighter {
	
	private static final int DEFAULT_SPEED = 40;
	private static final int DEFAULT_ATK = 7;
	private static final int DEFAULT_ATKMANA = 10;
	private static final int DEFAULT_MANAREC = 18;
	private static final int DEFAULT_RECOVER = 20;
	private static final int DEFAULT_ULTRATE = 40;
	private static final int DEFAULT_ULTMANA = 60;
	
	/**
	 * Constructor for Mage
	 */
	public Mage() {
		super("Mage");
		this.isAlive = true;
		this.health = super.getMaxHealth();
		this.mana = super.getMaxMana();
		this.speed = DEFAULT_SPEED;
		this.atkRate = DEFAULT_ATK;
		this.atkMana = DEFAULT_ATKMANA;
		this.manaRate = DEFAULT_MANAREC;
		this.recoverRate = DEFAULT_RECOVER;
		this.ultRate = DEFAULT_ULTRATE;
		this.ultManaRate = DEFAULT_ULTMANA;
	}
	
	/**
	 * Attack move for Mage
	 */
	public void attack(Fighter enemy) {
		if (this.mana >= DEFAULT_ATKMANA) {
			System.out.println(this.name + " attacked " + enemy.name + "!");
			enemy.health -= this.atkRate;
			this.mana -= this.atkMana;
		}
		else {
			System.out.println(this.name + " can't attack, too low on mana!");
		}
	}
	
	/**
	 * Recover move for Mage
	 */
	public void recover() {
		System.out.println(this.name + " recovered!");
		this.health += this.recoverRate;
		this.checkHealth();
	}
	
	/**
	 * Ultimate move for Mage
	 */
	public void ultimate(Fighter enemy) {
		if (this.mana >= DEFAULT_ULTMANA) {
			System.out.println(this.name + " used their ultimate on "
							   + enemy.name + "!");
			enemy.health -= this.ultRate;
			this.mana -= this.ultManaRate;
		}
		else {
			System.out.println(this.name + " can't ultimate, too low on mana!");
		}
		
	}
	
	/**
	 * Increases Mage's mana
	 */
	public void recoverMana() {
		this.mana += this.manaRate;
		this.checkMana();
	}
}