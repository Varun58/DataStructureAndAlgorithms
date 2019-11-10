package trees;

public class BinaryTree {

	TreeNode root;

	public BinaryTree() {
	}

	public static BinaryTree getBT() {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		return tree;
	}

	static void print(TreeNode treeNode) {
		if (treeNode != null) {
			System.out.print(treeNode.data+ " ");
			print(treeNode.left);
			print(treeNode.right);
		}

	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
	}

}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode nextRight;

	public TreeNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}
