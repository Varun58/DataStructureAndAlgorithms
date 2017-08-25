package heap;

import java.util.Arrays;

public class MinHeap {
	
	//http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
	//Method 1 (Use Bubble k times)
	//Method 2 (Use Sorting)
	//Method 3 Use temporary array
	//Method 4 Min or Max Heap
	
	/*
	1) Heap Sort: Heap Sort uses Binary Heap to sort an array in O(nLogn) time.

	2) Priority Queue: Priority queues can be efficiently implemented using Binary Heap because it supports insert(), delete() and extractmax(), decreaseKey() operations in O(logn) time. Binomoial Heap and Fibonacci Heap are variations of Binary Heap. These variations perform union also efficiently.

	3) Graph Algorithms: The priority queues are especially used in Graph Algorithms like Dijkstra’s Shortest Path and Prim’s Minimum Spanning Tree.
	
	4) Many problems can be efficiently solved using Heaps. See following for example.
		a) K’th Largest Element in an array.
		b) Sort an almost sorted array/
		c) Merge K Sorted Arrays.
	*/

	private int[] heap;
	public int size;
	private int maxSize;

	private static final int FRONT = 0;

	public MinHeap(int capacity) {
		this.maxSize = capacity;
		this.size = 0;
		this.heap = new int[capacity];
	}

	private int parent(int pos) {
		return (pos-1) / 2;
	}

	private int left(int pos) {
		return (pos * 2) + 1;
	}

	private int right(int pos) {
		return (pos * 2) + 2;
	}

	private void minHeapify(int pos) {
		
		int smallest = pos;
		int left = left(pos);
		int right = right(pos);
		
		if (left<size &&  heap[smallest] > heap[left]) {
			smallest = left;
		}
		
		if(right<size &&  heap[smallest] > heap[right]){
			smallest = right;
		}
		
		if(pos!=smallest) {
			swap(pos, smallest);
			minHeapify(smallest);	
		}
		
	}

	public void minHeap() {
		for (int i = (size-1) / 2; i >= 0; i--) {
			minHeapify(i);
		}
	}

	public int extractMin() {
		if(size == 0 ) {
			return -1;
		}
		int popped = heap[FRONT];
		heap[FRONT] = heap[--size];
		minHeapify(FRONT);
		return popped;
	}

	public void insert(int element) {
		size++;
		int current = size-1;

		while ( current>0 && element < heap[parent(current)]) {
			heap[current] = heap[parent(current)];
			current = parent(current);
		}
		
		heap[current] = element;
	}

	private void swap(int fpos, int spos) {
		int temp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = temp;
	}
	
	public void print() {
		
		for(int i=0;i<=size/2;i++) {
			System.out.println("Parent : "+heap[i] + " Left : "+ heap[2*i+1] + " right : "+ heap[2*i+2] );
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();
 
        minHeap.print();
        System.out.println("The Min val is " + minHeap.extractMin());
	}

	@Override
	public String toString() {
		return "MinHeap [heap=" + Arrays.toString(heap) + ", size=" + size + ", maxSize=" + maxSize + "]";
	}
	
	
}
