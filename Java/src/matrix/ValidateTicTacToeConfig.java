package matrix;

public class ValidateTicTacToeConfig {

	public static void main(String[] args) {

		char board[] = { 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X' };
		System.out.println(validateTicTacToeBoard(board));
	}

	public static boolean cWins(char[] board, char c) {
		int wins[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
				{ 2, 4, 6 } };

		for (int i = 0; i < 8; i++) {
			if (board[wins[i][0]] == c && board[wins[i][1]] == c && board[wins[i][2]] == c) {
				return true;
			}
		}
		return false;
	}

	public static boolean validateTicTacToeBoard(char[] board) {

		int xCount = 0, oCount = 0;

		for (int i = 0; i < board.length; i++) {
			if (board[i] == 'X') {
				xCount++;
			} else {
				oCount++;
			}
		}

		if ((xCount == oCount) || (xCount == oCount + 1)) {
			if (cWins(board, 'O')) {
				if (cWins(board, 'X')) {
					return false;
				}

				return xCount == oCount;
			}

			if (cWins(board, 'X') && xCount != oCount + 1)
				return false;

			return true;
		}

		return false;
	}
}
