package trees;

import java.util.ArrayList;

public class FlipEquivalentBinaryTrees {

  // This problem is same as check if two trees are
  // Isomorphic trees
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new TreeNode(1);
    tree.root.left = new TreeNode(2);
    tree.root.right = new TreeNode(3);
    tree.root.left.left = new TreeNode(4);
    tree.root.left.right = new TreeNode(5);
    tree.root.right.left = new TreeNode(6);
    tree.root.left.right.left = new TreeNode(7);
    tree.root.left.right.right = new TreeNode(8);

    BinaryTree tree1 = new BinaryTree();

    tree1.root = new TreeNode(1);
    tree1.root.left = new TreeNode(3);
    tree1.root.right = new TreeNode(2);
    tree1.root.right.left = new TreeNode(4);
    tree1.root.right.right = new TreeNode(5);
    tree1.root.left.right = new TreeNode(6);
    tree1.root.right.right.left = new TreeNode(8);
    tree1.root.right.right.right = new TreeNode(7);
    System.out.print(flipEquiv2(tree.root, tree1.root));
  }

  public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }

    if (root1 == null || root2 == null || root1.data != root2.data) {
      return false;
    }

    return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
        flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
  }

  // Using canonical representation
  // Source: Leetcode solution
  public static boolean flipEquiv2(TreeNode root1, TreeNode root2) {
    ArrayList<Integer> al1 = new ArrayList<>();
    ArrayList<Integer> al2 = new ArrayList<>();
    dfs(root1, al1);
    dfs(root2, al2);
    return al1.equals(al2);
  }

  private static void dfs(TreeNode root, ArrayList<Integer> al) {
    if (root != null) {
      al.add(root.data);

      int lv = root.left != null ? root.left.data: -1;
      int rv = root.right != null ? root.right.data: -1;

      if(lv < rv) {
        al.add(lv);
        al.add(rv);
      } else {
        al.add(rv);
        al.add(lv);
      }
      //al.add(null);
    }
  }


}
