package recursion;

public class WordSearch {

  public static void main(String[] args) {
    char board[][] = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    System.out.println(new WordSearch().exist(board, "ABCCED"));
  }

  boolean[][] visited;

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || word == null || word.length() == 0) {
      return false;
    }

    int row = board.length;
    int col = board[0].length;

    visited = new boolean[row][col];
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (Dfs(board, r, c, 0, word)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean Dfs(char[][] board, int row, int col, int curr, String word) {
    if (curr == 6) {
      System.out.println("current" + curr + "  with " + word.length());
    }

    if (curr == word.length()) {
      return true;
    }

    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
      return false;
    }

    System.out.println(board[row][col] + " match with " + word.charAt(curr));

    if (visited[row][col] || board[row][col] != word.charAt(curr)) {
      return false;
    }

    visited[row][col] = true;

    boolean found =
        Dfs(board, row, col + 1, curr + 1, word)
            || Dfs(board, row, col - 1, curr + 1, word)
            || Dfs(board, row + 1, col, curr + 1, word)
            || Dfs(board, row - 1, col, curr + 1, word);

    visited[row][col] = false;

    return found;
  }
}
