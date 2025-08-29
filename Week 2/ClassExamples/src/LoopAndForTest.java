//imports
import java.util.Scanner;

public class LoopAndForTest {
	
	public static void main(String[] args) {
		// Variables
		Scanner input = new Scanner(System.in);
		int numTests, sum = 0;
		double average;
		
		// Poll the user for some number of scores
		System.out.print("How many scores are you entering?: ");
		numTests = input.nextInt();
		System.out.flush();
		
		System.out.println("Please enter " + numTests + " scores:");
		int[] scores = new int[numTests];
		for(int i = 0; i < numTests; i++) {
			scores[i] = input.nextInt();
		}
		
		for(int score : scores) { 
			sum += score;
			System.out.println("This score is " + score);
			
			//Note that this will not change the value in the array, just this shallow copy
			//primitives 
			score += 5;
		}
		
		
		System.out.println(scores);
		
		
		
		
		
		// int temp[10]; - C array
		// int* temp = (int*) malloc(sizeof(int) * numTests);
		// int[] scores = new int[numTests]; - Java array declaration
		input.close();
		
	}
	public void gradeTest() {
		Scanner input = new Scanner(System.in);
		int numTests, sum = 0, lastScore;
		double average;
		
		// Poll the user for some number of scores
		System.out.print("How many scores are you entering?: ");
		numTests = input.nextInt();
		System.out.flush();
		
		// Poll the user for numTests scores.
		System.out.println("Please enter " + numTests + " scores:");
		for(int i = 0; i < numTests; i++) {
			lastScore = input.nextInt();
			sum += lastScore;
		}

		// Calculate the average score
		average = (double) sum/numTests;
		char grade = ' ';
		// Output the letter grade for the score
		if (average >= 90) {
			grade = 'A';
		} else if (average >= 80) {
			grade = 'B';
		} else if (average >= 70) {
			grade = 'C';
		} else if (average >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.println("The average score is " + average
				+ " and the letter grade is " + grade);
		
		input.close();
	}
}
