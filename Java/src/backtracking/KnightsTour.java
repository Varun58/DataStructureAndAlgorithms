package backtracking;

public class KnightsTour {

	static int N = 8;

	static boolean isSafe(int x, int y, int sol[][]) {
		return x < N && y < N && x >= 0 && y >= 0 && sol[x][y] == -1;
	}

	static boolean KT() {
		int sol[][] = new int[8][8];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sol[i][j] = -1;
			}
		}

		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		sol[0][0] = 0;

		if (!solveKTUtil(sol, 0, 0, 1, xMove, yMove)) {
			return false;
		} else {
			print(sol);
			return true;
		}
	}

	private static boolean solveKTUtil(int[][] sol, int row, int col, int k, int[] xMove, int[] yMove) {

		if (k == N * N) {
			return true;
		}

		for (int x = 0; x < 8; x++) {

			if (isSafe(row + xMove[x], col + yMove[x], sol)) {

				sol[row + xMove[x]][col + yMove[x]] = k;
				if (solveKTUtil(sol, row + xMove[x], col + yMove[x], k + 1, xMove, yMove)) {
					return true;
				} else {
					sol[row + xMove[x]][col + yMove[x]] = -1;
				}
			}
		}

		return false;
	}

	public static void print(int sol[][]) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		KT();
	}
}
