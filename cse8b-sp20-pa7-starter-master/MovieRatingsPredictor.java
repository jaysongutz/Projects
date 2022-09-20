///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Jayson Gutierrez
// Files:              (list of source files)
// Quarter:            (course) Spring 2020
//
// Author:             Jayson Gutierrez
// Email:              jmgutier@ucsd.edu
// Instructor's Name:  Adalbert Gerald Soosai Raj
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
// Online sources:   https://www.java67.com/2018/12/how-to-remove-objects-or-
//					 elements-while-iterating-Arraylist-java.html
//					 I used the above link to help my logic in the 
//					 removeStopWords method 
//////////////////////////// 80 columns wide //////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;

/**
 * This class represents a movie rating predictor.
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
public class MovieRatingsPredictor {

    HashMap<String, Integer[]> wordValue;
    HashSet<String> stopWords;
    public static final int DEFAULT_RATING = 2;
    public static final int SUM_RATING_POS = 0;
    public static final int SUM_COUNT_POS = 1;

    /**
     * No-Args Constructor for a MovieRatingsPredictor
     */
    public MovieRatingsPredictor() {
    this.wordValue = new HashMap<String, Integer[]>();
    this.stopWords = new HashSet<String>();	
    }

    /**
     * Obtains the unique stop words from stopWordsFile and adds it to the set
     *
     * @param stopWordsFile A file name that contains the stop words
     * @return The number of unique stop words added to the set
     * @throws FileNotFoundException
     */
    public int fillStopWords(String stopWordsFile)
            throws FileNotFoundException {
    	if (stopWordsFile == null || stopWordsFile.length() == 0) {
    		return 0;
    	}
    	File inFile = new File(stopWordsFile);
    	if (inFile.length() == 0) {
    		return 0;
    	}
    	Scanner scanner = new Scanner(inFile);
    	int count = 0;
    	while (scanner.hasNext()) {
    		String stopWord = scanner.next();
//    		Checks to see if the token passed in from scanner is already in 
//    		this.stopWords HashSet
    		if (!this.stopWords.contains(stopWord)) {
    			this.stopWords.add(stopWord);
    			count++;
    		}
    	}
    	scanner.close();
    	return count;
    }

    /**
     * Reads the reviews in reviewsFile and stores them into an
     * ArrayList<ArrayList <String>>
     *
     * @param reviewsFile The file name that contains the reviews
     * @return ArrayList representation of the reviews
     * @throws FileNotFoundException
     */
    public ArrayList<ArrayList<String>> readReviewsFromFile(
            String reviewsFile) throws FileNotFoundException {
    try {
    	if (reviewsFile == null || reviewsFile.length() == 0) {
    		throw new FileNotFoundException();
    	}
//    	ArrayList storing all of the lines of reviews of the input file
	    ArrayList<ArrayList<String>> fileArray = 
	    								new ArrayList<ArrayList<String>>();
		File inFile = new File(reviewsFile);
		if (inFile.length() == 0) {
			throw new FileNotFoundException();
		}
		Scanner scanner = new Scanner(inFile);
//		Scans through the input file at each line, breaks up each line from the 
//		white spaces, and makes all characters in each line lowercase
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().toLowerCase();
			String[] lineSplit = line.split(" ");
//			ArrayList to store each word in eachh review as a string
			ArrayList<String> lineArrList = new ArrayList<String>();
			for (int i = 0; i < lineSplit.length; i++) {
				lineArrList.add(lineSplit[i]);
			}
//			Adds the line of the review in the ArrayList of Strings to fileArray
			fileArray.add(lineArrList);
		}
		scanner.close();
	    return fileArray;
    }
    catch (FileNotFoundException e)  {
    	return new ArrayList<ArrayList<String>>();
    }
    }

    /**
     * Removes the stop words from the ArrayList of reviews.
     *
     * @param rawData the ArrayList representation of reviews
     * @return ArrayList representation of reviews with stop words removed
     */
    public ArrayList<ArrayList<String>> removeStopWords(
            ArrayList<ArrayList<String>> rawData) {
	for (ArrayList<String> line: rawData) {
		Iterator<String> itr = line.iterator();
		while (itr.hasNext()) {
			String word = itr.next();
//			Checks to see if a word in rawData exists in this.stopWords and 
//			removes it
			if (this.stopWords.contains(word)) {
				itr.remove();
			}
		}
	}
    return rawData;
    }
    
    /**
     * Populates the wordValue HashMap with key String and Integer[] with
     * the format [totalRating, count].
     *
     * @param cleanReviewRatings ArrayList representation of reviews
     * @return The number of words (with value) in the wordValue HashMap
     */
    public int updateHashMap(ArrayList<ArrayList<String>> cleanReviewRatings) {
	int count = 0;
//	This for loop checks to see if a word in a review is in the wordValue
//	HashMapif not then adds it to the HashMap with initial rating  
//	and count values of 0 
   	for (ArrayList<String> line: cleanReviewRatings) {
    	for (int i = 1; i < line.size(); i++) {
   			if (!this.wordValue.containsKey(line.get(i))) {
   				Integer[] val = new Integer[2];
   				val[SUM_RATING_POS] = 0;
   				val[SUM_COUNT_POS] = 0;
   				this.wordValue.put(line.get(i), val);
   				count++;
   			}
   		}
   	}
//	This for loop get's the count of each word that appears in the review and 
//	sums up the total ratings that each word is associated with then stores the
//	data in the HashMap this.wordValue
   	for (ArrayList<String> line: cleanReviewRatings) {
   		for (int i = 1; i < line.size(); i++) {
   			if (this.wordValue.containsKey(line.get(i))) {
   				Integer[] keyVal = this.wordValue.get(line.get(i));
    			keyVal[SUM_RATING_POS] = Integer.parseInt(line.get(0)) +
    									 keyVal[0];
    			keyVal[SUM_COUNT_POS]++;
    		}
   		}
   	}
    return count;
    }

    /**
     * Rates each review and adds the rating at the beginning of the ArrayList
     *
     * @param cleanReviews ArrayList representation of reviews
     * @return ArrayList representation of reviews with ratings
     */
    public ArrayList<ArrayList<String>> rateReviews(
            ArrayList<ArrayList<String>> cleanReviews) {
	if (cleanReviews == null) {
		return null;
	}
	if (cleanReviews.size() == 0) {
		return new ArrayList<ArrayList<String>>();
	}
//	ArrayList to store the reviews with their calculated ratings
	ArrayList<ArrayList<String>> ratedReviews =
								 new ArrayList<ArrayList<String>>();    	
	for (ArrayList<String> line: cleanReviews) {
//		sumAvg holds the sum of the average of each word in a line
		float sumAvg = 0;
		for (String word: line) {
			if (this.wordValue.containsKey(word)) {
//		Calculates what the average of a word is and adds it to sumAvg
				Integer[] wordVal = this.wordValue.get(word);
				float sumRating = wordVal[SUM_RATING_POS];
				float sumCount = wordVal[SUM_COUNT_POS];
				float wordAvg = sumRating/sumCount;
				sumAvg += wordAvg;
			}
			else {
				sumAvg += DEFAULT_RATING;
			}
		}
//		Calculates the average rating of a line
		int avgRev = Math.round(sumAvg/line.size());
//		Line to store the new review with the rating and add it to ratedReviews
		ArrayList<String> newLine = new ArrayList<String>();
		newLine.add(Integer.toString(avgRev));
		for (String word: line) {
			newLine.add(word);
		}
		ratedReviews.add(newLine);
	}    	
    return ratedReviews;
    }

    /**
     * Writes reviews to a file
     *
     * @param cleanReviewsWithRatings The ArrayList representation of reviews
     * @param outputFile The file to write to
     * @return The number of reviews with ratings written to the file
     * @throws FileNotFoundException
     */
    public int writeReviewsToFile(
            ArrayList<ArrayList<String>> cleanReviewsWithRatings,
            String outputFile) throws FileNotFoundException {
	if (cleanReviewsWithRatings == null ||
		cleanReviewsWithRatings.size() == 0) {
		return 0;
	}
	if (outputFile == null || outputFile.length() == 0) {
		return 0;
	}
	int linecount = 0;
	File outFile = new File(outputFile);
	PrintWriter writer = new PrintWriter(outFile);
//	This for loop writes each line into the outFile using PrintWriter 
	for (ArrayList<String> line: cleanReviewsWithRatings) {
		for (int i = 0; i < line.size() - 1; i++) {
			writer.print(line.get(i) + " ");
		}
		writer.print(line.get(line.size()-1));
		writer.println();
		linecount++;
	}
	writer.close();
    return linecount;
    }
}
