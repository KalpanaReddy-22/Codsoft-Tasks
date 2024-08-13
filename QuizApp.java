import java.util.*;

public class QuizApp {
    static class Question {
        String questionText;
        String[] options;
        int correctAnswerIndex;

        public Question(String questionText, String[] options, int correctAnswerIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Question[] questions = new Question[] {
                new Question("What is the capital of France?",
                        new String[] { "1) Paris", "2) London", "3) Rome", "4) Berlin" }, 1),
                new Question("Which planet is known as the Red Planet?",
                        new String[] { "1) Earth", "2) Mars", "3) Jupiter", "4) Venus" }, 2),
                new Question("What is the largest mammal?",
                        new String[] { "1) Elephant", "2) Blue Whale", "3) Great White Shark", "4) Giraffe" }, 2)
        };

        int score = 0;
        int questionTimeLimit = 10;

        for (Question q : questions) {
            System.out.println(q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();
            System.out.print("Your answer (1-4): ");
            int answer = -1;
            boolean answeredInTime = true;

            while (true) {
                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();
                    break;
                } else if (System.currentTimeMillis() - startTime > questionTimeLimit * 1000) {
                    System.out.println("Time's up!");
                    answeredInTime = false;
                    break;
                } else {
                    System.out.println("Please enter a valid number between 1 and 4:");
                    scanner.next();
                }
            }

            if (answeredInTime && answer == q.correctAnswerIndex) {
                score++;
                System.out.println("Correct!");
            } else if (answeredInTime) {
                System.out.println("Wrong! The correct answer was option " + q.correctAnswerIndex);
            }
            System.out.println();
        }

        System.out.println("Quiz finished!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
    }
}
