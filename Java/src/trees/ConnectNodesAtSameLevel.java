package trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.right.left = new TreeNode(6);
		bt.root.right.right = new TreeNode(7);
		connectNodesAtSameLevelUsingQueue(bt.root);
		System.out.println();
		printAllNodesNextRight(bt.root);
	}

	private static void printAllNodesNextRight(TreeNode root) {
		if(root == null) return;
		
		System.out.println(root.data +" ==> "+root.nextRight);
		printAllNodesNextRight(root.left);
		printAllNodesNextRight(root.right);
	}

	public static void connectNodesAtSameLevelUsingQueue(TreeNode n) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(n);
		int level = 0;
		while (!q.isEmpty()) {

			int size = q.size();

			System.out.println("\nAll nodes at depth : " + level + "\n");

			while (size-- > 0) {

				TreeNode treeNode = q.poll();
				TreeNode nextR = null;

				if (size != 0) {
					nextR = q.peek();
				}
				
				if (nextR != null) {
					treeNode.nextRight = nextR;
					System.out.print("\n Next Right of  " + treeNode.data + " is : " + nextR.data);
				} else {
					System.out.print("\n Next Right of  " + treeNode.data + " is : " + -1);
				}

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
	
	public static void connectNodesAtSameLevelRec(TreeNode n) {
		
	}
}
