package heap;

public class MaxHeap {

	private int heap[];
	private int size;
	private int capacity;

	private static final int FRONT = 0;

	public MaxHeap(int capacity) {
		this.capacity = capacity;
		this.heap = new int[capacity];
		this.size = 0;
	}

	public void createMaxHeap(int arr[]) {

	}

	private int left(int pos) {
		return pos * 2 + 1;
	}

	private int right(int pos) {
		return pos * 2 + 2;
	}

	private int parent(int pos) {
		return (pos - 1) / 2;
	}

	public int getMax() {
		return heap[FRONT];
	}

	public void maxHeapify(int pos) {
		int largest = pos;
		int left = left(pos);
		int right = right(pos);

		if (left < size && heap[largest] < heap[left]) {
			largest = left;
		}

		if (right < size && heap[largest] < heap[right]) {
			largest = right;
		}

		if (largest != pos) {
			int temp = heap[pos];
			heap[pos] = heap[largest];
			heap[largest] = temp;

			maxHeapify(largest);
		}
	}

	public void decreaseKey(int i, int newValue) {
		System.out.println("Decreasing Value of "+ heap[i]);
		heap[i] = newValue;
		System.out.println("New Value of "+ heap[i]);
		int current = i;
		while (current != 0  && heap[current] > heap[parent(current)]) {
			int temp = heap[current];
			heap[current] = heap[parent(current)];
			heap[parent(current)] = temp;

			current = parent(current);
		}
		maxHeapify(i);
	}

	public void insert(int data) {
		if (size == capacity - 1) {
			System.out.println("Heap is full. ");
			return;
		}

		size++;
		int current = size - 1;
		heap[current] = data;
		while (current != 0 && heap[current] > heap[parent(current)]) {
			int temp = heap[current];
			heap[current] = heap[parent(current)];
			heap[parent(current)] = temp;

			current = parent(current);
		}
	}

	public int extractMax() {
		if (size == 0) {
			return Integer.MIN_VALUE;
		}

		int data = heap[FRONT];
		heap[FRONT] = heap[size];
		size--;
		maxHeapify(FRONT);
		return data;
	}

	public void printHeap() {
		for (int i = 0; i <=size / 2 - 1; i++) {
			System.out.println(" Heap Data ==>  Parent : " + heap[i] + " with left child : " + heap[2 * i + 1]
					+ " and right child : " + heap[2 * i + 2]);
		}
	}

	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(20);
		mh.insert(3);
		mh.insert(2);
		mh.insert(1);
		mh.insert(15);
		mh.insert(5);
		mh.insert(4);
		mh.insert(45);

		mh.printHeap();
		System.out.println();
		mh.decreaseKey(1,1);
		System.out.println();
		mh.printHeap();
		/*System.out.println(mh.extractMax());
		System.out.println(mh.extractMax());
		System.out.println(mh.extractMax());
		*/System.out.println(mh.getMax());
		
		
	}
}
