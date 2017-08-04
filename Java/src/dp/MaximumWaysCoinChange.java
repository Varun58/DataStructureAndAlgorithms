package dp;

import java.util.Arrays;

public class MaximumWaysCoinChange {

	public static int countWays(int[] coins, int amount, int coinNumber) {
		if (amount == 0) {
			return 1;
		}
		if (amount < 0)
			return 0;
		if (coinNumber <= 0 && amount >= 1) {
			return 0;
		}
		return countWays(coins, amount, coinNumber - 1) + countWays(coins, amount - coins[coinNumber - 1], coinNumber);
	}

	// Need to Understand sol
	public static long countWaysUsingDP(int denominations[], int amount) {

		Arrays.sort(denominations);

		long[] table = new long[amount + 1];

		table[0] = 1;
		for (int i = 0; i < denominations.length; i++) {
			for (int j = denominations[i]; j <= amount; j++) {
				table[j] += table[j - denominations[i]];
			}
		}
		return table[amount];
	}

	//
	public static long countWaysUsingDP2(int denominations[], int amount) {

		Arrays.sort(denominations);

		int i = 0, j = 0;
		long dp[][] = new long[denominations.length + 1][amount+1];

		for (i = 0; i < dp.length; i++) {
				dp[i][0] = 1;
		}

		for (i = 1; i <= denominations.length; i++) {
			for (j = 1; j <= amount; j++) {
				if (denominations[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - denominations[i - 1]];
				}
			}
		}

		return dp[i - 1][j - 1];
	}
	
	/**
     * Space efficient DP solution
     */
    public int numberOfSolutionsOnSpace(int total, int arr[]){

        int sum[] = new int[total+1];

        sum[0] = 1;
        for(int i=0; i < arr.length; i++){
            for(int j=1; j <= total ; j++){
                if(j >= arr[i]){
                	sum[j] += sum[j-arr[i]];
                }
            }
        }
        return sum[total];
    }

	public static void main(String[] args) {
		System.out.println(countWays(new int[] { 1, 2, 3 }, 4, 3));
		System.out.println(countWaysUsingDP(new int[] { 1, 2, 3 }, 4));
		System.out.println(countWaysUsingDP2(
				new int[] { 41, 34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11 },
				250));
		//Expected 15685693751
		
	}
}
