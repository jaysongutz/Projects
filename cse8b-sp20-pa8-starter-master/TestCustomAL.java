/**
 * This file is designed for CSE 8B SP20 PA8. 
 * 
 * @author  CSE8B SP20 PA Team
 */

/**
 * This is a class that tests the custom array list
 */
public class TestCustomAL {
    /**
     * main method to test the CustomAL class
     *
     * @param args Optional command line arguments (unused)
     */
    public static void main(String[] args) {
        
        /* Test #0
        Tests if code compiles and runs as expected!
        Uncomment the code below after implementing the following methods:
        1. CustomAL()
        
        Expected output:
        Welcome to PA8 - Creating your own Custom Array List!
        size: 0 | capacity: 10 | load: 0.0 | data: []
        */      
        
//        System.out.println("Welcome to PA8 - Creating your own "
//                + "Custom Array List!");
//        CustomAL<Integer> al = new CustomAL<Integer>();
//        al.printDetails();

        
        /* Test #1
        Uncomment the code below after implementing the following methods:
        1. CustomAL(capacity)
        2. add(item)
        3. add(pos,item)
        4. size()
        5. resize()
        6. clear()
        
        Expected output:
        
        *********** Test #1 ***********
        size: 0 | capacity: 5 | load: 0.0 | data: []
        size: 5 | capacity: 5 | load: 1.0 | data: [1, 2, 3, 4, 5]
        size: 6 | capacity: 10 | load: 0.6 | data: [1, 2, 0, 3, 4, 5]
        size: 7 | capacity: 10 | load: 0.7 | data: [42, 1, 2, 0, 3, 4, 5]
        size: 8 | capacity: 10 | load: 0.8 | data: [42, 1, 2, 0, 3, 4, 5, 7]
        size: 0 | capacity: 10 | load: 0.0 | data: []
        size: 1 | capacity: 10 | load: 0.1 | data: [11]
        */
        
//        System.out.println("\n*********** Test #1 ***********");
//        CustomAL<Integer> nums = new CustomAL<Integer>(5);
//        nums.printDetails();
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        nums.add(4);
//        nums.add(5);
//        nums.printDetails();
//        nums.add(2, 0);
//        nums.printDetails();
//        nums.add(0, 42);
//        nums.printDetails();
//        nums.add(nums.size(), 7);
//        nums.printDetails();
//        nums.clear();
//        nums.printDetails();
//        nums.add(0, 11);
//        nums.printDetails();

        
        /* Test #2
        Uncomment the code below after implementing the following methods:
        1. get(pos)
        2. indexOf(item)
        3. contains(item)
        
        Expected output:

        *********** Test #2 ***********
        size: 4 | capacity: 10 | load: 0.4 | data: [Kyle, Audrey, Terrile, Jacklyn]
        Audrey
        Jacklyn
        2
        -1
        true
        false
        */
        
//        System.out.println("\n*********** Test #2 ***********");
//        CustomAL<String> names = new CustomAL<String>();
//        names.add("Kyle");
//        names.add(1, "Audrey");
//        names.add("Terrile");
//        names.add("Jacklyn");
//        names.printDetails();
//        System.out.println(names.get(1));
//        System.out.println(names.get(names.size() - 1));
//        System.out.println(names.indexOf("Terrile"));
//        System.out.println(names.indexOf("Savera"));
//        System.out.println(names.contains("Kyle"));
//        System.out.println(names.contains("Jessica"));
        
        
        /* Test #3
        Uncomment the code below after implementing the following methods:
        1. set(index, item)
        2. remove(pos)
        3. remove(item)
        
        Expected output:

        *********** Test #3 ***********
        size: 1 | capacity: 1 | load: 1.0 | data: [3.14]
        size: 2 | capacity: 2 | load: 1.0 | data: [3.14, 1.414]
        size: 3 | capacity: 4 | load: 0.75 | data: [3.14, 1.414, 1.732]
        size: 4 | capacity: 4 | load: 1.0 | data: [3.14, 1.414, 1.732, 2.71]
        size: 4 | capacity: 4 | load: 1.0 | data: [3.14159, 1.414, 1.732, 2.71]
        size: 4 | capacity: 4 | load: 1.0 | data: [3.14159, 1.414, 1.732, 2.71828]
        size: 3 | capacity: 4 | load: 0.75 | data: [3.14159, 1.732, 2.71828]
        size: 2 | capacity: 4 | load: 0.5 | data: [3.14159, 2.71828]
        size: 3 | capacity: 10 | load: 0.3 | data: [1, 2, 3]
        size: 2 | capacity: 10 | load: 0.2 | data: [1, 3]
        size: 1 | capacity: 10 | load: 0.1 | data: [3]
        size: 0 | capacity: 10 | load: 0.0 | data: []
        */
        
//        System.out.println("\n*********** Test #3 ***********");
//        CustomAL<Double> constants = new CustomAL<>(1);
//        constants.add(3.14);
//        constants.printDetails();
//        constants.add(1.414);
//        constants.printDetails();
//        constants.add(1.732);
//        constants.printDetails();
//        constants.add(2.71);
//        constants.printDetails();
//        constants.set(0, 3.14159);
//        constants.printDetails();
//        constants.set(constants.size() - 1, 2.71828);
//        constants.printDetails();
//        constants.remove(1);
//        constants.printDetails();
//        constants.remove(1.732);
//        constants.printDetails();
//        CustomAL<Integer> myInts = new CustomAL<>();
//        myInts.add(1);
//        myInts.add(2);
//        myInts.add(3);
//        myInts.printDetails();
//        myInts.remove(1);
//        myInts.printDetails();
//        myInts.remove((Integer) 1);
//        myInts.printDetails();
//        myInts.remove((Integer) 3);
//        myInts.printDetails();
        
        
        /* Test #4
        Uncomment the code below after implementing the following methods:
        1. subList(start, end)
        2. isEmpty()
        3. equals(obj)
        
        Expected output:

        *********** Test #4 ***********
        size: 4 | capacity: 10 | load: 0.4 | data: [42, 3.14, 7, 2.71]
        size: 2 | capacity: 2 | load: 1.0 | data: [3.14, 7]
        size: 2 | capacity: 2 | load: 1.0 | data: [3.14, 14]
        size: 4 | capacity: 10 | load: 0.4 | data: [42, 3.14, 7, 2.71]
        size: 2 | capacity: 2 | load: 1.0 | data: [7, 2.71]
        size: 1 | capacity: 1 | load: 1.0 | data: [42]
        size: 0 | capacity: 0 | load: NaN | data: []
        true
        size: 4 | capacity: 10 | load: 0.4 | data: [42, 3.14, 7, 2.71]
        size: 4 | capacity: 10 | load: 0.4 | data: [42, 3.14, 7, 2.71]
        true
        false
        */

//       System.out.println("\n*********** Test #4 ***********");
//        CustomAL<Number> numbers = new CustomAL<>();
//        numbers.add(42);
//        numbers.add(3.14);
//        numbers.add(7);
//        numbers.add(2.71);
//        numbers.printDetails();
//        ListADT<Number> subList = numbers.subList(1, 3);
//        ((CustomAL) subList).printDetails();
//        subList.set(1, 14);
//        ((CustomAL) subList).printDetails();
//        numbers.printDetails();
//        subList = numbers.subList(numbers.indexOf(7), numbers.size());
//        ((CustomAL) subList).printDetails();
//        subList = numbers.subList(0, 1);
//        ((CustomAL) subList).printDetails();
//        subList = numbers.subList(0, 0);
//        ((CustomAL) subList).printDetails();
//        System.out.println(subList.isEmpty());
//        CustomAL<Number> otherNums = new CustomAL<>();
//        otherNums.add(42);
//        otherNums.add(3.14);
//        otherNums.add(7);
//        otherNums.add(2.71);
//        numbers.printDetails();
//        otherNums.printDetails();
//        System.out.println(numbers.equals(otherNums));
//        System.out.println(numbers.equals(subList)); 
        
        
        /* Test #5
       
        TODO: Implement the test cases.
        
        Write few test cases to check the exceptions thrown by each of 
        the following methods:
        1. CustomAL(capacity)
        2. add(pos, item)
        3. get(pos)
        4. remove(pos)
        5. set(index, element)
        6. subList(start, end) 
       
        Enclose each of these statements with appropriate try-catch 
        blocks. The first one has already been implemented as an example
        for you. 
        
        */
        
        try {
            CustomAL<String> employees = new CustomAL<String>(-10);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
        }
        
        try {
        	CustomAL<Integer> numbers = new CustomAL<Integer>(5);
        	numbers.add(5, 20);
        }
        catch (IndexOutOfBoundsException be) {
        	System.out.println(be.getMessage());
        }
        
        try {
        	CustomAL<String> food = new CustomAL<String>(5);
        	food.add("Pizza");
        	food.add("Burgers");
        	food.add("Tacos");
        	food.get(3);
        }
        catch (IndexOutOfBoundsException be) {
        	System.out.println(be.getMessage());
        }
        
        try {
        	CustomAL<String> food = new CustomAL<String>(5);
        	food.add("Pizza");
        	food.add("Burgers");
        	food.add("Tacos");
        	food.remove(3);
        }
        catch (IndexOutOfBoundsException be) {
        	System.out.println(be.getMessage());
        }
        
        try {
        	CustomAL<Integer> salary = new CustomAL<Integer>();
        	salary.add(20000);
        	salary.add(480200);
        	salary.add(42370);
        	salary.set(3, 52370);
        }
        catch (IndexOutOfBoundsException be) {
        	System.out.println(be.getMessage());
        }
        
        try {
		    CustomAL<String> friends = new CustomAL<String>();
		    friends.add("Jerry");
		    friends.add("Kyle");
		    friends.add("Marie");
		    friends.subList(2, 4);
		    friends.subList(2, 0);
        }
        catch (IllegalArgumentException ie) {
        	System.out.println(ie.getMessage());
        }
        catch (IndexOutOfBoundsException be) {
        	System.out.println(be.getMessage());
        }
    }
}