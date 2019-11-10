package trees;

public class IsomorphicTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		// Let us create trees shown in above diagram
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.left.right.left = new TreeNode(7);
		tree.root.left.right.right = new TreeNode(8);

		BinaryTree tree1 = new BinaryTree();

		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(3);
		tree1.root.right = new TreeNode(2);
		tree1.root.right.left = new TreeNode(4);
		tree1.root.right.right = new TreeNode(5);
		tree1.root.left.right = new TreeNode(6);
		tree1.root.right.right.left = new TreeNode(8);
		tree1.root.right.right.right = new TreeNode(7);

		System.out.println(isIsomorphic(tree.root, tree1.root));
	}

	public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
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
