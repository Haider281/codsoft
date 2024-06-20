import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalAttempts = 0;
        
        System.out.println("Welcome to the 'Guess the Number' game!");

        while (true) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 10;
            boolean userGuessedCorrectly = false;
            
            System.out.println("\nNew round! I have picked a number between 1 and 100. You have 10 attempts to guess it.");
            
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (Attempts left: " + attemptsLeft + "): ");
                int guess = scanner.nextInt();
                totalAttempts++;
                attemptsLeft--;
                
                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number correctly!");
                    userGuessedCorrectly = true;
                    break;
                }
            }
            
            rounds++;
            
            if (!userGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine();  // Consume the newline
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame over! You played " + rounds + " rounds with a total of " + totalAttempts + " attempts.");
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
