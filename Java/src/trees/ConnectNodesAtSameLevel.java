package trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		connectNodesAtSameLevelUsingQueue(bt.root);
		System.out.println();
		printAllNodesNextRight(bt.root);
	}

	private static void printAllNodesNextRight(Node root) {
		if(root == null) return;
		
		System.out.println(root.data +" ==> "+root.nextRight);
		printAllNodesNextRight(root.left);
		printAllNodesNextRight(root.right);
	}

	public static void connectNodesAtSameLevelUsingQueue(Node n) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		int level = 0;
		while (!q.isEmpty()) {

			int size = q.size();

			System.out.println("\nAll nodes at depth : " + level + "\n");

			while (size-- > 0) {

				Node node = q.poll();
				Node nextR = null;

				if (size != 0) {
					nextR = q.peek();
				}
				
				if (nextR != null) {
					node.nextRight = nextR;
					System.out.print("\n Next Right of  " + node.data + " is : " + nextR.data);
				} else {
					System.out.print("\n Next Right of  " + node.data + " is : " + -1);
				}

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
	
	public static void connectNodesAtSameLevelRec(Node n) {
		
	}
}
