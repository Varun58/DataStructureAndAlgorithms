package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isMirror(root.left, root.right);
  }

  public boolean isMirror(TreeNode r1, TreeNode r2) {
    if (r1 == null && r2 == null) {
      return true;
    }

    if (r1 == null || r2 == null) {
      return false;
    }

    if (r1.val != r2.val) {
      return false;
    }

    return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
  }

  // iterative
  public boolean isSymmetric2(TreeNode root) {
    if (root == null) {
      return true;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode t1 = queue.poll();
      TreeNode t2 = queue.poll();

      if (t1 == null && t2 == null) {
        continue;
      }

      if (t1 == null || t2 == null) {
        return false;
      }

      if (t1.val != t2.val) {
        return false;
      }

      queue.add(t1.left);
      queue.add(t2.right);
      queue.add(t1.right);
      queue.add(t2.left);
    }

    return true;
  }
}
