package trees;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ZigZagTrees {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();

    List<List<Integer>> result = new ArrayList<>();
    s1.add(root);
    while (!s1.isEmpty() || !s2.isEmpty()) {

      List<Integer> l1 = new ArrayList<>();
      while (!s1.isEmpty()) {
        TreeNode curr1 = s1.pop();

        if (curr1.left != null) {
          s2.add(curr1.left);
        }

        if (curr1.right != null) {
          s2.add(curr1.right);
        }

        l1.add(curr1.val);
      }

      if (!l1.isEmpty()) {
        result.add(l1);
      }

      List<Integer> l2 = new ArrayList<>();
      while (!s2.isEmpty()) {
        TreeNode curr2 = s2.pop();

        if (curr2.right != null) {
          s1.add(curr2.right);
        }
        if (curr2.left != null) {
          s1.add(curr2.left);
        }
        l2.add(curr2.val);
      }
      if (!l2.isEmpty()) {
        result.add(l2);
      }
    }
    return result;
  }

  public List<List<Integer>> zizagLevelOrder2(TreeNode root) {
    if (root == null) {
      return new ArrayList<List<Integer>>();
    }
    List<List<Integer>> result = new ArrayList<>();
    DFS(root, result, 0);
    return result;
  }

  public void DFS(TreeNode root, List<List<Integer>> result, int level) {
    if (level >= result.size()) {
      LinkedList<Integer> newLevel = new LinkedList<>();
      newLevel.add(root.val);
      result.add(newLevel);
    } else {
      if (level % 2 == 0) {
        result.get(level).add(root.val);
      } else {
        result.get(level).add(0, root.val);
      }
    }

    if (root.left != null) {
      DFS(root.left, result, level + 1);
    }

    if (root.right != null) {
      DFS(root.right, result, level + 1);
    }
  }

}
