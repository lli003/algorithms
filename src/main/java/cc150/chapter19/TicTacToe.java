package cc150.chapter19;

/**
 * Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
 * 
 * Tic-tac-toe (or Noughts and crosses, Xs and Os) is a paper-and-pencil game for two players, 
 * X and O, who take turns marking the spaces in a 3×3 grid. 
 * The player who succeeds in placing three respective marks in a horizontal, vertical, or diagonal row wins the game.
 * 
 * @author lli003
 *
 */
public class TicTacToe {
  
  enum Piece {Empty, BLUE, RED};
  enum Check {Row, Column, Diagonal, ReverseDiagonal};
  
  /**
   * check the color of a given position based on checking criteria
   * @param board
   * @param index
   * @param var
   * @param check
   * @return
   */
  Piece getColor(Piece[][] board, int index, int var, Check check){
    if (check == Check.Row) return board[index][var];
    else if (check == Check.Column) return board[var][index];
    else if (check == Check.Diagonal) return board[var][var];
    else if (check == Check.ReverseDiagonal) return board[board.length - 1 - var][var];
    return Piece.Empty;
  }
  
  /**
   * check the winer of a given position based on checking criteria
   * @param board
   * @param fixIndex
   * @param check
   * @return
   */
  Piece getWinner(Piece[][] board, int fixIndex, Check check){
    Piece color = getColor(board, fixIndex, 0, check);
    if (color == Piece.Empty) return Piece.Empty;
    for (int i = 1; i < board.length; i++){
      if (color != getColor(board, fixIndex, i, check))
        return Piece.Empty;
    }
    return color;
  }
  
  /**
   * check winner on rows, columns, diagonal and reversediagonal
   * @param board
   * @return
   */
  Piece hasWon(Piece[][] board){
    int n = board.length;
    Piece winner = Piece.Empty;
    
    // check rows and columns
    for (int i = 0; i < n; i++){
      winner = getWinner(board, i, Check.Row);
      if (winner != Piece.Empty)
        return winner;
      
      winner = getWinner(board, i, Check.Column);
      if (winner != Piece.Empty)
        return winner;
    }
    
    // check diagonal
    winner = getWinner(board, -1, Check.Diagonal);
    if (winner != Piece.Empty)
      return winner;
    
    // check reverse diagonal
    winner = getWinner(board, -1, Check.ReverseDiagonal);
    if (winner != Piece.Empty)
      return winner;
    
    return winner;
  }

}
