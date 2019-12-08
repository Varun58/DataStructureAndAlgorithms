package trees;

import java.util.LinkedList;

public class PathSum {

  public boolean hasPathSum2(TreeNode root, int sum) {
    if(root == null) {
      return false;
    }

    sum -= root.val;
    if(root.left == null && root.right == null) {
      return sum == 0;
    }

    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }

  public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null) {
      return false;
    }

    LinkedList<TreeNode> nodeStack = new LinkedList<>();
    LinkedList<Integer> sumStack = new LinkedList<>();

    nodeStack.add(root);
    sumStack.add(sum - root.val);

    while(!nodeStack.isEmpty()) {
      TreeNode node = nodeStack.pollLast();
      int currSum = sumStack.pollLast();
      if(node.left == null && node.right == null && currSum == 0) {
        return true;
      }

      if(node.right != null) {
        nodeStack.add(node.right);
        sumStack.add(currSum - node.right.val);
      }

      if(node.left != null) {
        nodeStack.add(node.left);
        sumStack.add(currSum - node.left.val);
      }
    }
    return false;
  }
}
