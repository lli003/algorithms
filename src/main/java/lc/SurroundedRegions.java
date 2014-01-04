package lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region
 * .
 * 
 * For example, X X X X X O O X X X O X X O X X After running your function, the
 * board should be:
 * 
 * X X X X X X X X X X X X X O X X
 * 
 * @author leili
 * 
 */
public class SurroundedRegions {

  /**
   * bfs: cannot pass large test cast, as the dfs calls exceed the size of stack
   * 
   * @param board
   */
  public void solve(char[][] board) {
    assert (board != null);
    if (board.length == 0)
      return;

    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      dfs(board, i, 0);
      dfs(board, i, n - 1);
    }

    for (int j = 1; j < n - 1; j++) {
      dfs(board, 0, j);
      dfs(board, m - 1, j);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O')
          board[i][j] = 'X';
        else if (board[i][j] == '+')
          board[i][j] = 'O';
      }
    }

  }

  public void dfs(char[][] board, int x, int y) {
    int m = board.length, n = board[0].length;
    if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
      return;

    board[x][y] = '+';
    dfs(board, x - 1, y);
    dfs(board, x + 1, y);
    dfs(board, x, y - 1);
    dfs(board, x, y + 1);
  }

  /**
   * bfs
   * @param board
   */
  public void solve2(char[][] board) {
    // IMPORTANT: Please reset any member data you declared, as
    // the same Solution instance will be reused for each test case.
    assert (board != null);
    if (board.length == 0)
      return;
    int m = board.length;
    int n = board[0].length;

    Queue<Point> queue = new LinkedList<Point>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
            && board[i][j] == 'O')
          queue.offer(new Point(i, j));
      }
    }

    while (!queue.isEmpty()) {
      Point p = queue.poll();
      int i = p.i;
      int j = p.j;
      board[i][j] = '+';
      if (i > 0 && board[i - 1][j] == 'O')
        queue.offer(new Point(i - 1, j));
      if (i < m - 1 && board[i + 1][j] == 'O')
        queue.offer(new Point(i + 1, j));
      if (j > 0 && board[i][j - 1] == 'O')
        queue.offer(new Point(i, j - 1));
      if (j < n - 1 && board[i][j + 1] == 'O')
        queue.offer(new Point(i, j + 1));
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O')
          board[i][j] = 'X';
        else if (board[i][j] == '+')
          board[i][j] = 'O';
      }
    }
  }

  class Point {
    int i, j;

    public Point(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

}
