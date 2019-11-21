package graph;

public class NumberOfIslands {
  public static void main(String[] args) {
    char M[][] = new char[][] {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };

    System.out.println(numIslands(M));
  }

  public static int numIslands(char[][] grids) {
    if (grids == null || grids.length == 0) {
      return 0;
    }

    int count = 0;
    for (int i = 0; i < grids.length; i++) {
      for (int j = 0; j < grids[i].length; j++) {
        if (grids[i][j] == '1') {
          dfs(grids, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private static void dfs(char[][] grid, int r, int c) {
    int nr = grid.length;
    int nc = grid[0].length;

    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
      return;
    }

    grid[r][c] = '0';
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
  }
}
