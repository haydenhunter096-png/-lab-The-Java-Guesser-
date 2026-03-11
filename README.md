# -lab-The-Java-Guesser-
```
Program: Guesser

Main idea:
- Show a menu (0: Exit, 1: Human Guesser, 2: Computer Guesser).
- Repeat until user chooses 0:
    - Read validated menu choice (0-2).
    - If 1: run humanGuesser.
    - If 2: run computerGuesser.
    - If 0: exit program.

humanGuesser:
- Generate secret integer between 1 and 100.
- attempts = 0
- Loop:
    - attempts++
    - Prompt user: "<attempts>) Please enter a number: "
    - Read integer (validate input)
    - If guess < secret: print "too low..."
    - Else if guess > secret: print "too high..."
    - Else: print "got it!" and "Very good!" and return to menu

computerGuesser (binary search):
- low = 1, high = 100, attempts = 0
- Loop while low <= high:
    - attempts++
    - guess = floor((low + high) / 2)
    - Print "<attempts>) I guess <guess>"
    - Prompt user: "Too (H)igh, too (L)ow, or (C)orrect? "
    - Read response (H/L/C), case-insensitive, validated
    - If response == 'C': print "Very good!" and return to menu
    - If response == 'H': high = guess - 1
    - If response == 'L': low = guess + 1
    - If low > high: print "Inconsistent answers" and return to menu
    ```
    