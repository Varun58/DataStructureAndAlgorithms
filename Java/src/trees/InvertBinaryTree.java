package trees;

public final class InvertBinaryTree {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new TreeNode(4);

    tree.root.left = new TreeNode(2);
    tree.root.left.left = new TreeNode(1);
    tree.root.left.right = new TreeNode(3);

    tree.root.right = new TreeNode(7);
    tree.root.right.left = new TreeNode(6);
    tree.root.right.right = new TreeNode(9);

    printTree(tree.root);
    System.out.println(" now inverting tree");
    invertTree(tree.root);
    System.out.println(" new inverted tree");
    printTree(tree.root);
  }

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left) ;
    invertTree(root.right);

    return root;
  }

  public static void printTree(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data+ " " );
    printTree(root.left);
    printTree(root.right);
  }
}
