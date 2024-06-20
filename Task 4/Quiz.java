import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private List<Question> questions;
    private int score;
    private Scanner scanner;
    private Timer timer;
    private boolean timeUp;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
        this.scanner = new Scanner(System.in);
        this.timer = new Timer();
        this.timeUp = false;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        for (Question question : questions) {
            askQuestion(question);
        }
        showResults();
    }

    private void askQuestion(Question question) {
        System.out.println("\n" + question.getQuestionText());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;
                System.out.println("\nTime's up!");
            }
        }, 10000); // 10 seconds timer for each question

        int selectedOptionIndex = -1;
        while (!timeUp) {
            if (scanner.hasNextInt()) {
                selectedOptionIndex = scanner.nextInt() - 1;
                break;
            } else {
                scanner.next();
                System.out.println("Please enter a valid option number.");
            }
        }

        timer.cancel();
        timer = new Timer();
        timeUp = false;

        if (selectedOptionIndex == -1 || !question.isCorrect(selectedOptionIndex)) {
            System.out.println("Incorrect answer.");
        } else {
            System.out.println("Correct answer!");
            score++;
        }
    }

    private void showResults() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score is: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Sample questions
        quiz.addQuestion(new Question("What is the capital of France?", Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), 2));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?", Arrays.asList("Earth", "Mars", "Jupiter", "Saturn"), 1));
        quiz.addQuestion(new Question("Who wrote 'To Kill a Mockingbird'?", Arrays.asList("Harper Lee", "Mark Twain", "Ernest Hemingway", "F. Scott Fitzgerald"), 0));

        quiz.start();
    }
}
