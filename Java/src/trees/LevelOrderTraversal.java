package trees;

import java.util.ArrayList;
import java.util.List;

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
			System.out.print(treeNode.val + " " );
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

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		DFS(root, 0, results);
		return results;
	}

	public void DFS(TreeNode root, int level, List<List<Integer>> results) {
		if(root == null) {
			return;
		}
		if(level >= results.size()) {
			List<Integer> newLevel = new ArrayList<>();
			newLevel.add(root.val);
			results.add(newLevel);
		}else {
			results.get(level).add(root.val);
		}

		if(root.left!= null) {
			DFS(root.left, level + 1, results);
		}
		if(root.right!=null) {
			DFS(root.right, level + 1, results);
		}
	}
}
