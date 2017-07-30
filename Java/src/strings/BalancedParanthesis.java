package strings;

import java.util.Stack;

public class BalancedParanthesis {


	public static boolean balancedParenthesis(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}

		Stack<Character> stack = new Stack<Character>();

		for (char ch : str.toCharArray()) {
			if (ch == '[' || ch == '(' || ch == '{') {
				stack.push(ch);
			} else if (ch == ']' || ch == '}' || ch == ')') {
				if (stack.isEmpty()) {
					return false;
				} else if (!matchPair(stack.pop(), ch)) {
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		}

		return false;
	}

	private static boolean matchPair(char ch1, char ch2) {

		if (ch1 == '[' && ch2 == ']') {
			return true;
		} else if (ch1 == '(' && ch2 == ')') {
			return true;
		} else if (ch1 == '{' && ch2 == '}') {
			return true;
		}
		return false;
	}
}
