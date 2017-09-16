package trees;

public class BinaryTree {

	Node root;

	public BinaryTree(int data) {
		this.root = new Node(data);
	}

 public BinaryTree() {
		// TODO Auto-generated constructor stub
	}

public static  BinaryTree getBT() {
		BinaryTree tree = new BinaryTree(1);

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		return tree;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
	}

}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
	
}
