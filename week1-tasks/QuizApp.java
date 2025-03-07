import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a question
class Question {
    String text;
    String[] options;
    int correctAnswer;

    public Question(String text, String[] options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

// Class to manage the quiz
class Quiz {
    private ArrayList<Question> questions;
    private Scanner scanner;

    public Quiz() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a question
    public void addQuestion() {
        System.out.print("Enter the question: ");
        scanner.nextLine(); // Consume newline
        String text = scanner.nextLine();

        String[] options = new String[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter option " + (i + 1) + ": ");
            options[i] = scanner.nextLine();
        }

        System.out.print("Enter the correct option number (1-4): ");
        int correctAnswer = scanner.nextInt();

        questions.add(new Question(text, options, correctAnswer));
        System.out.println("✅ Question added successfully!");
    }

    // Method to take the quiz
    public void takeQuiz() {
        if (questions.isEmpty()) {
            System.out.println("No questions available. Please add questions first.");
            return;
        }

        int score = 0;
        System.out.println("\nStarting the quiz...\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.text);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (q.checkAnswer(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! The correct answer was option " + q.correctAnswer + "\n");
            }
        }

        System.out.println("Quiz completed! Your Score: " + score + "/" + questions.size());
    }
}

// Main class to run the application
public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();
        int choice;

        while (true) {
            System.out.println("\n--- Quiz Application ---");
            System.out.println("1. Add Question");
            System.out.println("2. Take Quiz");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    quiz.addQuestion();
                    break;
                case 2:
                    quiz.takeQuiz();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you for using the Quiz App!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }
}
