package arrays;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximElementFromEachSubarray {

	public static void getMax(int arr[], int n, int k) {

		Deque<Integer> Qi = new LinkedList<Integer>();

		int i;

		for (i = 0; i < k; i++) {

			while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
				Qi.removeLast();
			}

			Qi.addLast(i);
		}

	
		for (; i < n; i++) {
			
			System.out.print(arr[Qi.peek()]);
			
			while (!Qi.isEmpty() && Qi.peek() <= i-k) {
				Qi.removeFirst();
			}

			
			while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
				Qi.removeLast();
			}

			Qi.addLast(i);
		}

		System.out.print(arr[Qi.peek()]);
	}

	public static void getMin(int arr[], int n, int k) {

		Deque<Integer> Qi = new LinkedList<Integer>();

		int i;

		for (i = 0; i < k; i++) {

			while (!Qi.isEmpty() && arr[i] <= arr[Qi.peekLast()]) {
				Qi.removeLast();
			}

			Qi.addLast(i);
		}

	
		for (; i < n; i++) {
			
			System.out.print(arr[Qi.peek()]);
			
			while (!Qi.isEmpty() && Qi.peek() <= i-k) {
				Qi.removeFirst();
			}

			
			while (!Qi.isEmpty() && arr[i] <= arr[Qi.peekLast()]) {
				Qi.removeLast();
			}

			Qi.addLast(i);
		}

		System.out.print(arr[Qi.peek()]);
	}

	
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int size = arr.length;

		getMax(arr, size, 3);
		System.out.println();
		getMin(arr, size, 3);
	}

}
