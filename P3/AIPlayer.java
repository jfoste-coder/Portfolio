/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


/**
 * Represents an AI player in a Tic Tac Toe game.
 * Extends the Player class and implements decision-making 
 * using the Minimax algorithm to choose the best moves.
 */
public class AIPlayer extends Player {
    
    private final String name; // Name of the AI player
    private Player opponent; // Opponent player

    /**
     * Constructs an AIPlayer with a given name and opponent.
     *
     * @param name     the name of the AI player
     * @param opponent the opponent player
     */
    public AIPlayer(String name, Player opponent) {
        this.name = name;
        this.opponent = opponent;
    }

    /**
     * Gets the opponent of this AI player.
     *
     * @return the opponent player
     */
    public Player getOpponent() {
        return opponent;
    }

    /**
     * Sets a new opponent for this AI player.
     *
     * @param opponent the new opponent player
     */
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * Returns a string representation of the AI player.
     *
     * @return the name of the AI player followed by "(AI)"
     */
    @Override
    public String toString() {
        return name + " (AI)";
    }

    /**
     * Chooses the best move for the AI player based on the current board state.
     * Implements the Minimax algorithm to evaluate the best possible move.
     *
     * @param board the current game board
     * @return the chosen move as a TicTacToe object
     */
    @Override
    public TicTacToe chooseMove(TicTacToe board) {
        // Get all possible moves for the AI player
        TicTacToe[] moves = board.possibleMoves(this);
        TicTacToe bestMove = null;
        // Using the Double class NEGATIVE_INFINTY constant. This constant is a special value defined in the Double class in Java.
        // It represents negative infinity, which is smaller than any other double value.
        double bestValue = Double.NEGATIVE_INFINITY;

        // Evaluate each move using the Minimax algorithm
        for (TicTacToe move : moves) {
            double value = minValue(move); // Get the worst-case value of the move
            if (value > bestValue) {
                bestValue = value;
                bestMove = move; // Update the best move if a better value is found
            }
        }
        return bestMove;
    }

    /**
     * Evaluates the value of the current board state for the AI player.
     *
     * @param board the current game board
     * @return the evaluation value of the board
     */
    @Override
    public double boardValue(TicTacToe board) {
        return maxValue(board); // The AI seeks to maximize its advantage
    }

    /**
     * Calculates the maximum value for the AI player using the Minimax algorithm.
     * Simulates the AI player's perspective for optimal move selection.
     *
     * @param board the current game board
     * @return the maximum value achievable for the AI player
     */
    public double maxValue(TicTacToe board) {
        // Base cases
        if (board.checkWin(this)) {
            return 1.0;     // Winning board
        }   
        if (board.checkLose(this)) {
            return -1.0;    // Losing board
        }
        if (board.checkDraw()) {
            return 0.0;     // Draw
        }

        double value = Double.NEGATIVE_INFINITY;
        // Recursive case: Evaluate all possible moves for the AI player
        for (TicTacToe move : board.possibleMoves(this)) {
            value = Math.max(value, minValue(move)); // AI maximizes the value
        }
        return value;
    }

    /**
     * Calculates the minimum value for the opponent using the Minimax algorithm.
     * Simulates the opponent's perspective to counteract the AI player's moves.
     *
     * @param board the current game board
     * @return the minimum value achievable for the opponent
     */
    public double minValue(TicTacToe board) {
        // Base cases
        if (board.checkWin(this)) {
            return 1.0;     // Winning board
        }
        if (board.checkLose(this)) {
            return -1.0;    // Losing board
        }
        if (board.checkDraw()) {
            return 0.0;     // Draw
        }

        double value = Double.POSITIVE_INFINITY;
        // Recursive case: Evaluate all possible moves for the opponent
        for (TicTacToe move : board.possibleMoves(opponent)) {
            value = Math.min(value, maxValue(move)); // Opponent minimizes the value
        }
        return value;
    }
}