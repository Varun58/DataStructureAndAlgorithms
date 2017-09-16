package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesAtSameLevel {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		printNodesByDepth(bt.root);
	}

	public static void printNodesByDepth(Node n) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		int level = 1;
		while (!q.isEmpty()) {

			int size = q.size();

			System.out.println("\nAll nodes at depth : " + level);

			while (size-- > 0) {

				Node node = q.poll();
				System.out.print(" "+ node.data + " ");

				if (null != node.left) {
					q.add(node.left);
				}

				if (null != node.right) {
					q.add(node.right);
				}
			}
			level++;
		}
	}
}
