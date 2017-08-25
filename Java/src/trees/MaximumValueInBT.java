package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumValueInBT {

	public static int max = 0;

	public static void getMax(Node node) {
		if (node == null)
			return;
		if (node.data > max) {
			max = node.data;
		}
		getMax(node.left);
		getMax(node.right);
		return;
	}

	public static void getMaxNonRecursive(Node node) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int max = 0;
		while (!q.isEmpty()) {
			Node qnode = q.poll();

			/*
			 * if (qnode == null) { continue; }
			 */
			if (qnode.data > max) {
				max = qnode.data;
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
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		getMax(root);
		System.out.println("Recursive solution gives max value :" + max);
		System.out.println("");

		getMaxNonRecursive(root);
	}

}
