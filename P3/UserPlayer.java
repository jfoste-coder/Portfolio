/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


import java.util.Scanner;

/**
 * The UserPlayer class represents a human player in a Tic-Tac-Toe game.
 * This class extends the Player abstract class and allows the user to make moves
 * by selecting from a list of possible moves.
 */
public class UserPlayer extends Player {
    private final String name; // The name of the player
    private final Scanner input; // The Scanner object used to read user input

    /**
     * Constructs a UserPlayer with the given name and input source.
     *
     * @param input the Scanner object used to receive input from the user
     * @param name  the name of the player
     */
    public UserPlayer(Scanner input, String name) {
        this.name = name;
        this.input = input;
    }

    /**
     * Returns the name of the player as a string representation.
     *
     * @return the name of the player
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Prompts the user to choose their next move in a Tic-Tac-Toe game.
     * The method displays the current board state, presents all possible moves,
     * and allows the user to select a move by entering an option number.
     *
     * @param board the current state of the Tic-Tac-Toe board
     * @return the TicTacToe object representing the chosen move
     */
    @Override
    public TicTacToe chooseMove(TicTacToe board) {
        System.out.println("Current board:\n" + board); // Display the current state of the board
        TicTacToe[] options = board.possibleMoves(this); // Get all possible moves for this player

        // Display each possible move with its index
        for (int i = 0; i < options.length; i++) {
            System.out.println("Option " + i + ":\n" + options[i]);
        }

        System.out.print("Choose an option: "); // Prompt the user to choose a move by selecting an index
        int selection = input.nextInt(); // Read the user's selection
        return options[selection]; // Return the chosen move
    }
}