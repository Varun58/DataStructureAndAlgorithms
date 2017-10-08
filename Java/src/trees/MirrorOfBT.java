package trees;

public class MirrorOfBT {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.getBT();
		bt.print(bt.root);
		mirror(bt.root);
		System.out.println("\nMirror Tree : ");
		bt.print(bt.root);
	}

	static Node mirror(Node root) {
		if (root == null) {
			return null;
		}

		Node left = mirror(root.left);
		Node right = mirror(root.right);
		
		root.left = right;
		root.right = left;
		return root;
	}
}
