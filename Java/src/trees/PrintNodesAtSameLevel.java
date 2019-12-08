package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesAtSameLevel {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.right.left = new TreeNode(6);
		bt.root.right.right = new TreeNode(7);
		printNodesByDepth(bt.root);
	}

	public static void printNodesByDepth(TreeNode n) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(n);
		int level = 1;
		while (!q.isEmpty()) {

			int size = q.size();

			System.out.println("\nAll nodes at depth : " + level);

			while (size-- > 0) {

				TreeNode treeNode = q.poll();
				System.out.print(" "+ treeNode.val + " ");

				if (null != treeNode.left) {
					q.add(treeNode.left);
				}

				if (null != treeNode.right) {
					q.add(treeNode.right);
				}
			}
			level++;
		}
	}
}
