package trees;

public class InsertingElementInBT {

	public static TreeNode insertingElementInBT(TreeNode treeNode, int data) {

		if (treeNode == null) {
			treeNode = new TreeNode(data);
			return treeNode;
		}

		if (treeNode.left == null) {
			
			treeNode.left = new TreeNode(data);
			return treeNode;
			
		} else if(treeNode.left != null)  {
			
			insertingElementInBT(treeNode.left, data);
		} 
		else if (treeNode.right == null) {
			
			treeNode.right = new TreeNode(data);
			return treeNode;
			
		} else if(treeNode.right != null)  {
			
			insertingElementInBT(treeNode.right, data);
		}
		return treeNode;
	}

	public static void inOrderTraversal(TreeNode treeNode) {
		if (treeNode != null) {
			
			System.out.println("Parent: "+ treeNode.data + " ");
			
			
			if(treeNode.left != null ) {
				System.out.println("Left: "+ treeNode.left.data + " ");
			}
			if(treeNode.right!= null) {
				System.out.println("Right: "+ treeNode.right.data + " ");
			}
			
			inOrderTraversal(treeNode.left);
			
			inOrderTraversal(treeNode.right);
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
