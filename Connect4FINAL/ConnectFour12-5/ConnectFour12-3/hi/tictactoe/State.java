package tictactoe;

/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    public int whoseMove = Constants.R;
    public String rName = "";
    public String bName = "";
    public int[][] board = new int[Constants.BOARD_SIZE ][Constants.BOARD_SIZE];

    public boolean isWinner() {
        int total;
        for (int row=0; row<Constants.BOARD_SIZE - 1; row++) {
            for (int col=0; col<Constants.BOARD_SIZE -3; col++) {
                total = getBoardCell(row, col) + getBoardCell(row,col +1) + getBoardCell(row,col +2) + getBoardCell(row, col+3);
                if (total == -4 || total == 4) return true;
            }
        }

        for (int col=0; col<Constants.BOARD_SIZE; col++) {
            for (int row=0; row<Constants.BOARD_SIZE -3; row++) {
                total = getBoardCell(row, col) + getBoardCell(row +1,col) + getBoardCell(row + 2, col) + getBoardCell(row +3, col );
                if (total == -4 || total == 4) return true;
            }
        }
        for (int col=0; col<Constants.BOARD_SIZE - 3; col++) {
            for (int row=3; row<Constants.BOARD_SIZE -1; row++) {
                total = getBoardCell(row, col) + getBoardCell(row -1,col +1) + getBoardCell(row -2, col+2) + getBoardCell(row -3, col +3 );
                if (total == -4 || total == 4) return true;
            }
        }
        for (int col=0; col<Constants.BOARD_SIZE - 3; col++) {
            for (int row=0; row<Constants.BOARD_SIZE -4; row++) {
                total = getBoardCell(row, col) + getBoardCell(row +1,col +1) + getBoardCell(row + 2, col +2) + getBoardCell(row +3, col+3 );
                if (total == -4 || total == 4) return true;
            }
        }
        return false;
    }

    public boolean isTie() {
        for (int row=0; row<Constants.BOARD_SIZE; row++) {
            for (int col=0; col<Constants.BOARD_SIZE; col++) {
                if (getBoardCell(row,col) == Constants.BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    public int getBoardCell( int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell( int row,  int col, int value) {
        for( row = 6 -1;row >=0;row--) {
            if(board[row][col] == 0) {
                board[row][col] = value ;
                break;
            }

        }

    }


}
