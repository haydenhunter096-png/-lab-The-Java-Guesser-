Program: Java Guesser

Menu Algorithm
1. Display menu options (0 exit, 1 human guesser, 2 computer guesser)
2. Read user choice
3. If choice = 1 run human guesser
4. If choice = 2 run computer guesser
5. Repeat until choice = 0

Human Guesser Algorithm
1. Generate random number between 1 and 100
2. Ask user to guess number
3. If guess < number → print too low
4. If guess > number → print too high
5. If guess == number → print got it
6. Count attempts
7. Repeat until correct

Computer Guesser Algorithm
1. Set low = 1
2. Set high = 100
3. Guess midpoint = (low + high)/2
4. Ask user if guess is high, low, or correct
5. If high → set high = guess - 1
6. If low → set low = guess + 1
7. Repeat until correct