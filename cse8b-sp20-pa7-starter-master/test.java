import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;
import java.io.*;
class test {
//		MovieRatingsPredictor test = new MovieRatingsPredictor();
//		ArrayList<ArrayList<String>> testread = test.readReviewsFromFile("rawReviewRatings.txt");
////		Iterator<ArrayList<String>> it = testread.iterator();
////		for (int i = 0; i < testread.size(); i++) {
////			for (int j = 0; j < testread.get(i).size(); j++) {
////				System.out.print(testread.get(i).get(j) + " ");
////			}
////			System.out.println();
////		}
//		int count = test.fillStopWords("stopwords.txt");
//		ArrayList<ArrayList<String>> testremovestopwords = test.removeStopWords(testread);
////		System.out.println(testremovestopwords.size());
////		System.out.println(testremovestopwords);
//		test.updateHashMap(testremovestopwords);
////		System.out.println(test.wordValue.keySet());
////		for (Integer[] obj: test.wordValue.values()) {
////			System.out.print(obj[0]+", " + obj[1]);
////			System.out.println();
////		}
//		test.writeReviewsToFile(test.readReviewsFromFile("rawReviewRatings.txt"), "output.txt");
//		
////		for (int i = 0; i < testremovestopwords.size(); i++) {
////			for (int j = 0; j < testremovestopwords.get(i).size(); j++) {
////				System.out.print(testremovestopwords.get(i).get(j) + " ");
////			}
////			System.out.println();
////		}
	public static void main(String[] args) {
        try {
            foo();
        } catch (Exception e) {
            System.out.println("Exception caught!");
        }
    }
    public static void foo() throws MyException {
        throw new MyException();
    }
		
	
}
class MyException extends Exception {
    public MyException() {
        super();
    }
}