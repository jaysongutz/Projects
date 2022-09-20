///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    LargeInteger.java
// File:               LargeIntegerJava.java
// Quarter:            (course) Spring 2020
//
// Author:             Jayson Gutierrez
// Instructor's Name:  Adalbert Gerald Soosaj Raj
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
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
import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

import java.util.Arrays;

import org.junit.Test;

/**
 * This is the JUNIT tester class to test the LargeInteger class.
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
public class LargeIntegerTester {

    @Test
    public void testConstructor() {

        // Testing constructing positive integer
        LargeInteger num1 = new LargeInteger("50");
        int expectedSign1 = 1;
        int[] expectedMag1 = {5, 0};
        assertArrayEquals(expectedMag1, num1.getMagnitude());
        assertEquals(expectedSign1, num1.getSign());

        // Testing constructing negative integer
        LargeInteger num2 = new LargeInteger("-50");
        int expectedSign2 = -1;
        int[] expectedMag2 = {5, 0};
        assertArrayEquals(expectedMag2, num2.getMagnitude());
        assertEquals(expectedSign2, num2.getSign());

        // Testing constructing zero
        LargeInteger num3 = new LargeInteger("0");
        int expectedSign3 = 0;
        int[] expectedMag3 = {0};
        assertArrayEquals(expectedMag3, num3.getMagnitude());
        assertEquals(expectedSign3, num3.getSign());

    }

    @Test
    public void testDeepCopyConstructor() {    	
    	
        LargeInteger num = new LargeInteger("5");
        LargeInteger numCopy = new LargeInteger(num);
        assertArrayEquals(num.magnitude, numCopy.magnitude);
        assertEquals(num.sign, numCopy.sign);
        
        LargeInteger num1 = new LargeInteger("1231232131321");
        LargeInteger numCopy1 = new LargeInteger(num1);
        assertArrayEquals(num1.magnitude, numCopy1.magnitude);
        assertEquals(num1.sign, numCopy1.sign);
        
        LargeInteger num2 = new LargeInteger("0");
        LargeInteger numCopy2 = new LargeInteger(num2);
        assertArrayEquals(num2.magnitude, numCopy2.magnitude);
        assertEquals(num2.sign, numCopy2.sign);
    }

    @Test
    public void testGetSign() {
        int expectedSign = -1;
        LargeInteger num = new LargeInteger("-20");
        assertEquals(expectedSign, num.sign);
        
        int expectedSign1 = 0;
        LargeInteger num1 = new LargeInteger("0");
        assertEquals(expectedSign1, num1.sign);
        
        int expectedSign2 = 1;
        LargeInteger num2 = new LargeInteger("2");
        assertEquals(expectedSign2, num2.sign);
    }

    @Test
    public void testGetMagnitude() {
        LargeInteger num = new LargeInteger("12345");
        int[] expectedNum = {1,2,3,4,5};
        assertArrayEquals(num.magnitude, expectedNum);
        
        LargeInteger num1 = new LargeInteger("-123");
        int[] expectedNum1 = {1,2,3};
        assertArrayEquals(num1.magnitude, expectedNum1);
        
        LargeInteger num2 = new LargeInteger("0");
        int[] expectedNum2 = {0};
        assertArrayEquals(num2.magnitude, expectedNum2);
    }

    @Test
    public void testToString() {
        LargeInteger num = new LargeInteger("-12345");
        String expectedStr = "-12345";
        assertEquals(expectedStr, num.toString());
        
        LargeInteger num1 = new LargeInteger("0");
        String expectedStr1 = "0";
        assertEquals(expectedStr1, num1.toString());
        
        LargeInteger num2 = new LargeInteger("55");
        String expectedStr2 = "55";
        assertEquals(expectedStr2, num2.toString());
    }

    @Test
    public void testEquals() {
        LargeInteger num = new LargeInteger("123");
        LargeInteger expectedNum = new LargeInteger("123");
        assertEquals(num.equals(expectedNum), true);
        
        LargeInteger num1 = new LargeInteger("0");
        LargeInteger expectedNum1 = new LargeInteger(num1);
        assertEquals(num1.equals(expectedNum1), true);
        
        LargeInteger num2 = new LargeInteger("-9");
        LargeInteger expectedNum2 = new LargeInteger("-90");
        assertEquals(num2.equals(expectedNum2), false);
    }

    @Test
    public void testMultiply10() {
        LargeInteger num = new LargeInteger("123");
        int[] expectedNum = {1,2,3,0};
        assertArrayEquals(num.multiply10().magnitude, expectedNum);
        
        LargeInteger num1 = new LargeInteger("-20");
        int[] expectedNum1 = {2,0,0};
        assertArrayEquals(num1.multiply10().magnitude, expectedNum1);
        
        LargeInteger num2 = new LargeInteger("0");
        int[] expectedNum2 = {0};
        assertArrayEquals(num2.multiply10().magnitude, expectedNum2);
    }

    @Test
    public void testDivide10() {
        LargeInteger num = new LargeInteger("123");
        int[] expectedNum = {1,2};
        assertArrayEquals(num.divide10().magnitude, expectedNum);
        
        LargeInteger num1 = new LargeInteger("0");
        int[] expectedNum1 = {0};
        assertArrayEquals(num1.divide10().magnitude, expectedNum1);
        
        LargeInteger num2 = new LargeInteger("1");
        int[] expectedNum2 = {0};
        assertArrayEquals(num2.divide10().magnitude, expectedNum2);
    }

    @Test
    public void testIsEven() {
        LargeInteger num = new LargeInteger("-123");
        boolean expectedBool = false;
        assertEquals(num.isEven(), expectedBool);
        
        LargeInteger num1 = new LargeInteger("2");
        boolean expectedBool1 = true;
        assertEquals(num1.isEven(), expectedBool1);
        
        LargeInteger num2 = new LargeInteger("0");
        boolean expectedBool2 = true;
        assertEquals(num2.isEven(), expectedBool2);
    }

    @Test
    public void testNegate() {
    	LargeInteger num = new LargeInteger("0");
    	int expectedNum = 0;
    	assertEquals(num.negate().sign, expectedNum);
    	
    	LargeInteger num1 = new LargeInteger("1");
    	int expectedNum1 = -1;
    	assertEquals(num1.negate().sign, expectedNum1);
    	
    	LargeInteger num2 = new LargeInteger("-42");
    	int expectedNum2 = 1;
    	assertEquals(num2.negate().sign, expectedNum2);
    }

    @Test
    public void testCompare() {
        LargeInteger num1 = new LargeInteger("123");
        LargeInteger num2 = new LargeInteger("456");
        int numExpected = -1;
        assertEquals(num1.compare(num2), numExpected);
        
        LargeInteger num3 = new LargeInteger("0");
        LargeInteger num4 = new LargeInteger(num3);;
        int numExpected1 = 0;
        assertEquals(num3.compare(num4), numExpected1);
        
        LargeInteger num5 = new LargeInteger("2");
        LargeInteger num6 = new LargeInteger("1");
        int numExpected2 = 1;
        assertEquals(num5.compare(num6), numExpected2);
    }

    @Test
    public void testAdd() {
        // Adding two positive numbers
        LargeInteger num1 = new LargeInteger("50");
        LargeInteger num2 = new LargeInteger("500");
        LargeInteger expected1 = new LargeInteger("550");
        LargeInteger actual1 = LargeInteger.add(num1, num2);
        assertEquals(expected1.toString(), actual1.toString());

        // Adding a positive and negative number
        LargeInteger num3 = new LargeInteger("-500");
        LargeInteger expected2 = new LargeInteger("0");
        LargeInteger actual2 = LargeInteger.add(num2, num3);
        assertEquals(expected2.toString(), actual2.toString());

        // Adding two negative numbers
        LargeInteger num4 = new LargeInteger("-40");
        LargeInteger expected3 = new LargeInteger("-540");
        LargeInteger actual3 = LargeInteger.add(num3, num4);
        assertEquals(expected3.toString(), actual3.toString());
    }

    @Test
    public void testSubtract() {
        // Subtracting two positive numbers
        LargeInteger num1 = new LargeInteger("50");
        LargeInteger num2 = new LargeInteger("500");
        LargeInteger expected1 = new LargeInteger("-450");
        LargeInteger actual1 = LargeInteger.subtract(num1, num2);
        assertEquals(expected1.toString(), actual1.toString());

        // Subtracting a positive and negative number
        LargeInteger num3 = new LargeInteger("-500");
        LargeInteger expected2 = new LargeInteger("1000");
        LargeInteger actual2 = LargeInteger.subtract(num2, num3);
        assertEquals(expected2.toString(), actual2.toString());

        // Subtracting two negative numbers
        LargeInteger num4 = new LargeInteger("-40");
        LargeInteger expected3 = new LargeInteger("-460");
        LargeInteger actual3 = LargeInteger.subtract(num3, num4);
        assertEquals(expected3.toString(), actual3.toString());
    }

    @Test
    public void testModulus() {
        LargeInteger num0 = new LargeInteger("50");

        // Testing a case when modulus is zero
        LargeInteger num1 = new LargeInteger("50");
        LargeInteger expected1 = new LargeInteger("0");
        LargeInteger actual1 = num0.modulus(num1);
        assertEquals(expected1.toString(), actual1.toString());

        // Testing a case when modulus is non-zero
        LargeInteger num2 = new LargeInteger("43");
        LargeInteger expected2 = new LargeInteger("7");
        LargeInteger actual2 = num0.modulus(num2);
        assertEquals(expected2.toString(), actual2.toString());

        LargeInteger negNum0 = new LargeInteger("-50");

        // Testing a case when modulus is zero
        LargeInteger negNum1 = new LargeInteger("50");
        LargeInteger expected3 = new LargeInteger("0");
        LargeInteger actual3 = negNum0.modulus(negNum1);
        assertEquals(expected3.toString(), actual3.toString());

        // Testing a case when modulus is non-zero
        LargeInteger negNum2 = new LargeInteger("-43");
        LargeInteger expected4 = new LargeInteger("-7");
        LargeInteger actual4 = negNum0.modulus(negNum2);
        assertEquals(expected4.toString(), actual4.toString());
    }
}
