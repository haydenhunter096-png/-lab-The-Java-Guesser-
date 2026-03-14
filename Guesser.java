import java.util.Scanner;

public class Guesser {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Guesser g = new Guesser();
        g.run();
    }

    public void run() {
        int choice;

        do {
            System.out.println("0) Exit");
            System.out.println("1) Human Guesser");
            System.out.println("2) Computer guesser");
            System.out.print("\nPlease enter 0-2: ");

            choice = scanner.nextInt();

            if (choice == 1) {
                humanGuesser();
            } else if (choice == 2) {
                computerGuesser();
            }

            System.out.println();

        } while (choice != 0);
    }

    public void humanGuesser() {
        char playAgain;

        do {
            System.out.println("human guesser");

            int target = (int) (Math.random() * 100) + 1;
            int guess = 0;
            int attempt = 1;

            while (guess != target) {
                System.out.print(attempt + ") Please enter a number: ");
                guess = scanner.nextInt();

                if (guess < target) {
                    System.out.println("too low...");
                } else if (guess > target) {
                    System.out.println("too high...");
                } else {
                    System.out.println("got it!");
                    System.out.println("\nVery good!");
                }

                attempt++;
            }

            System.out.print("Play again? (y/n): ");
            scanner.nextLine();
            playAgain = scanner.nextLine().toLowerCase().charAt(0);

        } while (playAgain == 'y');
    }

    public void computerGuesser() {
        char playAgain;

        do {
            System.out.println("computer guesser");

            int low = 1;
            int high = 100;
            int attempt = 1;
            char response;

            scanner.nextLine();

            while (true) {
                int guess = (low + high) / 2;

                System.out.println(attempt + ") I guess " + guess);
                System.out.print("Too (H)igh, too (L)ow, or (C)orrect? ");

                response = scanner.nextLine().toLowerCase().charAt(0);

                if (response == 'c') {
                    break;
                } else if (response == 'h') {
                    high = guess - 1;
                } else if (response == 'l') {
                    low = guess + 1;
                }

                attempt++;
            }

            System.out.print("Play again? (y/n): ");
            playAgain = scanner.nextLine().toLowerCase().charAt(0);

        } while (playAgain == 'y');
    }
}