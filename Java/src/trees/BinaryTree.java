package trees;

public class BinaryTree {

	Node root;

	public BinaryTree() {
	}

	public static BinaryTree getBT() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		return tree;
	}

	static void print(Node node) {
		if (node != null) {
			System.out.print(node.data+ " ");
			print(node.left);
			print(node.right);
		}

	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
	}

}

class Node {
	int data;
	Node left;
	Node right;
	Node nextRight;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}
