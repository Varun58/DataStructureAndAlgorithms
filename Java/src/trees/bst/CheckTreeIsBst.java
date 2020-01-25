package trees.bst;

import trees.bst.BinarySearchTree.Node;

import java.util.Stack;
import javax.swing.tree.TreeNode;

public class CheckTreeIsBst {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();

    bst.root = new Node(-2);

    bst.root.left = new Node(1);
    bst.root.right = new Node(3);

    System.out.println(isValidBST(bst.root));
  }

  public static boolean isValidBST(Node root) {
    return helper(root, null, null);
  }

  public static boolean helper(Node node, Integer lower, Integer upper) {
    if (node == null) {
      return true;
    }

    int val = node.data;
    if (lower != null && val <= lower) {
      return false;
    }
    if (upper != null && val >= upper) {
      return false;
    }

    if (!helper(node.right, val, upper)) {
      return false;
    }
    if (!helper(node.left, lower, val)) {
      return false;
    }
    return true;
  }

	public static boolean isValidBST2(Node root) {
		Stack<Node> stack = new Stack<>();
		int inOrderValue = Integer.MIN_VALUE;

		while(!stack.isEmpty() || root != null) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			if(root.data <= inOrderValue) {
				 return false;
			}

			inOrderValue = root.data;
			root = root.right;
		}
  	return true;
	}


  // does not work for [-2147483648, -2147483648]
  // so dont use this solution
  //static boolean isBST(Node root, int min, int max) {
  //  if (root == null) {
  //    return true;
  //  }
  //
  //  if (root.data > max || root.data < min) {
  //    return false;
  //  }
  //
  //  return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
  //}
}
