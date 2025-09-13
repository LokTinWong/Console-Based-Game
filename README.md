# Console-Based-Game
A console-based game programmed in Java. Made during Grade 11.

## Minigames
- Guess the mine
- High-low
- Monster
- Slot machine
- Graveyard

### Guess the mine
In a 4x4 minefield, there is one mine in each row. The user has 10 guesses to find all the mines, otherwise they lose. Each guess involves inputting a row coordinate and a column coordinate.

### High-low
The user is given two random numbers between 1-100. The first number will be shown, and the user has to guess if the second number is higher, lower, or equal.

### Monster
The user picks one of three weapons to fight a monster. Rather uninterestingly, the turn-based fight is conducted automatically and the user is shown the result at the end.

### Slot machine
Gambling at its finest.

### Graveyard
The user is asked three questions. Different outcomes occur depending on their answers. The second question is a reference to [SCP-049](https://scp-wiki.wikidot.com/scp-049).

## Limitations
I deliberately chose not to fix these limitations, to show my inexperience back in Grade 11. After first year at UBC, I now know how to make my programs more robust and refactor repetitive code.

- When playing **Guess the mine**, entering a coordinate outside of the given minefield throws an uncaught exception, causing the game to end.
- When asked to exit a minigame or not, if and only if user inputs "yes", "YES", "y", or "Y", the program leaves the minigame and returns to the main menu. Any other input starts another round of said minigame.
