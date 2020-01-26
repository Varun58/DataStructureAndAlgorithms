package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

  // Time complexity : O(N)
  // Space complexity : O(1)
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    Node ptr = head;
    while (ptr != null) {
      Node newNode = new Node(ptr.val);
      newNode.next = ptr.next;
      ptr.next = newNode;
      ptr = newNode.next;
    }

    ptr = head;
    while (ptr != null) {
      ptr.next.random = ptr.random != null ? ptr.random.next : null;
      ptr = ptr.next.next;
    }

    Node ptr_old_list = head;
    Node ptr_new_list = head.next;
    Node new_head = head.next;

    while (ptr_old_list != null) {
      ptr_old_list.next = ptr_old_list.next.next;
      ptr_new_list.next = ptr_new_list.next != null ? ptr_new_list.next.next : null;
      ptr_old_list = ptr_old_list.next;
      ptr_new_list = ptr_new_list.next;
    }

    return new_head;
  }

  // Time complexity : O(N)
  // Space complexity : O(N)
  public Node copyRandomList2(Node head) {

    if (head == null) {
      return null;
    }

    Node oldNode = head;

    Node newNode = new Node(oldNode.val);
    this.visited.put(oldNode, newNode);

    while (oldNode != null) {
      newNode.random = this.getClonedNode(oldNode.random);
      newNode.next = this.getClonedNode(oldNode.next);

      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return this.visited.get(head);
  }

  Map<Node, Node> visited = new HashMap<>();

  public Node getClonedNode(Node node) {
    if (node != null) {
      if (!this.visited.containsKey(node)) {
        this.visited.put(node, new Node(node.val));
      }
      return this.visited.get(node);
    }
    return null;
  }

  class Node {
    int val;
    CopyRandomList.Node next;
    CopyRandomList.Node random;

    public Node() {
      // TODO Auto-generated constructor stub
    }

    public Node(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return "Node [val=" + val + ", next=" + next + "]";
    }
  }
}
