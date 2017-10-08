package trees.bst;

import trees.bst.BinarySearchTree.Node;

public class CheckTreeIsBst {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.root = new Node(4);

		bst.root.left = new Node(2);
		bst.root.left.left = new Node(1);
		bst.root.left.right = new Node(3);

		bst.root.right = new Node(5);

		System.out.println(isBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	static boolean isBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.data > max || root.data < min) {
			return false;
		}

		return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
	}
}
