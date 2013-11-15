package lc;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
 * @author leili
 *
 */
public class SolveSudoku {

  public void solveSudoku(char[][] board) {
    solver(board);
  }
  
  /**
   * dfs solver
   * @param board
   * @return
   */
  private boolean solver(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          for (int k = 0; k < 9; k++) {
            board[i][j] = (char) ('1' + k);
            if (isValid(board, i, j) && solver(board))
              return true;
            board[i][j] = '.';
          }
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int a, int b) {
    Set<Character> exist = new HashSet<Character>();
    for (int i = 0; i < 9; i++) {
      if (exist.contains(board[i][b]))
        return false;
      if (board[i][b] > '0' && board[i][b] <= '9')
        exist.add(board[i][b]);
    }

    exist = new HashSet<Character>();
    for (int i = 0; i < 9; i++) {
      if (exist.contains(board[a][i]))
        return false;
      if (board[a][i] > '0' && board[a][i] <= '9')
        exist.add(board[a][i]);
    }

    exist = new HashSet<Character>();
    for (int m = 0; m < 3; m++) {
      for (int n = 0; n < 3; n++) {
        int x = a / 3 * 3 + m;
        int y = b / 3 * 3 + n;
        if (exist.contains(board[x][y]))
          return false;
        if (board[x][y] > '0' && board[x][y] <= '9')
          exist.add(board[x][y]);
      }
    }

    return true;
  }

}
