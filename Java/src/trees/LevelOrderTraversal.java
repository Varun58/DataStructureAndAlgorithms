package trees;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree bt = BinaryTree.getBT();
		LevelOrderTraversal lt = new LevelOrderTraversal();
		lt.printNodesLevelUsingHeight(bt.root);

	}

	public void printNodesLevelUsingHeight(Node node) {
		int h = height(node);
		for (int i = 1; i <=h; i++) {
			printLevelOrder(node, i);
		}

	}

	public void printLevelOrder(Node node, int level) {
		if (node == null) {
			return;
		} else if (level == 1) {
			System.out.print(node.data+ " " );
		} else if (level > 1) {
			printLevelOrder(node.left, level - 1);
			printLevelOrder(node.right, level - 1);
		}
	}

	public int height(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lh = height(node.left);
			int rh = height(node.right);
			if (lh > rh)
				return lh + 1;
			return rh + 1;
		}
	}
}
