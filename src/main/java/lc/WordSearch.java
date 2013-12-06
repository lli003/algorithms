package lc;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * @author leili
 *
 */
public class WordSearch {

  /* dfs. */
  public boolean exist(char[][] board, String word) {
    assert (board != null && word != null);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfs(board, i, j, word.substring(1)))
            return true;
        }
      }
    }

    return false;
  }

  private boolean dfs(char[][] board, int i, int j, String word) {
    if (word.length() == 0)
      return true;

    // go up
    if (i > 0 && board[i - 1][j] == word.charAt(0)) {
      char ch = board[i][j];
      board[i][j] = '.';
      if (dfs(board, i - 1, j, word.substring(1)))
        return true;
      board[i][j] = ch;
    }

    // go down
    if (i < board.length - 1 && board[i + 1][j] == word.charAt(0)) {
      char ch = board[i][j];
      board[i][j] = '.';
      if (dfs(board, i + 1, j, word.substring(1)))
        return true;
      board[i][j] = ch;
    }

    // go left
    if (j > 0 && board[i][j - 1] == word.charAt(0)) {
      char ch = board[i][j];
      board[i][j] = '.';
      if (dfs(board, i, j - 1, word.substring(1)))
        return true;
      board[i][j] = ch;
    }

    // go right
    if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(0)) {
      char ch = board[i][j];
      board[i][j] = '.';
      if (dfs(board, i, j + 1, word.substring(1)))
        return true;
      board[i][j] = ch;
    }

    return false;
  }

}
