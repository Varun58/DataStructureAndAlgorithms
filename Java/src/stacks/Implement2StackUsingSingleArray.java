package stacks;

import java.util.Arrays;

public class Implement2StackUsingSingleArray {

	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks();

		for (int i = 0; i < 10; i++) {
			ts.push(1, i);
		}

		for (int i = 0; i < 10; i++) {
			ts.push(2, i);
		}

	}
}

class TwoStacks {

	private int stack[];
	private int top1;
	private int top2;
	private int size1;
	private int size2;
	private int maxSize;
	private static final int DEFAULT_SIZE = 20;

	public TwoStacks(int size) {
		this.stack = new int[size];
		this.maxSize = size;
		this.top1 = -1;
		this.top2 = size;
	}

	public TwoStacks() {
		this.stack = new int[DEFAULT_SIZE];
		this.maxSize = DEFAULT_SIZE;
		this.top1 = -1;
		this.top2 = DEFAULT_SIZE;
	}

	public boolean push(int stackId, int e) {
		if (stackId == 1) {
			if (top1 + 1 == top2) {
				System.out.println(" Stack is full ");
				return false;
			}
			stack[++top1] = e;
			size1++;
		} else if (stackId == 2) {
			if (top2  == top1+1) {
				System.out.println(" Stack 2 is full ");
				return false;
			}
			stack[--top2] = e;
			size2++;
		} else {
			System.out.println(" Wrong stackId ");
		}
		return true;
	}

	public int pop(int stackId) {
		int e = -1;
		if (stackId == 1) {
			if (top1 < 0) {
				System.out.println("First Stack is empty");
				return -1;
			}
			e = stack[top1];
			stack[top1] = -1;
			top1--;
			size1--;
		} else if (stackId == 2) {
			if (top2 == maxSize - 1) {
				System.out.println("First Stack is empty");
				return -1;
			}
			e = stack[top2];
			stack[top2] = -1;
			top2++;
			size2--;
		}

		return e;
	}

	public int peek(int stackId) {
		int e = -1;
		if (stackId == 1) {
			if (top1 < 0) {
				System.out.println("First Stack is empty");
				return -1;
			}
			e = stack[top1];
		} else if (stackId == 2) {
			if (top2 == maxSize - 1) {
				System.out.println("First Stack is empty");
				return -1;
			}
			e = stack[top2];
		}
		return e;
	}

	@Override
	public String toString() {
		return "TwoStacks [stack=" + Arrays.toString(stack) + ", top1=" + top1 + ", top2=" + top2 + ", size1=" + size1
				+ ", size2=" + size2 + ", maxSize=" + maxSize + "]";
	}

}
