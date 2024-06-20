import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the number of grades
        System.out.print("Enter the number of grades: ");
        int numberOfGrades = scanner.nextInt();

        // Array to store grades
        double[] grades = new double[numberOfGrades];

        // Input each grade
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        // Calculate the average grade
        double averageGrade = calculateAverage(grades);

        // Display the average grade
        System.out.printf("The average grade is: %.2f%n", averageGrade);

        scanner.close();
    }

    // Method to calculate the average of an array of grades
    public static double calculateAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
}
