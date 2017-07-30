package trees;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversalTrees {

	public void inOrderTraversal(Node node) {
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.data);
			inOrderTraversal(node.right);
		}
		
	}
	
	public void inOrderTraversalIterative(Node node) {
		
		ArrayList<Integer> processArr = new ArrayList<Integer>();
		
		Stack<Node> stack = new Stack<Node>();
		
	}
	
	
}
