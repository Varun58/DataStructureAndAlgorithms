package queues;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

	public static class MyQueue<T> {
		Stack<T> stk1 = new Stack<T>();
		Stack<T> stk2 = new Stack<T>();

		public void enqueue(T value) { // Push onto newest stack
			if (value == null)
				return;
			stk1.push(value);
		}

		public T peek() {
			if (stk2.isEmpty()) {
				while (!stk1.isEmpty()) {
					stk2.push(stk1.pop());
				}
			}
			return stk2.peek();
		}

		public T dequeue() {
			if (stk2.isEmpty()) {
				while (!stk1.isEmpty()) {
					stk2.push(stk1.pop());
				}
			}
			return stk2.pop();
		}
	}

		public static void main(String[] args) {
			MyQueue<Integer> queue = new MyQueue<Integer>();

			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();

			for (int i = 0; i < n; i++) {
				int operation = scan.nextInt();
				if (operation == 1) { // enqueue
					queue.enqueue(scan.nextInt());
				} else if (operation == 2) { // dequeue
					queue.dequeue();
				} else if (operation == 3) { // print/peek
					System.out.println(queue.peek());
				}
			}
			scan.close();
		}
}
