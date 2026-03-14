Program: Java Guesser

Note:
The computer guesser uses a algorithm. This algorithm repeatedly divides the possible number range in half, which guarantees that a number between 1 and 100 can always be found in a limit of 7 guesses. This was to help with any bugs or crashes that may happen.

Menu Algorithm

1. Display menu options (0 exit, 1 human guesser, 2 computer guesser)
2. Read user choice
3. If choice = 1 run human guesser
4. If choice = 2 run computer guesser
5. Repeat until choice = 0

Human Guesser Algorithm

1. Generate a random number between 1 and 100
2. Set attempt counter to 1
3. Ask the user to enter a guess
4. If guess < number → print "too low..."
5. If guess > number → print "too high..."
6. If guess == number → print "got it!"
7. Display how many guesses were used
8. Repeat until the correct number is guessed

Computer Guesser Algorithm

1. Set low = 1
2. Set high = 100
3. Set attempt counter to 1
4. Guess midpoint = (low + high) / 2
5. Ask user if guess is High, Low, or Correct
6. If High → set high = guess - 1
7. If Low → set low = guess + 1
8. Increase attempt counter
9. Repeat until the correct number is found
10. Display how many guesses the computer used
