package trees;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.getBT();
		LevelOrderTraversal lt = new LevelOrderTraversal();
		lt.printNodesLevelUsingHeight(bt.root);

	}

	public void printNodesLevelUsingHeight(TreeNode treeNode) {
		int h = height(treeNode);
		for (int i = 1; i <=h; i++) {
			printLevelOrder(treeNode, i);
		}

	}

	public void printLevelOrder(TreeNode treeNode, int level) {
		if (treeNode == null) {
			return;
		} else if (level == 1) {
			System.out.print(treeNode.data+ " " );
		} else if (level > 1) {
			printLevelOrder(treeNode.left, level - 1);
			printLevelOrder(treeNode.right, level - 1);
		}
	}

	public int height(TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		} else {
			int lh = height(treeNode.left);
			int rh = height(treeNode.right);
			if (lh > rh)
				return lh + 1;
			return rh + 1;
		}
	}
}
