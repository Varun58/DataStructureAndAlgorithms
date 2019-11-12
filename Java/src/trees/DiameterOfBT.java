package trees;

public final class DiameterOfBT {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new TreeNode(1);
    tree.root.left = new TreeNode(2);
    tree.root.left.left = new TreeNode(4);
    tree.root.left.right = new TreeNode(5);

    tree.root.right = new TreeNode(3);
    System.out.println("HEIGHT OF TREE: " + new DiameterOfBT().height(tree.root));
    System.out.println("DIAMETER OF BT:" + new DiameterOfBT().diameterOfBinaryTree(tree.root));
  }

  int ans;

  public int diameterOfBinaryTree(TreeNode root) {
    ans = 1;
    height(root);
    return ans - 1;
  }

  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int L = height(root.left);
    int R = height(root.right);

    ans = Math.max(ans, L + R + 1);

    return 1 + Math.max(L, R);
  }
}
