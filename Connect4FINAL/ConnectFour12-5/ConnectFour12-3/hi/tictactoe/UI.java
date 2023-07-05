package tictactoe;
import java.util.Scanner;

/**
 * UI class
 */
public class UI
{

    Scanner scanner;


    public UI() {
        scanner = new Scanner(System.in);         
    }

    // Utility methods
    public String getROrB(int whoseMove) {
        if (whoseMove == -1) {
            return "R";
        }
        else if (whoseMove == 1) {
            return "B";
        }
        else {
            return " ";
        }
    }

    public String getPlayerName(int whoseMove, String xName, String yName) {
        return (whoseMove == -1) ? xName : yName;
    }

    public boolean isLegalMove(State state, int col) {
        int row = 0;
        return 
        1 <= col && col <= Constants.BOARD_SIZE &&
        state.getBoardCell(row, col - 1) == Constants.BLANK;
    }

    // Prompt for input methods
    public String promptForName(String player) {
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();
    }

    public int getMoveRow(int whoseMove, String rName, String bName) {
        int row = 0;
        while (row <= 0 || row >= 7) {
            try {
                System.out.printf(Constants.GET_ROW_MOVE, getROrB(whoseMove), getPlayerName(whoseMove, rName, bName));
                row = scanner.nextInt();
                if (row > 6 || row < 1) {
                    System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                    System.out.printf(Constants.GET_ROW_MOVE, getROrB(whoseMove), getPlayerName(whoseMove, rName, bName));
                    row = scanner.nextInt();
                }
            } catch (Exception e) {
                System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                scanner.next();
            }
        }

        return row;
    }

    public int getMoveCol(int whoseMove, String rName, String bName) {
        int col = 0;
        while (col <=0 || col >=8) {
            try {
                System.out.printf(Constants.GET_COL_MOVE, getROrB(whoseMove), getPlayerName(whoseMove, rName, bName));
                col = scanner.nextInt();
                if (col > 7 || col < 1) {
                    System.out.println(Constants.INVALID_ROW_OR_COLUMN);
 
                    

                    
                    System.out.printf(Constants.GET_COL_MOVE, getROrB(whoseMove), getPlayerName(whoseMove, rName, bName));
                    col = scanner.nextInt();

                     
                }
                
                
            } catch (Exception e)  {
                System.out.println(Constants.INVALID_ROW_OR_COLUMN);
                scanner.next();
            }

        }
        return col;
    }

    public boolean startNewGame() {
        System.out.println(Constants.START_NEW_GAME);
        String yesOrNo = scanner.next();
        return yesOrNo.equals("Y") || yesOrNo.equals("y");
    }

    // Printing text methods
    public void printWelcome() {
        System.out.println(Constants.TITLE);
    }

    public void printBoard(State state) {
        System.out.println(Constants.DIVIDER_STRING);
        for (int row = 0; row < Constants.BOARD_SIZE -1; row++) {
            System.out.printf(Constants.BOARD_STRING, getROrB(state.getBoardCell(row, 0)), getROrB(state.getBoardCell(row, 1)), getROrB(state.getBoardCell(row, 2)), getROrB(state.getBoardCell(row, 3)), getROrB(state.getBoardCell(row, 4)), getROrB(state.getBoardCell(row, 5)), getROrB(state.getBoardCell(row, 6)));
            System.out.println();
            System.out.println(Constants.DIVIDER_STRING);
        }
    }

    public void printInvalidRowOrColumn() {
        System.out.printf(Constants.INVALID_ROW_OR_COLUMN);
    }

    public void printInvalidMove(int row, int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, row, col);
    }

    public void printMove(State state,  int col) {
        System.out.printf(Constants.PRINT_MOVE, getROrB(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getRName(), state.getBName()), col);
        System.out.println();
    } 

    public void printWinner(State state) {
        System.out.printf(Constants.WINNER, getROrB(state.getWhoseMove()), getPlayerName(state.getWhoseMove(), state.getRName(), state.getBName()));
        System.out.println();
    }

    public void printTie() {
        System.out.println(Constants.TIE_GAME);
    }
}
