// Dawson Sallee
// Assignment 2
// COP 3330

import java.util.Scanner;

public class EsportsAnalyze {

    /**
     * The main entry point of the program. It handles the user input loop,
     * collects all the scores, and then prints a final performance analysis.
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {

        //Initialize a scanner to input user feedback
        Scanner scanner = new Scanner(System.in);

        //Initialize variables for tracking
        double totalSum = 0; // The totalSum of all valid scores entered.
        int scoreCount = 0; // The scoreCount (number of valid scores entered).
        int highestScore = -1; // The highestScore encountered so far.
        int masterTierCount = 0; // The masterTierCount (number of scores meeting the "Master" tier threshold, e.g., 700 or higher). We will include any tiers above master in this tally.

        while(true) {

            System.out.print("Enter match score (or -1 to finish): ");
            int currentScore = scanner.nextInt(); // If currentScore == -1, then the user queries terminate. Else, add it as a score

            if (currentScore == -1) {
                break;
            }

            totalSum += currentScore; // total sum of all the scores for every game
            scoreCount += 1; // total amount of games played

            highestScore = EsportsAnalyze.updateHighestScore(highestScore, currentScore);

            if (EsportsAnalyze.isMasterTier(currentScore)) {
                masterTierCount += 1;
            }
        }

        System.out.println("\n--- Performance Analysis ---");

        System.out.printf("Total Matches Played:\t\t %d\n", scoreCount);
        System.out.printf("Average Score:\t\t\t %.2f\n", EsportsAnalyze.calculateAverageScore(totalSum, scoreCount));
        System.out.printf("Best Match Score:\t\t %d\n", highestScore);
        System.out.printf("Number of Master Tier Matches:\t %d\n", masterTierCount);

        scanner.close();
    }
    
    /**
     * Calculates the average of all entered scores.
     * @param sum   The total sum of all scores.
     * @param count The number of scores entered.
     * @return The calculated average, or 0.0 if no scores were entered.
     */
    public static double calculateAverageScore(double sum, double count) {

        if (count == 0) {

            return 0;

        } else {

            double averageScore = sum / count; 
            return averageScore;
        }
    }


    /**
     * Compares the current highest score with a new score and returns the larger value.
     * @param currentHighest The highest score seen so far.
     * @param newScore       The new score to compare against.
     * @return The new highest score.
     */
    public static int updateHighestScore(int currentHighest, int newScore) {
        
        return Math.max(currentHighest, newScore);

    }


    /**
     * Checks if a given score qualifies for the "Master" tier (700 or above).
     * @param score The score to check.
     * @return true if the score is 700 or higher, otherwise false.
     */
    public static boolean isMasterTier(int score) {
        if (score >= 700) {

            return true;

        } else {

            return false;

        }
    }


    /**
     * Assigns a rank tier (e.g., "Legendary", "Master") based on the score.
     * @param score The score to assign a rank to.
     * @return A String representing the rank tier.
     */
    public static String assignRankTier(int score) {

        if (score >= 900) {

            return "Legendary";
            
        } else if (score >= 700) {

            return "Master";

        } else if (score >= 500) {

            return "Diamond";
        
        } else if (score >= 300) {

            return "Gold";

        } else {

            return "Bronze";
        }
    }
}