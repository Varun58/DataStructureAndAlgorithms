package trees;

public class LCAOfBST {

  public TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
    if(root == null){return null;}

    if(root.val > Math.max(n1.val, n2.val)) {
      return lca(root.left, n1, n2);
    }

    if(root.val < Math.min(n1.val, n2.val)) {
      return lca(root.right, n1, n2);
    }

    return root;
  }
}
