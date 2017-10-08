package trees;

public class InorderTraversalTrees {

	static void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data+ " ");
			inOrderTraversal(node.right);
		}

	}

}
