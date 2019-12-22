package matrix;

public class RangeSumQuery2DMutable {

  public static void main(String[] args) {
    int[][] matrix = {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
    };
    NumMatrix numMatrix = new NumMatrix(
        matrix
    );
    System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    numMatrix.update(3, 2, 2);
    System.out.println(numMatrix.sumRegion(2, 1, 4, 3));

    int[][] matrix2 = {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
    };

    NumMatrix2 numMatrix2 = new NumMatrix2(
        matrix2
    );
    System.out.println(numMatrix2.sumRegion(2, 1, 4, 3));
    numMatrix2.printMatrix(matrix2);
    numMatrix2.update(3, 2, 2);
    System.out.println(numMatrix2.sumRegion(2, 1, 4, 3));
    numMatrix2.printMatrix(matrix2);

  }

  static class NumMatrix2 {
    // Use Segment Trees or Binary Indexed Trees or Fennwick Tree
    // Time Complexity: O(log m * log n)
    // Space Complexity: O (log m * log n)

    // https://zhuhan0.blogspot.com/2017/09/leetcode-308-range-sum-query-2d-mutable.html
    // https://www.youtube.com/watch?v=ZBHKZF5w4YU
    // https://evelynn.gitbooks.io/google-interview/content/range_sum_query_2d_-_mutable.html
    
    int[][] tree;
    int[][] matrix;
    int height;
    int width;

    public NumMatrix2(int[][] matrix) {
      if (matrix.length == 0) {
        return;
      }

      this.height = matrix.length;
      this.width = matrix[0].length;
      this.matrix = new int[height][width];
      this.tree = new int[height + 1][width + 1];

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          update(i, j, matrix[i][j]);
        }
      }
    }

    public void update(int row, int col, int val) {
      int diff = val - this.matrix[row][col];
      matrix[row][col] = val;
      for (int i = row + 1; i <= height; i += (i & -i)) {
        for (int j = col + 1; j <= width; j += (j & -j)) {
          tree[i][j] += diff;
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      return sum(row2, col2) - sum(row1 - 1, col2) - sum(row2, col1 - 1) + sum(row1 - 1, col1 - 1);
    }

    private int sum(int row, int col) {
      int sum = 0;
      for (int i = row + 1; i > 0; i -= (i & -i)) {
        for (int j = col + 1; j > 0; j -= (j & -j)) {
          sum += tree[i][j];
        }
      }
      return sum;
    }

    public void printMatrix(int[][] matrix) {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
      }
    }
  }

  static class NumMatrix {

    // Using prefix sum
    // Time complexity: O(1)
    // Space complexity: O(mn)

    // https://github.com/mission-peace/interview/blob/master/src/com/interview/multiarray/Mutable2DSumRangeQuery.java
    
    private int[][] prefixSum;
    private int[][] matrix;

    private int rows;
    private int cols;

    public NumMatrix(int[][] matrix) {
      if (matrix.length == 0) {
        return;
      }

      this.matrix = matrix;
      this.prefixSum = new int[matrix.length][matrix[0].length + 1];
      this.rows = matrix.length;
      this.cols = matrix[0].length;

      for (int i = 0; i < rows; i++) {
        for (int j = 1; j <= cols; j++) {
          prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
        }
      }
    }

    public void update(int row, int col, int val) {
      int delta = val - matrix[row][col];
      matrix[row][col] = val;
      for (int j = col + 1; j <= cols; j++) {
        prefixSum[row][j] += delta;
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      int sum = 0;
      for (int row = row1; row <= row2; row++) {
        sum += prefixSum[row][col2 + 1] - prefixSum[row][col1];
      }
      return sum;
    }
  }
}
