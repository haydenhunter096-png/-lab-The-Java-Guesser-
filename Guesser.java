import java.util.Scanner;
import java.util.Random;

public class Guesser {
    private Scanner sc;
    private Random rand;

    public Guesser() {
        sc = new Scanner(System.in);
        rand = new Random();
        mainLoop();
    }

    public static void main(String[] args) {
        new Guesser();
    }

    private void mainLoop() {
        while (true) {
            printMenu();
            int choice = readMenuChoice();
            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    return;
                case 1:
                    humanGuesser();
                    break;
                case 2:
                    computerGuesser();
                    break;
                default:
                    // shouldn't happen because readMenuChoice validates
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("0) Exit");
        System.out.println("1) Human Guesser");
        System.out.println("2) Computer guesser");
        System.out.println();
        System.out.print("Please enter 0-2: ");
    }

    private int readMenuChoice() {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                int val = Integer.parseInt(line);
                if (val >= 0 && val <= 2) return val;
            } catch (NumberFormatException e) {
                // fall through to prompt again
            }
            System.out.print("Invalid choice. Please enter 0, 1, or 2: ");
        }
    }

    /* Human Guesser:
       Computer picks a secret (1-100), human types guesses until they get it.
    */
    private void humanGuesser() {
        int secret = rand.nextInt(100) + 1; // 1..100
        System.out.println();
        System.out.println("human guesser");
        int attempts = 0;
        while (true) {
            attempts++;
            int guess = readIntPrompt(attempts + ") Please enter a number: ");
            if (guess < secret) {
                System.out.println("too low...");
            } else if (guess > secret) {
                System.out.println("too high...");
            } else {
                System.out.println("got it!");
                System.out.println();
                System.out.println("Very good!");
                break;
            }
        }
    }

    private int readIntPrompt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    /* Computer Guesser:
       Computer uses binary search between low..high (initially 1..100).
       On each step it guesses the midpoint and asks you:
         Too (H)igh, too (L)ow, or (C)orrect?
       Accepts 'h','H','l','L','c','C'. Handles inconsistent responses.
    */
    private void computerGuesser() {
        System.out.println();
        System.out.println("computer guesser");
        int low = 1;
        int high = 100;
        int attempts = 0;

        while (low <= high) {
            attempts++;
            int guess = (low + high) / 2;
            System.out.println(attempts + ") I guess " + guess);
            char response = readHLCorInvalid();
            if (response == 'C') {
                System.out.println();
                System.out.println("Very good!");
                return;
            } else if (response == 'H') {      // guess was too high
                high = guess - 1;
            } else if (response == 'L') {      // guess was too low
                low = guess + 1;
            }

            // detect inconsistent answers early
            if (low > high) {
                System.out.println();
                System.out.println("Your answers have become inconsistent (no possible number).");
                System.out.println("Please check your responses. Returning to menu.");
                return;
            }
        }

        // fallback (shouldn't be reached)
        System.out.println("Couldn't determine the number. Returning to menu.");
    }

    private char readHLCorInvalid() {
        while (true) {
            System.out.print("Too (H)igh, too (L)ow, or (C)orrect? ");
            String line = sc.nextLine().trim();
            if (line.length() > 0) {
                char c = Character.toUpperCase(line.charAt(0));
                if (c == 'H' || c == 'L' || c == 'C') return c;
            }
            System.out.println("Please enter H, L, or C (for High, Low, or Correct).");
        }
    }
}