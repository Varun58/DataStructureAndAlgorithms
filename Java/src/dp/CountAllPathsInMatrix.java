package dp;

public class CountAllPathsInMatrix {

	public static void main(String[] args) {
		int m[][] = new int[2][2];

		int dp[][] = new int[3][3];

		int val = countPaths(0, 0, dp, 3);

		System.out.println(dp[0][0]);
		System.out.println(countPathsRecursive(3, 3));
		System.out.println(countPathsDP(3, 3));
	}

	// my solution
	public static int countPaths(int i, int j, int dp[][], int n) {

		if (i == n && j == n - 1) {
			return 1;
		}

		if (i == n - 1 && j == n) {
			return 1;
		}

		if (i >= n - 1 && j >= n - 1) {
			return 1;
		}

		if (i == n || j == n) {
			return 0;
		}

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		return dp[i][j] = countPaths(i + 1, j, dp, n) + countPaths(i, j + 1, dp, n);
	}

	public static int countPathsRecursive(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}

		return countPathsRecursive(m - 1, n) + countPathsRecursive(m, n - 1);
	}

	public static int countPathsDP(int m, int n) {
		int dp[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 0; i < m; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}

		return dp[m - 1][n - 1];
	}
}
