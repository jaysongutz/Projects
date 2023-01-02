///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    ArrayOperatins.java
// File:               ArrayOperationsTester
// Quarter:            (course) Spring 2020
//
// Author:             Jayson Gutierrez
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

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class is intended to test the methods of ArrayOperations.java
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author Jayson Gutierrez
 */

public class ArrayOperationsTester {
	
	/**
	 *This method tests maxElement in ArrayOperations
	 */
	
    @Test
    public void testMaxElement() {
        int[] array = {3, 2, 1};
        int maxExpected = 3;
        int maxActual = ArrayOperations.maxElement(array);
        assertEquals(maxExpected, maxActual);
    }
    
    /**
	 *This method tests minElement in ArrayOperations
	 */
    
    @Test
    public void testMinElement() {
        int[] array = {1,2,3};
        int minExpected = 1; 
        int minActual = ArrayOperations.minElement(array);
        assertEquals(minExpected, minActual);
    }
    
    /**
	 *This method tests mean in ArrayOperations
	 */
    
    @Test
    public void testMean() {
        int[] array = new int[0];
        double meanExpected = 0;
        double meanActual = ArrayOperations.mean(array);
        assertEquals(meanExpected, meanActual, .001);
    }
    
    /**
	 *This method tests median in ArrayOperations
	 */
    
    @Test
    public void testMedian() {
        int[] array = {1,2,3,4,5,6};
        double medianExpected = 3.5;
        double medianActual = ArrayOperations.median(array);
        assertEquals(medianExpected, medianActual, .001);
    }
    
    /**
	 *This method tests mode in ArrayOperations
	 */
    
    @Test
    public void testMode() {
        int[] array = {1,2,2,2,3,3,3,4};
        int modeExpected = 2;
        int modeActual = ArrayOperations.mode(array);
        assertEquals(modeExpected, modeActual);
    }
    
    /**
	 *This method tests searchArray in ArrayOperations
	 */
    
    @Test
    public void testSearchArray() {
        int[] array = {1,2,3,4,5};
        int valExpected = -1;
        int valActual = ArrayOperations.searchArray(array, 10);
        assertEquals(valExpected, valActual);
    }
    
    /**
	 *This method tests sortArray in ArrayOperations
	 */
    
    @Test
    public void testSortArray() {
    	int[] array = {6,1,2,3,4,5,1};
    	int[] arrayExpected = {1,1,2,3,4,5,6};
    	ArrayOperations.sortArray(array);
    	for (int i = 0; i < array.length; i++) {
    		assertEquals(array[i], arrayExpected[i]);
    	}
    }
    
    /**
	 *This method tests reverseArray in ArrayOperations
	 */
    
    @Test
    public void testReverseArray() {
    	int[] array = {1,2,3,4,5};
    	int[] arrayExpected = {5,4,3,2,1};
    	ArrayOperations.reverseArray(array);
    	for (int i = 0; i < array.length; i++) {
    		assertEquals(array[i], arrayExpected[i]);
    	}
    }
    
    /**
	 *This method tests isEqual in ArrayOperations
	 */
    
    @Test
    public void testIsEqual() {
    	int[] array1 = {1,2,3,4,5};
    	int[] array2 = {1,2,3,4,5,6,7};
    	boolean expectedVal = false;
    	boolean actualVal = ArrayOperations.isEqual(array1, array2);
    	assertEquals(expectedVal, actualVal);
    }
    
    /**
	 *This method tests deepCopyArray in ArrayOperations
	 */
    
    @Test
    public void testDeepCopyArray() {
    	int[] array = {1,2,3};
    	int[] expectedArray = {1,2,3};
    	int[] actualArray = ArrayOperations.deepCopyArray(array);
    	for (int i = 0; i < expectedArray.length; i++) {
    		assertEquals(expectedArray[i], actualArray[i]);
    	}
    }
    
}
