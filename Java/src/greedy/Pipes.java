package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

import heap.MinHeap;

public class Pipes {

	public static int[] getJoinedPipes(int[] input1) {

		if (input1 == null || input1.length <= 1) {
			return new int[1];
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < input1.length; i++) {
			pq.offer(input1[i]);
		}

		while (pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			al.add(first + second);
			pq.offer(first + second);
		}

		int op[] = new int[al.size()];

		for (int i = 0; i < op.length; i++) {
			op[i] = al.get(i);
		}
		return op;
	}

	public static int minCost(int arr[], int n) {
		if (arr == null || n <= 1) {
			return 0;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int result = 0;

		for (int i = 0; i <n; i++) {
			pq.offer(arr[i]);
		}

		while (pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			result += first + second;
			pq.offer(first + second);
		}

		return result;
	}
	
	public static int minCostUsingMinHeap(int arr[], int n) {
		if (arr == null || n <= 1) {
			return 0;
		}

		MinHeap mh = new MinHeap(n);

		int result = 0;

		for (int i = 0; i <n; i++) {
			mh.insert(arr[i]);
		}
		
		mh.minHeap();

		while (mh.size !=1 ) {
			int first = mh.extractMin();
			int second = mh.extractMin();
			int sum = first + second;
			result += sum;
			mh.insert(sum);
		}

		return result;
	}
	
	public static void main(String[] args) {
		int len[] = {4, 3, 2, 6};
	    int size = len.length;
	    System.out.println("Total cost for connecting ropes is "+ minCost(len, size));
	    System.out.println("Total cost for connecting ropes using minheap is "+ minCostUsingMinHeap(len, size));
	}
}
