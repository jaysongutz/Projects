///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              GradeReport
// Files:              StudentGrades.csv LetterGrades.csv
// Quarter:            (course) Spring 2020
//
// Author:             Jayson Gutierrez
// Email:              jmgutier@ucsd.edu
// Instructor's Name:  Adalbert Gerald Soosai Raj
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
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


	import java.io.File;
    import java.util.Scanner;
    import java.io.PrintWriter;
    import java.io.*;
    
    /**
     * This class is intended to create a new file, from an input file that 
     * contains students grades from assignments, with the averages and 
     * letter grades that the students received
     *
     * Bugs: (a list of bugs and other problems)
     *
     * @author Jayson Gutierrez
     */
    
    public class GradeReport {

    
    // Sample Constants
    // MARKER constants are the positions that the assignments begin at in the 
    // string array for each line
    public static final int NUM_RQ = 16;    
    public static final int RQ_PTS_POSS = 3;
    public static final int RQ_MARKER = 1 + NUM_RQ;
    public static final int NUM_PA = 8;
    public static final int PA_MARKER = RQ_MARKER + NUM_PA;   
    public static final int PA_PTS_POSS = 100;
    public static final int NUM_EXAM = 8;  
    public static final int EXAM_MARKER = PA_MARKER + NUM_EXAM;
    public static final int EXAM_PTS_POSS = 100;
    public static final int NUM_NAME = 1;
    public static final int NAME_MARKER = NUM_NAME;
    public static final int PRJ_PTS_POSS = 100;
    public static final int TOTAL_GRADES = 33;
    public static final int RQ_PERCENT = 16;
    public static final int PA_PERCENT = 40;
    public static final int EXAM_PERCENT = 32;
    public static final int PRJ_PERCENT = 12;
    public static final int TOTAL_PERCENT = 100;
    public static final int NUM_ARGS = 2;

    /** 
     * Main method that reads the input file and outputs the 
     * corresponding letter grade into an output file
     * @param  arrgs[0] - input file
     * @param  arrgs[1] - output file
     * @return void
     */
    
    			;
    
    public static void main(String[] args) throws FileNotFoundException {
    			//checks to see if the amount of arguments input
    			if (args.length != NUM_ARGS) {
    				System.out.println("USAGE: java GradeReport <InputFile.csv>"
    								   + " <OutputFile.csv>");
    				return;
    			}
	    		File inFile = new File (args[0]);
	    		File outFile = new File(args[1]);
	    		Scanner scanner = new Scanner(inFile);
	    		PrintWriter writer = new PrintWriter(outFile);    		
	    		String name = "";
	    		double rqTotal = 0;
	    		double paTotal = 0;
	    		double examTotal = 0;
	    		String[] firstLine = scanner.nextLine().split(",");
	    		writer.println("Name,AvgRQ,AvgPA,AvgExam,AvgProject,"
	    				       + "TotalPoints,LetterGrade");
	    		while (scanner.hasNextLine() == true) {
	    			String[] currLine = scanner.nextLine().split(",");
	    			name = currLine[0];
	    			//iterates through the entry to get the total points
	    			//in each category
	    			for (int i = 1; i < currLine.length; i++) {
    				if (i < RQ_MARKER) {
    					rqTotal += Double.parseDouble(currLine[i]);
    				}
    				else if (i < PA_MARKER && i >= RQ_MARKER) {
    					paTotal += Double.parseDouble(currLine[i]);
    				}
    				else if (i < EXAM_MARKER && i >= PA_MARKER){
    					examTotal += Double.parseDouble(currLine[i]);
    				}
    			}
    			double avgRQ = computeAverage(rqTotal, NUM_RQ, RQ_PTS_POSS);
    			double avgPA = computeAverage(paTotal, NUM_PA, PA_PTS_POSS);
    			double avgEXAM = computeAverage(examTotal, NUM_EXAM, 
    					                        EXAM_PTS_POSS);
    			double avgPRJ = Double.parseDouble(currLine
    			                                   [currLine.length- 1]);
    			double totalPts = ((avgRQ * RQ_PERCENT) + (avgPA * PA_PERCENT) + 
    							  (avgEXAM * EXAM_PERCENT) + 
    							  (avgPRJ * PRJ_PERCENT))/TOTAL_PERCENT;    		
    			String entry = 	name + "," + Math.round(avgRQ) + "," +
    							Math.round(avgPA) + "," + Math.round(avgEXAM) + 
    							"," +
    							Math.round(avgPRJ) + "," + Math.round(totalPts) 
    							+  "," +
    							computeLetterGrades(totalPts);
    			writer.println(entry);
    			name = "";
    			rqTotal = 0;
    			paTotal = 0;
    			examTotal = 0;
    			avgPRJ = 0;
    			}
	    		writer.close();
	    		scanner.close();
    }
    
    /**
     * This method computes the average of the total points that an individual
     * received in a category of an assignment
     *
     * @param double total total points that a student received
     * @param int num  number of assignments of a category
     * @param int maxMarks number of marks possible for assignment
     * @return returns the average of the points received per assignment
     */
    
    public static double computeAverage(double total, int num, int maxMarks) {
    	return total/(num * maxMarks) * 100;
    }

    /**
     * This method finds the letter grade that represents the amount of points
     * an individual receives
     *
     * @param double totalPoints is the totalPoints out of 100 a student received
     * @return returns the string of the letter grade that the student received
     */
    
    public static String computeLetterGrades(double totalPoints) {
    	int percent = (int) Math.round(totalPoints);
    	if (percent >= 0 && percent < 60) {return "F";}
    	else if (percent < 70) {return "D";}
    	else if (percent < 73) {return "C-";}
    	else if (percent < 77) {return "C";}
    	else if (percent < 80) {return "C+";}
    	else if (percent < 83) {return "B-";}
    	else if (percent < 87) {return "B";}
    	else if (percent < 90) {return "B+";}
    	else if (percent < 93) {return "A-";}    
    	else if (percent < 97) {return "A";}
    	else  {return "A+";}
    
    }
}
