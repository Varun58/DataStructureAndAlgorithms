package trees.bst;

public class BinarySearchTree {

	Node root;
	
	

	static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
			this.left = right = null;
		}

		@Override
		public String toString() {
			return "Node [left=" + left + ", right=" + right + ", data=" + data + "]";
		}

	}
}
