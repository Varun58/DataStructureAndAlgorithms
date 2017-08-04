package stacks;

import java.util.Stack;

public class ReverseStackUsingPushAndPop {
	
	public static void reverseUsingSingleStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int temp = stack.pop();
		reverseUsingSingleStack(stack);
		insertIntoBottom(stack,temp);
	}

	private static void insertIntoBottom(Stack<Integer> stack, int temp) {
		if(stack.isEmpty())
		{
			stack.push(temp);	
			return;
		}
		int data = stack.pop();
		insertIntoBottom(stack, temp);
		stack.push(data);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		reverseUsingSingleStack(stack);
		
		while(!stack.isEmpty())
		System.out.println(stack.pop());
		
		
	}
}
