// Dawson Sallee
// Assignment 2
// COP 3330

import java.util.Scanner;

public class EsportsAnalyze {
    public static void main(String[] args) {

        //Initialize a scanner to input user feedback
        Scanner scanner = new Scanner(System.in);

        //Initialize variables for tracking
        double totalSum = 0;
        int scoreCount = 0;
        int highestScore = -1;
        int masterTierCount = 0;

        while(true) {

            System.out.print("Enter match score (or -1 to finish): ");
            int currentScore = scanner.nextInt(); // If currentScore == -1, then the user queries terminate. Else, add it as a score;

            if (currentScore == -1) {
                break;
            }

            totalSum += currentScore;
            scoreCount += 1;

            highestScore = EsportsAnalyze.updateHighestScore(highestScore, currentScore);

            if (EsportsAnalyze.isMasterTier(currentScore)) {
                masterTierCount += 1;
            }
        }

        System.out.print("");
        System.out.println("--- Performance Analysis ---");

        System.out.printf("Total Matches Played:\t\t %d\n", scoreCount);
        System.out.printf("Average Score:\t\t\t %.2f\n", EsportsAnalyze.calculateAverageScore(totalSum, scoreCount));
        System.out.printf("Best Match Score:\t\t %d\n", highestScore);
        System.out.printf("Number of Master Tier Matches:\t %d\n", masterTierCount);

        scanner.close();
    }
    
    public static double calculateAverageScore(double sum, double count) {

        if (count == 0) {

            return 0;

        } else {

            double averageScore = sum / count; 
            return averageScore;
        }
    }

    public static int updateHighestScore(int currentHighest, int newScore) {

        if (currentHighest > newScore) {

            return currentHighest;

        } else {

            return newScore;
        }
    }

    public static boolean isMasterTier(int score) {
        if (score >= 700) {

            return true;

        } else {

            return false;

        }
    }

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