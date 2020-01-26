package trees;

public class LCAofBT {

  // https://algorithms.tutorialhorizon.com/lowest-common-ancestor-in-a-binary-tree-not-binary-search-tree/
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    } else {
      if (root.val == p.val || root.val == q.val) {
        return root;
      }

      TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
      TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

      if (leftLca != null && rightLca != null) {
        return root;
      }

      if (leftLca != null) {
        return leftLca;
      } else if (rightLca != null) {
        return rightLca;
      } else {
        return null;
      }
    }
  }
}
