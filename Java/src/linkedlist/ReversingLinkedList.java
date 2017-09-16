package linkedlist;

public class ReversingLinkedList {

	Node head;

	public static void main(String[] args) {
		ReversingLinkedList rl = new ReversingLinkedList();
		rl.head = new Node(85);
		rl.head.next = new Node(15);
		rl.head.next.next = new Node(4);
		rl.head.next.next.next = new Node(20);

		rl.print(rl.head);
		System.out.println();
		
		System.out.println("Iterative reverse :  ");
		
		rl.head = rl.reverseIter(rl.head);
		rl.print(rl.head);

		System.out.println();

		System.out.println("Recursive reverse :  ");
		rl.reverseRec(rl.head, null);
		rl.print(rl.head);

	}

	public void print(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	public Node reverseIter(Node head) {
		Node curr = head;
		Node temp = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = temp;
			temp = curr;
			curr = next;
		}
		head = temp;
		return head;
	}

	public Node reverseRec(Node node, Node prev) {
		if (node.next == null) {
			head = node;
			node.next = prev;
			return node;
		}

		Node next = node.next;
		node.next = prev;

		reverseRec(next, node);
		
		return node;
	}

	static class Node {

		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

}
