package trees;

public class InsertingElementInBT {

	public static Node insertingElementInBT(Node node, int data) {

		if (node == null) {
			node = new Node(data);
			return node;
		}

		if (node.left == null) {
			
			node.left = new Node(data);
			return node;
			
		} else if(node.left != null)  {
			
			insertingElementInBT(node.left, data);	
		} 
		else if (node.right == null) {
			
			node.right = new Node(data);
			return node;
			
		} else if(node.right != null)  {
			
			insertingElementInBT(node.right, data);	
		}
		return node;
	}

	public static void inOrderTraversal(Node node) {
		if (node != null) {
			
			System.out.println("Parent: "+node.data + " ");
			
			
			if(node.left != null ) {
				System.out.println("Left: "+node.left.data + " ");	
			}
			if(node.right!= null) {
				System.out.println("Right: "+node.right.data + " ");
			}
			
			inOrderTraversal(node.left);
			
			inOrderTraversal(node.right);
		}

	}

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.getBT();
		insertingElementInBT(tree.root, 17);
		insertingElementInBT(tree.root, 22);
		insertingElementInBT(tree.root, 62);
		insertingElementInBT(tree.root, 32);
		insertingElementInBT(tree.root, 9);
		inOrderTraversal(tree.root);

	}
}
