import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.print("How many grades will you enter? ");
        int numGrades = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter the grades (A, B, C, D, E, F):");
        
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            String grade = scanner.nextLine().toUpperCase();
            
       
            int score = convertGradeToScore(grade);
            
            if (score == -1) {
                System.out.println("Invalid grade entered! Please enter A, B, C, D, E, or F.");
                i--; // Retry 
            } else {
                scores.add(score);
            }
        }

     
        if (!scores.isEmpty()) {
            int highest = Collections.max(scores);
            int lowest = Collections.min(scores);
            double average = scores.stream().mapToInt(Integer::intValue).average().orElse(0.0);

            System.out.println("\nResults:");
            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);
            System.out.println("Average Score: " + average);
        }

        scanner.close();
    }


    public static int convertGradeToScore(String grade) {
        switch (grade) {
            case "A": return 90;
            case "B": return 80;
            case "C": return 70;
            case "D": return 60;
            case "E": return 50;
            case "F": return 40;
            default: return -1; 
        }
    }
}
