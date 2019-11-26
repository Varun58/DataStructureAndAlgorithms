package backtracking;

public class AndroidUnlockPattern {

  public static void main(String[] args) {
    System.out.println(numberOfPatterns(1, 4));
  }

  // https://medium.com/@rebeccahezhang/leetcode-351-android-unlock-patterns-d9bae4a8a958
  public static int numberOfPatterns(int m, int n) {
    int skip[][] = new int[10][10];

    // Keep a recod of invalid numbers on the path between
    // two selected keys
    skip[1][3] = skip[3][1] = 2;
    skip[1][7] = skip[7][1] = 4;
    skip[3][9] = skip[9][3] = 6;
    skip[7][9] = skip[9][7] = 8;

    skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

    boolean[] visited = new boolean[10];

    int res = 0;

    for (int i = m; i <= n; ++i) {
      res += DFS(visited, skip, 1, i - 1) * 4;
      res += DFS(visited, skip, 2, i - 1) * 4;
      res += DFS(visited, skip, 5, i - 1);
    }
    return res;
  }

  private static int DFS(boolean[] visited, int[][] skip, int curr, int remain) {

    if (remain < 0) {
      return 0;
    }

    // Base case: no remaining numbers
    if (remain == 0) {
      return 1;
    }

    // Mark number as visited
    visited[curr] = true;
    int res = 0;

    for (int i = 1; i <= 9; ++i) {
      // Next key must be unvisited
      // Current key and next key are adjacent or skip number is already visited
      if (!visited[i] && (skip[i][curr] == 0 || visited[skip[i][curr]])) {
        res += DFS(visited, skip, i, remain - 1);
      }
    }

    // Mark as unvisited for the rest of recursion calls after return from the first one
    visited[curr] = false;

    return res;
  }
}
