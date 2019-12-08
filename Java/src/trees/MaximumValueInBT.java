package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumValueInBT {

	public static int max = 0;

	public static void getMax(TreeNode treeNode) {
		if (treeNode == null)
			return;
		if (treeNode.val > max) {
			max = treeNode.val;
		}
		getMax(treeNode.left);
		getMax(treeNode.right);
		return;
	}

	public static void getMaxNonRecursive(TreeNode treeNode) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(treeNode);
		int max = 0;
		while (!q.isEmpty()) {
			TreeNode qnode = q.poll();

			/*
			 * if (qnode == null) { continue; }
			 */
			if (qnode.val > max) {
				max = qnode.val;
			}

			if (qnode.left != null) {
				q.add(qnode.left);
			}

			if (qnode.right != null) {
				q.add(qnode.right);
			}
		}

		System.out.println("Non Recursive solution gives max value :" + max);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		getMax(root);
		System.out.println("Recursive solution gives max value :" + max);
		System.out.println("");

		getMaxNonRecursive(root);
	}

}
