///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    (name of main application class)
// File:               (name of this class's file)
// Quarter:            (course) Spring 2020
//
// Author:             (your name and email address)
// Instructor's Name:  (name of your instructor)
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
        // remove this line when you add test case(s).
        fail("No test cases.");
    }

    @Test
    public void testGetSign() {
        // remove this line when you add test case(s).
        fail("No test cases.");
    }

    @Test
    public void testGetMagnitude() {
        // remove this line when you add test case(s).
        fail("No test cases.");
    }

    @Test
    public void testToString() {
        // remove this line when you add test case(s).
        fail("No test cases.");
    }

    @Test
    public void testEquals() {
        // remove this line when you add test case(s).
        fail("No test cases.");
    }

    @Test
    public void testMultiply10() {
        // remove this line when you add test case(s).
        fail("No test cases.");
    }

    @Test
    public void testDivide10() {
        // remove this line when you add test case(s).
        fail("No test cases.");
    }

    @Test
    public void testIsEven() {
        // remove this line when you add test case(s).
        fail("No test cases.");
    }

    @Test
    public void testNegate() {
        // remove this line when you add test case(s).
        fail("No test cases.");
    }

    @Test
    public void testCompare() {
        // remove this line when you add test case(s).
        fail("No test cases.");
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