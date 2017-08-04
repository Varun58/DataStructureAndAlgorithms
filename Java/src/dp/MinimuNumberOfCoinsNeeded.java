package dp;

public class MinimuNumberOfCoinsNeeded {

	public static int minCoins(int n, int S[]) {

		int i = 0, j = 0;
		int dp[][] = new int[S.length + 1][n + 1];
		
		for (i = 0; i < dp.length; i++) {
			for (j = 0; j < dp[0].length; j++) {
				if (i == 0 ) {
					dp[i][j] = j;
				}
				else if (j >= S[i-1]) {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - S[i-1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[i-1][j-1];
	}

	public static void main(String[] args) {
		int coins[] = { 1, 5, 6, 8 };
		System.out.println(minCoins(11, coins));
	}
}
