package dp;

public class Stairs {
	// A recursive function used by countWays
	static int countWaysUtil(int n, int m) {
		if (n <= 1)
			return n;
		int res = 0;
		for (int i = 1; i <= m && i <= n; i++)
			res += countWaysUtil(n - i, m);
		return res;
	}

	// Returns number of ways to reach s'th stair
	static int countWays(int s, int m) {
		return countWaysUtil(s + 1, m);
	}

	static int countWaysUtilDP(int n, int m) {
		int res[] = new int[n];

		res[0] = 1;
		res[1] = 1;

		for (int i = 2; i < n; i++) {
			res[i] = 0;
			for (int j = 1; j <= m && j <= i; j++)
				res[i] += res[i - j];
		}
		return res[n - 1];
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		int s = 3, m = 3;
		System.out.println("Number of ways = " + countWaysUtilDP(s+1, m));
	}
}
