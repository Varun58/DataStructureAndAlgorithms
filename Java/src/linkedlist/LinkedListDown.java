package linkedlist;

public class LinkedListDown {
	DownNode head;

	static class DownNode {
		DownNode next;
		DownNode down;
		int data;

		public DownNode(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [next=" + next + ", down=" + down + ", data=" + data + "]";
		}

		
	}

	@Override
	public String toString() {
		return "LinkedListDown [head=" + head + "]";
	}
	
	
}

