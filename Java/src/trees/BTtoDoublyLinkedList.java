package trees;

public class BTtoDoublyLinkedList {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.getBT();

		TreeNode head = null;
		TreeNode prev = null;

		converToDoublyLinkedList(bt.root, head, prev);

		TreeNode curr = head;

		prev.right = head;
		head.left = prev;

		while (curr.right != head) {
			System.out.println(curr.data);
			curr = curr.right;
		}

		System.out.println(curr.data);

		System.out.println("prev" + prev.data);

	}

	public static void converToDoublyLinkedList(TreeNode treeNode, TreeNode head, TreeNode prev) {

		if (treeNode == null)
			return;

		converToDoublyLinkedList(treeNode.left, head, prev);

		if (prev == null) {
			head = treeNode;
		} else {

			treeNode.left = prev;
			prev.right = treeNode;

		}
		prev = treeNode;

		converToDoublyLinkedList(treeNode.right, head, prev);
	}

}
