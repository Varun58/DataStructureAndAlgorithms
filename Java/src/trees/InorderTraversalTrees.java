package trees;

public class InorderTraversalTrees {

	static void inOrderTraversal(TreeNode treeNode) {
		if (treeNode != null) {
			inOrderTraversal(treeNode.left);
			System.out.print(treeNode.val + " ");
			inOrderTraversal(treeNode.right);
		}

	}

}
