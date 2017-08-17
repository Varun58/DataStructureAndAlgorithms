package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Pipes {

	public static void main(String[] args) {

	}

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
}
