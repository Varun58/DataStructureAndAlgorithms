package trees;

public class IsomorphicTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		// Let us create trees shown in above diagram
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.left.right.left = new Node(7);
		tree.root.left.right.right = new Node(8);

		BinaryTree tree1 = new BinaryTree();

		tree1.root = new Node(1);
		tree1.root.left = new Node(3);
		tree1.root.right = new Node(2);
		tree1.root.right.left = new Node(4);
		tree1.root.right.right = new Node(5);
		tree1.root.left.right = new Node(6);
		tree1.root.right.right.left = new Node(8);
		tree1.root.right.right.right = new Node(7);

		System.out.println(isIsomorphic(tree.root, tree1.root));
	}

	public static boolean isIsomorphic(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			return true;
		}

		if (n1 == null || n2 == null)
			return false;

		if (n1.data != n2.data)
			return false;

		return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
				|| (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
	}
}
