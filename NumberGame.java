import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNumber = 1;
        int maxNumber = 100;
        int attemptsLimit = 5;
        int rounds = 0;
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            rounds++;
            int generatedNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            System.out.println("Round " + rounds + ": Guess the number between " + minNumber + " and " + maxNumber);

            boolean guessedCorrectly = false;
            for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
                System.out.print("Attempt " + attempts + "/" + attemptsLimit + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed it right in " + attempts + " attempts.");
                    score += attemptsLimit - attempts + 1;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the number. It was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over!");
        System.out.println("You played " + rounds + " rounds.");
        System.out.println("Your total score is: " + score);

        scanner.close();
    }
}