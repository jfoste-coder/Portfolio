/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


/**
 * Abstract class representing a generic player in a Tic-Tac-Toe game.
 * Subclasses must implement the {@code chooseMove} method to define how the player selects a move.
 */
public abstract class Player {

    /**
     * Abstract method to determine the next move for the player.
     * Subclasses should provide an implementation that determines the optimal or desired move.
     *
     * @param board the current state of the Tic-Tac-Toe game board.
     * @return a TicTacToe object representing the board after the chosen move is applied.
     */
    public abstract TicTacToe chooseMove(TicTacToe board);

    /**
     * Evaluates the value of the current board state from the perspective of this player.
     *
     * @param board the current state of the Tic-Tac-Toe game board.
     * @return 1.0 if this player has won, -1.0 if this player has lost, and 0.0 otherwise.
     */
    public double boardValue(TicTacToe board) {
        // Check if the current player has won the game.
        if (board.checkWin(this)) {
            return 1.0; // Winning board state.
        }
        // Check if the current player has lost the game.
        if (board.checkLose(this)) {
            return -1.0; // Losing board state.
        }
        // Neither a win nor a loss; return neutral board state value.
        return 0.0;
    }
}