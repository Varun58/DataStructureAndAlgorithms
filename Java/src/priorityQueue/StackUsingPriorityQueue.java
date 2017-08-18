package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class StackUsingPriorityQueue {

	private PriorityQueue<Pair> pq;
	private int capacity = 0;
	int size = 0;

	public StackUsingPriorityQueue(int capacity) {
		this.pq = new PriorityQueue<Pair>(capacity, Collections.reverseOrder(new PairComparator()));
		this.capacity = capacity;
	}

	public void push(int element) {
		if (size == capacity) {
			System.out.println("Stack is full");
			return;
		}
		size++;
		pq.offer(new Pair(size, element));
	}

	public int peek() {
		if (size == 0) {
			System.out.println("Stack is empty");
			return -1;
		}
		return pq.peek().value;
	}

	public int pop() {
		if (pq.isEmpty() || size == 0) {
			System.out.println("Stack is empty");
			return -1;
		}
		size--;
		return pq.poll().value;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return pq.isEmpty();
	}

	public static void main(String[] args) {

		StackUsingPriorityQueue stk = new StackUsingPriorityQueue(10);
		
		stk.push(13);
		stk.push(23);
		stk.push(7);
		stk.push(5);
		stk.push(3);

		stk.push(113);
		stk.push(123);
		stk.push(17);
		stk.push(15);
		stk.push(43);

		System.out.println(stk.peek());
		System.out.println(stk.size());
		
		while(!stk.isEmpty()) {
			System.out.println(stk.pop());	
		}
	}
}

class Pair {

	Integer order;
	Integer value;

	public Pair(int order, int value) {
		this.order = order;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pair [order=" + order + ", value=" + value + "]";
	}

}