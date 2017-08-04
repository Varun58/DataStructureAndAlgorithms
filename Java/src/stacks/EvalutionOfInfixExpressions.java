package stacks;

import java.util.Stack;

//Work needs to be done to add operator precedence
public class EvalutionOfInfixExpressions {

	public static void main(String[] args) {
		String input = "(1+2)*3+6/5";
		System.out.println(infixEvaluation(input));
	}

	public static int infixEvaluation(String input) {
		Stack<String> operatorSt = new Stack<String>();
		Stack<String> operandSt = new Stack<String>();

		StringBuilder sb = null;
		int i = input.length() - 1;
		while( i >= 0) {
			if (isOperator(input.charAt(i))) {
				operatorSt.push(String.valueOf(input.charAt(i)));
				i--;
			} else if (isBracket(input.charAt(i))) {
				operandSt.push(String.valueOf(input.charAt(i)));
				i--;
			} else {
				sb = new StringBuilder("");
				while(!isBracket(input.charAt(i)) && !isOperator(input.charAt(i))) {
					sb.append(String.valueOf(input.charAt(i)));
					i--;
				}
				operandSt.push(sb.toString());
			}
		}

		String opnd1 = "";
		String opnd2 = "";

		while (!operandSt.isEmpty() && !operatorSt.isEmpty()) {

			String op = operatorSt.pop();

			if (operandSt.peek().equals("(") || operandSt.peek().equals("[") || operandSt.peek().equals("{")) {
				while (!operandSt.peek().equals(")")) {
					operandSt.pop();
					opnd1 = operandSt.pop();
					opnd2 = operandSt.pop();
				}
				operandSt.pop();
			} else {
				opnd1 = operandSt.pop();
				opnd2 = operandSt.pop();
			}

			operandSt.push(evaluate(opnd1, opnd2, op).toString());
		}

		return 0;
	}

	public static Integer evaluate(String ch1, String ch2, String op) {

		int value1 = Integer.parseInt(ch1);
		int value2 = Integer.parseInt(ch2);

		switch (op) {
		case "/":
			return value1 / value2;
		case "*":
			return value1 * value2;
		case "+":
			return value1 + value2;
		case "-":
			return value1 - value2;

		}

		return 0;
	}

	public static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	public static boolean isBracket(char ch) {
		return ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}';
	}
}
