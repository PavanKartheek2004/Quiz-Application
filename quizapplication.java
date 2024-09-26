import java.util.Scanner;

class Quiz {
    private String question;
    private String[] options;
    private char correctAnswer;

    public Quiz(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        Quiz[] quizzes = new Quiz[]{
                new Quiz("What is the capital of France?", new String[]{"Germany", "New york", "Paris", "Rome"}, 'C'),
                new Quiz("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 'B'),
                new Quiz("Who wrote 'Hamlet'?", new String[]{"Charles Dickens", "Leo Tolstoy", "William Shakespeare", "Mark Twain"}, 'C')
        };

        for (Quiz quiz : quizzes) {
            quiz.displayQuestion();
            System.out.print("Enter your answer: ");
            char userAnswer = scanner.next().charAt(0);

            if (quiz.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer!");
            }
        }

        System.out.println("You scored: " + score + " out of " + quizzes.length);
        scanner.close();
    }
}
