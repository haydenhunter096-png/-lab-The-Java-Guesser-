import java.util.Scanner;

public class Guesser {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {

            System.out.println("0) Exit");
            System.out.println("1) Human Guesser");
            System.out.println("2) Computer guesser");
            System.out.print("\nPlease enter 0-2: ");

            choice = input.nextInt();

            if (choice == 1) {

                System.out.println("human guesser");

                int number = (int)(Math.random() * 100) + 1;
                int guess = 0;
                int count = 1;

                while (guess != number) {

                    System.out.print(count + ") Please enter a number: ");
                    guess = input.nextInt();

                    if (guess < number) {
                        System.out.println("too low...");
                    }
                    else if (guess > number) {
                        System.out.println("too high...");
                    }
                    else {
                        System.out.println("got it!");
                        System.out.println("You guessed the number in " + count + " guesses!");
                        System.out.println("\nVery good!");
                    }

                    count++;
                }
            }

            else if (choice == 2) {

                System.out.println("computer guesser");

                int low = 1;
                int high = 100;
                int guess;
                int count = 1;

                input.nextLine();

                while (true) {

                    guess = (low + high) / 2;

                    System.out.println(count + ") I guess " + guess);
                    System.out.print("Too (H)igh, too (L)ow, or (C)orrect? ");

                    String response = input.nextLine();

                    if (response.equalsIgnoreCase("c")) {
                        System.out.println("I found your number in " + count + " guesses!");
                        break;
                    }
                    else if (response.equalsIgnoreCase("h")) {
                        high = guess - 1;
                    }
                    else if (response.equalsIgnoreCase("l")) {
                        low = guess + 1;
                    }

                    count++;
                }
            }

            System.out.println();
        }

        input.close();
    }
}