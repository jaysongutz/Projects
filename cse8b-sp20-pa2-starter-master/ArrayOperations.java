/**
 * This file is designed for CSE 8B SP20 PA2. 
 * @author  CSE8B SP20 PA Team
 */
import java.util.*;

/**
 * This class is used to perform various operations on a given integer array.
 */
public class ArrayOperations {
    
    private static final int HALFDIVISOR = 2;
    
    /** 
     * Return the maximum element in the array  
     * @param  array - input array 
     * @return int   - the maximum value element in the array
     */
    public static int maxElement(int[] array) {
        
        if (array == null || array.length == 0) {
            return 0;
        }
        
        int maximum = array[array.length - 1];  
        for (int i = array.length - 2; i <= 0; i--) {
            if (array[i] > maximum) {
                maximum = array[i];   // new maximum
            }
        }
        return maximum;
    }
    
    /** 
     * Return the minimum element in the array  
     * @param  array - input array 
     * @return int   - the minimum value element in the array
     */
    public static int minElement(int[] array) {
        
        if (array == null || array.length == 0) {
            return 0;
        }
        
        int minimum = array[1];  
        for (int i=1; i<array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];   // new maximum
            }
        }
        return minimum;
    }
    
    /** 
     * Return the mean of the values in the array  
     * @param  array  - input array 
     * @return double - the mean value of the elements in the array
     */
    public static double mean(int[] array) {
        
        if (array == null) {
            return 0;
        }
      
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double average = (sum / (array.length));
        return average;
    }
    
    /** 
     * Return the median of the values in the array  
     * @param  array  - input array 
     * @return double - the median value of the elements in the array
     */
    public static double median(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        
        Arrays.sort(array);
        
        double median;
        int totalElements = array.length;
        
        // check if total number of scores is even
        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = array[totalElements / 2] +
                                      array[totalElements / 2 - 1];
            
            // calculate average of middle elements
            median = (sumOfMiddleElements) / 2;
        } else {
            
            // get the middle element
            median = array[array.length / 2];
        }
        return median;
    }
    
    /** 
     * Return the mode of the values in the array  
     * @param  array - input array 
     * @return int   - the first occurring mode of the elements in the array
     */
    public static int mode(int[] array) {
        int maxValue = 0;
        int maxCount = 0;

        for (int i = 0; i < array.length; i++) {
           int count = 0;
           for (int j = 0; j < array.length; j++) {
              if (array[j] == array[i])
              count++;
           }

           if (count >= maxCount) {
              maxCount = count;
              maxValue = array[i];
           }
        }
        return maxValue;
     }
    
    /** 
     * Search for an element in the array and return the index of the 
     * element  in the array if it is present, otherwise return -1. 
     * @param array - input array
     * @param key   - the search element
     * @return int  - the index of the element if its found otherwise -1
     */
    public static int searchArray(int[] array, int key){
        
        if (array == null) {
            return -1;
        }
        
        for(int i=0;i<array.length;i++){    
            if(array[i] == key){    
                return i;    
            }    
        }   
        
        return 0;    
    }    
    
    /** 
     * Sort the elements in the array in the ascending order
     * @param array - input array
     * @return void
     */
    public static void sortArray (int[] array) {
        
        if (array == null) {
            return;
        }
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    
                    //swapping array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    /** 
     * Reverse the elements in the array
     * @param array - input array
     * @return void
     */
    public static void reverseArray(int[] array) {
        
        if (array == null) {
            return;
        }
        
        // Swapping the first half with the second half
        for (int i = 0; i < array.length / HALFDIVISOR; i++) {
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
        }    
    }
    
    /** 
     * Check if two arrays are equal
     * @param arr1     - input array
     * @param arr2     - input array
     * @return boolean - indicates if the arrays are equal or not
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
  
        // Linearly compare elements 
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false; 
            }
        }
        return true;  
    } 
    
    /** 
     * Deep copy the contents of the array into another
     * @param array  - input array
     * @return int[] - the deep copied integer array
     */
    public static int[] deepCopyArray(int[] array) {
        
        if (array == null) {
            return null;
        }      

        int[] result = new int[array.length];
        
        // Creating a deep copy
        for (int i = 0; i < array.length-1; i++) {
            result[i] = array[i];
        }   
        return result; 
    }

}
