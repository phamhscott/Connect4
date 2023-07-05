package tictactoe;

public class EventLoop {

  // Instance variables for the UI and State classes
  State state = new State();
  UI ui = new UI();
  int row, col;
  
  public static void main(String[] args) {
      EventLoop eventLoop = new EventLoop();
      eventLoop.run();
  }

  public void run() {
    while (state.getGameState() != Constants.QUIT_PROGRAM) {
      int gameState = state.getGameState();
      if (gameState == Constants.STANDBY) {
        state.setGameState(Constants.GET_R_NAME);

      } else if (gameState == Constants.GET_R_NAME) {
        state.setRName(ui.promptForName("R"));
        state.setGameState(Constants.GET_B_NAME);
    
      } else if (gameState == Constants.GET_B_NAME) {
        state.setBName(ui.promptForName("B"));
        state.setGameState(Constants.GET_R_MOVE);
    
      } else if (gameState == Constants.GET_R_MOVE) {
        ui.printBoard(state);
        //row = ui.getMoveRow(state.getWhoseMove(), state.getRName(), state.getBName());
        
        col = ui.getMoveCol(state.getWhoseMove(), state.getRName(), state.getBName());
        if (ui.isLegalMove(state,col)) {
          state.setGameState(Constants.MAKE_MOVE); }
          else {
              System.out.printf(Constants.INVALID_MOVE_ERROR, col);
              System.out.println();
          }
        
      } else if (gameState == Constants.GET_B_MOVE) {
        ui.printBoard(state);
        //row = ui.getMoveRow(state.getWhoseMove(), state.getRName(), state.getBName());
        col = ui.getMoveCol(state.getWhoseMove(), state.getRName(), state.getBName());
        
        
         if (ui.isLegalMove(state,col)) {
          state.setGameState(Constants.MAKE_MOVE); }
          else {
              System.out.printf(Constants.INVALID_MOVE_ERROR, col);
              System.out.println();
          }
        
        }

       else if (gameState == Constants.MAKE_MOVE) {
        ui.printMove(state, col);

        state.setBoardCell( row, col-1, state.getWhoseMove());
        
        state.setGameState(Constants.CHECK_IF_WINNER);

      } else if (gameState == Constants.CHECK_IF_WINNER) {
        if (state.isWinner()) {
            ui.printBoard(state);
          if (state.getWhoseMove() == Constants.R) {
            state.setGameState(Constants.R_WINS);
          } else {
            state.setGameState(Constants.B_WINS);
          }
        } else {
          state.setGameState(Constants.CHECK_IF_TIE);
        }

      } else if (gameState == Constants.CHECK_IF_TIE) {
        if (state.isTie()) {
          ui.printTie();
          state.setGameState(Constants.GAME_OVER);
        } else {
          state.setWhoseMove(state.getWhoseMove() * -1);
          if (state.getWhoseMove() == Constants.R) {
            state.setGameState(Constants.GET_R_MOVE);
          } else {
            state.setGameState(Constants.GET_B_MOVE);
          }
        }

      } else if (gameState == Constants.R_WINS) {
        ui.printWinner(state);
        state.setGameState(Constants.GAME_OVER);
    
      } else if (gameState == Constants.B_WINS) {
        ui.printWinner(state);
        state.setGameState(Constants.GAME_OVER);

      } else if (gameState == Constants.GAME_OVER) {
        if (ui.startNewGame()) {

          //state.setGameState(Constants.STANDBY);
          EventLoop a = new EventLoop();
          a.run();

        } else {
         state.setGameState(Constants.QUIT_PROGRAM);
        }
      }
    }
  }
}
