package dp;

public class LongestCommonSubsequence {

	public static int lcs(String a, String b) {

		int dp[][] = new int[a.length() + 1][b.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		printLongestSubsequence(dp, a, b);

		return dp[a.length()][b.length()];
	}

	public static void printLongestSubsequence(int dp[][], String a, String b) {

		int i = a.length();
		int j = b.length();

		StringBuilder sb = new StringBuilder("");

		while ((i != 0 || j != 0) && i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1) && i > 0 && j > 0) {
				sb.append(a.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i][j - 1] == dp[i][j]) {
				j--;
			} else {
				i--;
			}
		}
		System.out.println(sb.reverse().toString());
	}

	public static void main(String[] args) {
		String a = "bcmqdabc";
		String b = "aabcbdef";

		lcs("aabcbdef", "bcmqdabc");

		System.out.println(lcs(a, b));

		System.out.println(lcs("aabccdeaab", "aaaaaaeaaa"));
	}

}
