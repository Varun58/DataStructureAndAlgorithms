package queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

	private Queue<Integer> queue1 = new LinkedList<Integer>();
	private Queue<Integer> queue2 = new LinkedList<Integer>();

	public StackUsingTwoQueues() {
	}

	public void push(int ele) {
		queue1.offer(ele);
	}

	public Integer pop() {

		if (!queue1.isEmpty()) {
			/*int position = queue1.size() - 2;*/
			while (queue1.size() != 1) {
				queue2.offer(queue1.poll());
			}
			return queue1.poll();
		} else {
			/*int position = queue2.size() - 2;*/
			while (queue2.size() != 1) {
				queue1.offer(queue2.poll());
			}
			return queue2.poll();
		}
	}

	public Integer peek() {

		if (!queue1.isEmpty()) {
			while (queue1.size() != 1) {
				queue2.offer(queue1.poll());
			}
			return queue1.peek();
		} else {
			while (queue2.size() != 1) {
				queue1.offer(queue2.poll());
			}
			return queue2.peek();
		}
	}

	public static void main(String[] args) {
		StackUsingTwoQueues stk = new StackUsingTwoQueues();
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(40);
		stk.push(50);
		
		System.out.println(stk.peek());
		
		stk.push(60);
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.peek());
		
		
		
	}
}
