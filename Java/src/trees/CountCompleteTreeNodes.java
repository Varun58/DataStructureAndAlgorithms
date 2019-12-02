package trees;

public class CountCompleteTreeNodes {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    //root.right.right = new TreeNode(7);

    System.out.println(countNodes(root));
  }

  // https://leetcode.com/problems/count-complete-tree-nodes/discuss/61953/Easy-short-c%2B%2B-recursive-solution
  public static int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    TreeNode left = root;
    TreeNode right = root;
    int lmax = 0;
    int rmax = 0;

    while (left != null) {
      left = left.left;
      lmax++;
    }

    while (right != null) {
      right = right.right;
      rmax++;
    }

    if (lmax == rmax) {
      return (int) Math.pow(2, lmax) - 1;
    }

    return 1 + countNodes(root.left) + countNodes(root.right);
  }
}
