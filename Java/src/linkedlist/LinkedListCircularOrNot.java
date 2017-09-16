package linkedlist;

public class LinkedListCircularOrNot {

	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		LinkedListCircularOrNot ll = new LinkedListCircularOrNot();
		ll.head = new Node(2);
		ll.head.next = new Node(5);
		ll.head.next.next = new Node(7);
		ll.head.next.next.next = new Node(8);
		ll.head.next.next.next.next = new Node(10);
		ll.head.next.next.next.next.next = ll.head;

		System.out.println(isListCircular(ll.head));
	}

	public static boolean isListCircular(Node head) {
		
		if(head == null)return true;
		
		Node curr = head.next;

		while (curr != null && curr!= head) {
			curr = curr.next;
		}

		return curr == head;
	}
}
