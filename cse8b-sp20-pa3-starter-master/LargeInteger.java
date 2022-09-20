///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              LargeInteger
// Files:              LargeIntegerTester.java
// Quarter:            (course) Spring 2020
//
// Author:             Jayson Gutierrez
// Email:              jmgutier@ucsd.edu
// Instructor's Name:  Adalbert Gerald Soosaj Raj
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS
//                   ALLOWED
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
 * This class represents an integer that can store values beyond the range
 * of values that int can. This class contains methods to perform integer
 * operations on these LargeInteger objects.
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
public class LargeInteger {

    // DO NOT UPDATE ANY OF THE INSTANCE VARIABLES BELOW!
    int sign; // -1 for negative, 0 for zero, +1 for positive numbers
    int[] magnitude; // array representation of digits

    /**
     * Constructor for Large Integer
     *
     * @param numStr String representation of a large integer
     */
    public LargeInteger(String numStr) {
        if (numStr.charAt(0) == '0') {
        	this.sign = 0;
        	this.magnitude = new int [1];
        	this.magnitude[0] = 0;
        }
        else if (numStr.charAt(0) == '-') {
        	this.sign = -1;
        	this.magnitude = new int[numStr.length() - 1];
        	for (int i = 0; i < numStr.length() - 1; i++) {
        		this.magnitude[i] = numStr.charAt(i + 1) - 48;
        	}
        }
        else {
        	this.sign = 1;
        	this.magnitude = new int[numStr.length()];
        	for (int i = 0; i < numStr.length(); i++) {
        		this.magnitude[i] = numStr.charAt(i) - 48;
        	}
        }
    }

    /**
     * Constructor for deep copy of LargeInteger
     *
     * @param otherNum The LargeInteger to copy from
     */
    public LargeInteger(LargeInteger otherNum) {
        this.sign = otherNum.sign;
        this.magnitude = new int[otherNum.magnitude.length];
        for (int i = 0; i < otherNum.magnitude.length; i++) {
        	this.magnitude[i] = otherNum.magnitude[i];
        }
    }

    /**
     * Getter for sign
     *
     * @return the sign value of this LargeInteger
     */
    public int getSign() {
        
        return this.sign;
    }

    /**
     * Getter for Magnitude
     *
     * @return the magnitude value of this LargeInteger
     */
    public int[] getMagnitude() {
        
        return this.magnitude;
    }

    /**
     * Checks if LargeInteger is Even
     *
     * @return true if LargeInteger is even, false otherwise
     */
    public boolean isEven() {
        String numStr = "";
        //creates a string of the elements in magnitude
        for (int i = 0; i < this.magnitude.length; i++) {
        	numStr += this.magnitude[i];
        }
        int numInt = Integer.parseInt(numStr);
        if (numInt % 2 == 0) {
        	return true;
        }
        else {
        	return false;
        }
    }

    /**
     * Negates this LargeInteger. Does not negate if value of 0.
     *
     * @return a new LargeInteger representing the negated version of this
     */
    public LargeInteger negate() {
    	if (this.magnitude[0] == 0) {
    		return this;
    	}
        if (this.sign == -1) {
        	this.sign = 1;
        }
        else {
        	this.sign = -1;
        }
        return this;
    }

    /**
     * ToString method to print LargeInteger
     * return A string representation of LargeInteger
     */
    @Override
    public String toString() {
        String numStr =  "";
        if (this.sign == -1) {
        	numStr += "-";
        }
        //creates a string of the elements in magnitude
        for (int i = 0; i < this.magnitude.length; i++) {
        	numStr += this.magnitude[i];
        }
        return numStr;
    }

    /**
     * Compares LargeInteger to Object
     *
     * @param obj The object to compare with
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
        	return true;
        }
        if (!(obj instanceof LargeInteger)) {
        	return false;
        }
        LargeInteger inObj = (LargeInteger) obj;
        if (inObj.magnitude.length != this.magnitude.length) {
        	return false;
        }
        for (int i = 0; i < inObj.magnitude.length; i++) {
        	if (this.magnitude[i] != inObj.magnitude[i]) {
        		return false;
        	}
        }
        return this.sign == inObj.sign ;
    }

    /**
     * Multiples this LargeInteger by 10
     *
     * @return a new LargeInteger representing this*10
     */
    public LargeInteger multiply10() {
    	if (this.magnitude[0] == 0) {
    		return this;
    	}
        int[] newMag = new int[this.magnitude.length + 1];
        for (int i = 0; i < this.magnitude.length; i++) {
        	newMag[i] = this.magnitude[i];
        }
        this.magnitude = new int[newMag.length];
        for (int i = 0; i < newMag.length; i++) {
        	this.magnitude[i] = newMag[i];
        }
        return this;
    }

    /**
     * divides this LargeInteger by 10
     *
     * @return a new LargeInteger with value this/10
     */
    public LargeInteger divide10() {
    	if (this.magnitude[0] == 0) {
    		return this;
    	}
    	if (this.magnitude.length == 1) {
    		this.magnitude[0] = 0;
    		return this;
    	}
    	int[] newMag = new int[this.magnitude.length - 1];
        for (int i = 0; i < this.magnitude.length - 1; i++) {
        	newMag[i] = this.magnitude[i];
        }
        this.magnitude = new int[newMag.length];
        for (int i = 0; i < newMag.length; i++) {
        	this.magnitude[i] = newMag[i];
        } 
        return this;
    }

    /**
     * Compares this LargeInteger and otherNum LargeInteger
     * and returns 1,0, or -1 depending on which number is larger
     *
     * @param otherNum The other LargeInteger to compare to
     * @return 1 if this LargeInteger is larger than other LargeInteger,
     *         -1 if smaller, 0 if equal
     */
    public int compare(LargeInteger otherNum) {
        String thisStr = this.toString();
        String otherStr = otherNum.toString();
        int thisInt = Integer.parseInt(thisStr);
        int otherInt = Integer.parseInt(otherStr);
        if (thisInt == otherInt) {
        	return 0;
        }
        else if (thisInt > otherInt) {
        	return 1;
        }
        else {
        	return -1;
        }
    }

    /*
     * Methods add, substract, and modulus are optional.
     * You can earn Star Points by completing these methods!
     */

    /**
     * Adds the left and right values together
     *
     * @param left one of the LargeIntegers to add
     * @param right one of the LargeIntegers to add
     * @return a LargeInteger representing the sum of left and right
     */
    public static LargeInteger add(LargeInteger left, LargeInteger right) {
    	String leftStr = left.toString();
    	String rightStr = right.toString();
    	int leftInt = Integer.parseInt(leftStr);
    	int rightInt = Integer.parseInt(rightStr);
    	int result = leftInt + rightInt;
    	LargeInteger newLrgInt = new LargeInteger(Integer.toString(result));
        return newLrgInt;
    }

    /**
     * Subtracts the left and right values together
     *
     * @param left one of the LargeIntegers to subtract from
     * @param right one of the LargeIntegers to subtract to
     * @return a LargeInteger representing the difference of left - right
     */
    public static LargeInteger subtract(LargeInteger left,
                                        LargeInteger right) {
    	String leftStr = left.toString();
    	String rightStr = right.toString();
    	int leftInt = Integer.parseInt(leftStr);
    	int rightInt = Integer.parseInt(rightStr);
    	int result = leftInt - rightInt;
    	LargeInteger newLrgInt = new LargeInteger(Integer.toString(result));
    	return newLrgInt;
    }

    /**
     * Performs the modulus operation on this and otherNum
     *
     * @param otherNum the number to mod by
     * @return the LargeInteger representation of this mod otherNum
     */
    public LargeInteger modulus(LargeInteger otherNum) {
    	String numStr = this.toString();
    	String modStr = otherNum.toString();
    	int numInt = Integer.parseInt(numStr);
    	int modInt = Integer.parseInt(modStr);
    	int result = numInt % modInt;
    	LargeInteger newLrgInt = new LargeInteger(Integer.toString(result));
        return newLrgInt;
    }

    /**
     * Main method for this class
     *
     * @param args command line arguments are unused
     */
    public static void main(String[] args) {

        /* Main test #1
         Uncomment the code below after implementing the following methods:
         1. LargeInteger(String num) - parameterized constructor
         2. getSign()
         3. getMagnitude()

         Expected output:
         num1.getSign() = 1
         num1.getMagnitude() = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4]
         */
        // LargeInteger num1 = new LargeInteger("1234567890987654");
        // System.out.println("num1.getSign() = " + num1.getSign());
        // System.out.println("num1.getMagnitude() = "
        //     + Arrays.toString(num1.getMagnitude()));

        /* Main test #2
         Uncomment the code below after implementing the following methods:
         1. toString()
         2. isEven()
         3. negate()

         Expected output:
         num2 = -9876543210
         num2.isEven() = true
         num2.negate() = 9876543210
         */
        // LargeInteger num2 = new LargeInteger("-9876543210");
        // System.out.println("num2 = " + num2);
        // System.out.println("num2.isEven() = " + num2.isEven());
        // System.out.println("num2.negate() = " + num2.negate());

        /* Main test #3
         Uncomment the code below after implementing the following methods:
         1. LargeInteger(LargeInteger otherNum) - copy constructor
         2. multiply10()
         3. divide10()

         Expected output:
         num3 = 3141592653590
         num4 = 31415926535
         */
         // LargeInteger num3 = new LargeInteger("314159265359");
         // LargeInteger num4 = new LargeInteger(num3);
         // num3 = num3.multiply10();
         // num4 = num4.divide10();
         // System.out.println("num3 = " + num3);
         // System.out.println("num4 = " + num4);

         /* Main test #4
          Uncomment the code below after implementing the following methods:
          1. equals()
          2. compare()

          Expected output:
          num5.equals(num8) = true
          num5.equals(num7) = false
          num5.compare(num6) = 1
          num7.compare(num6) = -1
          num5.compare(num8) = 0
          */
          // LargeInteger num5 = new LargeInteger("1");
          // LargeInteger num6 = new LargeInteger("0");
          // LargeInteger num7 = new LargeInteger("-1");
          // LargeInteger num8 = new LargeInteger(num5);
          // System.out.println("num5.equals(num8) = " + num5.equals(num8));
          // System.out.println("num5.equals(num7) = " + num5.equals(num7));
          // System.out.println("num5.compare(num6) = " + num5.compare(num6));
          // System.out.println("num7.compare(num6) = " + num7.compare(num6));
          // System.out.println("num5.compare(num8) = " + num5.compare(num8));

          // Add additional tests below to test add, substract, and modulus
          // if you implemented them.
    }

}
