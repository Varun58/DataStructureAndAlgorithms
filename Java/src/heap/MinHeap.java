package heap;

public class MinHeap {

	private int[] heap;
	private int size;
	private int maxSize;

	private static final int FRONT = 1;

	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		this.heap = new int[maxSize + 1];
		heap[0] = Integer.MIN_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int left(int pos) {
		return pos * 2;
	}

	private int right(int pos) {
		return pos * 2 + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= size / 2 && pos <= size) {
			return true;
		}
		return false;
	}

	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (heap[pos] > heap[left(pos)] || heap[pos] > heap[right(pos)]) {
				if (heap[left(pos)] < heap[right(pos)]) {
					swap(pos, left(pos));
					minHeapify(left(pos));
				} else {
					swap(pos, right(pos));
					minHeapify(right(pos));
				}
			}
		}
	}

	public void minHeap() {
		for (int i = size / 2; i >= 1; i--) {
			minHeapify(i);
		}
	}

	public int remove() {
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		minHeapify(FRONT);
		return popped;
	}

	public void insert(int element) {
		heap[++size] = element;
		int current = size;

		while (heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
		}
	}

	private void swap(int fpos, int spos) {
		int temp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = temp;
	}
	
	public void print() {
		
		for(int i=1;i<=size/2;i++) {
			System.out.println("Parent : "+heap[i] + " Left : "+ heap[2*i] + " right : "+ heap[2*i+1] );
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
        System.out.println("The Min val is " + minHeap.remove());
	}
}
