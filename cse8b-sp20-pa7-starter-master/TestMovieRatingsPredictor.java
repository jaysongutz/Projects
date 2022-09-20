import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Contains the main to test the Movie Rating Predictor program
 *
 * @author CSE8B SP20 PA Team
 */
public class TestMovieRatingsPredictor {

    public static final String STOP_WORDS_FILE = "stopwords.txt";
    public static final String RAW_REVIEWS_RATING_FILE
            = "rawReviewRatings.txt";
    public static final String RAW_REVIEWS_FILE = "rawReviews.txt";
    public static final String OUTPUT_FILE = "cleanReviewsWithRatings.txt";

    public static final String STOP_WORDS_HEADER =
            "Number of Unique Stop Words = ";
    public static final String RAW_REVIEWS_RATING_HEADER =
            "Raw Review Ratings = ";
    public static final String CLEAN_REVIEW_RATINGS_HEADER
            = "Clean Review Ratings = ";
    public static final String HASHMAP_HEADER = "Stop words = ";
    public static final String RAW_REVIEWS_HEADER = "Raw Reviews = ";
    public static final String CLEAN_REVIEWS_HEADER = "Clean Reviews = ";
    public static final String CLEAN_REVIEWS_WITH_RATINGS_HEADER =
            "Clean Reviews with Ratings = ";
    public static final String REVIEWS_WRITTEN_HEADER =
            "Number of Reviews Written = ";

    /**
     * The main for the movie ratings predictor program
     *
     * @param args command-line arguments no used
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        MovieRatingsPredictor predictor = new MovieRatingsPredictor();

        int numStopWords = predictor.fillStopWords(STOP_WORDS_FILE);
        System.out.println(STOP_WORDS_HEADER + numStopWords);

        ArrayList<ArrayList<String>> rawReviewRatings
            = predictor.readReviewsFromFile(RAW_REVIEWS_RATING_FILE);
        System.out.println(
                RAW_REVIEWS_RATING_HEADER + rawReviewRatings.toString());

        ArrayList<ArrayList<String>> cleanReviewRatings
            = predictor.removeStopWords(rawReviewRatings);
        System.out.println(
                CLEAN_REVIEW_RATINGS_HEADER + cleanReviewRatings.toString());

        int numWordValues = predictor.updateHashMap(cleanReviewRatings);
        System.out.println(HASHMAP_HEADER + numWordValues);

        ArrayList<ArrayList<String>> rawReviews
            = predictor.readReviewsFromFile(RAW_REVIEWS_FILE);
        System.out.println(RAW_REVIEWS_HEADER + rawReviews.toString());

        ArrayList<ArrayList<String>> cleanReviews
            = predictor.removeStopWords(rawReviews);
        System.out.println(CLEAN_REVIEWS_HEADER + cleanReviews.toString());

        ArrayList<ArrayList<String>> cleanReviewsWithRatings
                = predictor.rateReviews(cleanReviews);
        System.out.println(
                CLEAN_REVIEWS_WITH_RATINGS_HEADER
                + cleanReviewsWithRatings.toString());

        int numReviewsWritten = predictor.writeReviewsToFile(
                cleanReviewsWithRatings, OUTPUT_FILE);
        System.out.println(REVIEWS_WRITTEN_HEADER + numReviewsWritten);
    }
}
