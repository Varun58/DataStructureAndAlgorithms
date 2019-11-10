package trees;

public class MirrorOfBT {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.getBT();
		bt.print(bt.root);
		mirror(bt.root);
		System.out.println("\nMirror Tree : ");
		bt.print(bt.root);
	}

	static TreeNode mirror(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode left = mirror(root.left);
		TreeNode right = mirror(root.right);
		
		root.left = right;
		root.right = left;
		return root;
	}
}
