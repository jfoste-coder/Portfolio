/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


import java.util.ArrayList;
import java.util.List;


/**
 * Represents a Tic Tac Toe game.
 * Provides methods for managing the board, checking game status, and generating possible moves.
 */
public class TicTacToe {
    private char[][] board; // The Tic Tac Toe board (3x3 grid)
    private Player x; // Player using the 'X' marker
    private final Player o; // Player using the 'O' marker

    /**
     * Gets the current state of the game board.
     *
     * @return the game board as a 2D char array
     */
    public char[][] getBoard() {
        return this.board;
    }

    /**
     * Sets the game board to the specified state.
     *
     * @param board the 2D char array representing the new board state
     */
    public void setBoard(char[][] board) {
        this.board = board;
    }

    /**
     * Gets the player using the 'X' marker.
     *
     * @return the player using 'X'
     */
    public Player getX() {
        return this.x;
    }

    /**
     * Sets the player using the 'X' marker.
     *
     * @param x the player to set as 'X'
     */
    public void setX(Player x) {
        this.x = x;
    }

    /**
     * Gets the player using the 'O' marker.
     *
     * @return the player using 'O'
     */
    public Player getO() {
        return this.o;
    }

    /**
     * Sets the player using the 'O' marker.
     *
     * @param x the player to set as 'O'
     */
    public void setO(Player o) {
        this.x = o;
    }

    /**
     * Initializes the game with two players and an empty board.
     *
     * @param x the player using the 'X' marker
     * @param o the player using the 'O' marker
     */
    public TicTacToe(Player x, Player o) {
        this.x = x;
        this.o = o;
        this.board = new char[3][3];

        // Initialize the board with blank cells '_'
        for (char[] row : board) {
            for (char cell : row) {
               cell = '_';
            }
        }
    }

    public int countBlanks() {
        int count = 0;
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '_') {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Determines the marker ('X' or 'O') for a given player.
     *
     * @param player the player to determine the marker for
     * @return the marker for the player
     */
    public char markerForPlayer(Player player) {
        // Use of ternary operator to determine player.
        return player == x ? 'X' : 'O';
    }

    /**
     * Checks if a given player has won the game.
     *
     * @param player the player to check for a win
     * @return true if the player has won, false otherwise
     */
    public boolean checkWin(Player player) {
        char mark = markerForPlayer(player);
        for (int i = 0; i < 3; i++) {

            // Check rows, columns for a win
            if ((board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) ||
                (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark)) {
                return true;
            }
        }
                // Check diagonals for a win
        return (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
               (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark);
    }

    /**
     * Checks if a given player has lost the game.
     *
     * @param player the player to check for a loss
     * @return true if the player has lost, false otherwise
     */
    public boolean checkLose(Player player) {

        // Use of ternary operator to determine player. Calls chekWin Method to see if the other player won.
        return checkWin(player == x ? o : x);
    }

    /**
     * Checks if the game is a draw.
     *
     * @return true if the game is a draw, false otherwise
     */
    public boolean checkDraw() {
        return countBlanks() == 0 && !checkWin(x) && !checkWin(o);
    }

    /**
     * Returns a string representation of the game board.
     *
     * @return the string representation of the board
     */
    @Override
    public String toString() {
        String boardString = null;
        for (char[] row : board) {
            for (char cell : row) {
                boardString += cell;
            }
            boardString += '\n';
        }
        return boardString;
    }

    /**
     * Generates all possible moves for the given player.
     *
     * @param player the player making the moves
     * @return an array of TicTacToe objects representing the possible moves
     */
    public TicTacToe[] possibleMoves(Player player) {
        List<TicTacToe> moves = new ArrayList<>();
        char mark = markerForPlayer(player);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    TicTacToe copy = new TicTacToe(x, o);
                    for (int m = 0; m < 3; m++) {
                        copy.board[m] = board[m].clone();
                    }
                    copy.board[i][j] = mark;
                    moves.add(copy);
                }
            }
        }
        return moves.toArray(new TicTacToe[0]);
    }
}