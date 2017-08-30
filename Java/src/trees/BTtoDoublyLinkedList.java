package trees;

public class BTtoDoublyLinkedList {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.getBT();

		Node head = null;
		Node prev = null;

		converToDoublyLinkedList(bt.root, head, prev);

		Node curr = head;

		prev.right = head;
		head.left = prev;

		while (curr.right != head) {
			System.out.println(curr.data);
			curr = curr.right;
		}

		System.out.println(curr.data);

		System.out.println("prev" + prev.data);

	}

	public static void converToDoublyLinkedList(Node node, Node head, Node prev) {

		if (node == null)
			return;

		converToDoublyLinkedList(node.left, head, prev);

		if (prev == null) {
			head = node;
		} else {

			node.left = prev;
			prev.right = node;

		}
		prev = node;

		converToDoublyLinkedList(node.right, head, prev);
	}

}
