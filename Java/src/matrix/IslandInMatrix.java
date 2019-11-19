package matrix;

public class IslandInMatrix {

  public static int countNumberOfIslands(int[][] matrix) {

		if (matrix == null) {
			return 0;
		}

    boolean[][] visited = new boolean[matrix.length][matrix[0].length];

    int count = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (!visited[i][j] && matrix[i][j] == 1) {
          DFS(matrix, i, j, visited);
          System.out.println(i + " " + j);
          count++;
        }
      }
    }

    return count;
  }

  private static boolean isSafe(int[][] matrix, int row, int col, boolean[][] visited) {
    return (row >= 0 && row < matrix.length && col >= 0
        && col < matrix[0].length
        && !visited[row][col]
        && matrix[row][col] == 1);
  }

  private static void DFS(int[][] matrix, int i, int j, boolean[][] visited) {

    int rowNum[] = {-1, 0, -1, 1, 0, 1, 1, -1};
    int colNum[] = {0, -1, -1, 0, 1, 1, -1, 1};

    visited[i][j] = true;

    for (int k = 0; k < 8; k++) {
      if (isSafe(matrix, rowNum[k] + i, colNum[k] + j, visited)) {
        DFS(matrix, rowNum[k] + i, colNum[k] + j, visited);
      }
    }
  }
	
/*	public static void main(String[] args) {
				
				int M[][]= new int[][] {{1, 1, 0, 0, 0},
					{0, 1, 0, 0, 1},
					{1, 0, 0, 1, 1},
					{0, 0, 0, 0, 0},
					{1, 0, 1, 0, 1}
					};
			int count = countNumberOfIslands(M);
			System.out.println(count);
				
	}
*/
}
