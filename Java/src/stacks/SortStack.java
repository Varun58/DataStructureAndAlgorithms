package stacks;

import java.util.Stack;

public class SortStack {

	public static Stack<Integer> sort(Stack<Integer> stk) {

		Stack<Integer> rstk = new Stack<Integer>();

		while (!stk.isEmpty()) {
			int tmp = stk.pop();
			while (!rstk.isEmpty() && tmp < rstk.peek()) {
				stk.push(rstk.pop());
			}
			rstk.push(tmp);
		}

		return rstk;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(7);
		stack.push(3);
		stack.push(0);
		stack.push(6);
		stack.push(9);
		stack.push(4);
		stack = sort(stack);
		stack.forEach(System.out::println);
	}
}
