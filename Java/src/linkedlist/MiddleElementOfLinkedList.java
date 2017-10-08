package linkedlist;

public class MiddleElementOfLinkedList {

	Node head;

	public static void main(String[] args) {
		MiddleElementOfLinkedList ll = new MiddleElementOfLinkedList();

		ll.head = new Node(1);
		ll.head.next = new Node(2);
		ll.head.next.next = new Node(3);
		ll.head.next.next.next = new Node(4);
		ll.head.next.next.next.next = new Node(5);
		ll.head.next.next.next.next.next = new Node(6);

		getMiddleElementUsingTwoPtr(ll.head);
		getMiddleElementUsingLength(ll.head);
		getMiddleElementUsingOneCounter(ll.head);
	}

	static void getMiddleElementUsingTwoPtr(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		System.out.println("Middle Element is " + slow.data);
	}

	static void getMiddleElementUsingLength(Node head) {
		Node fast = head;
		int count = 0;
		while (fast != null) {
			fast = fast.next;
			count++;
		}

		fast = head;
		int ctr = count / 2;
		while (ctr-- > 0) {
			fast = fast.next;
		}

		System.out.println("Middle Element is " + fast.data);
	}

	static void getMiddleElementUsingOneCounter(Node head) {
		Node fast = head;
		int count = 1;
		while (head != null) {
			if (count % 2 == 0) {
				fast = fast.next;
			} 
			count++;
			head = head.next;
		}

		System.out.println("Middle Element is " + fast.data);
	}

	static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [next=" + next + ", data=" + data + "]";
		}
	}
}
