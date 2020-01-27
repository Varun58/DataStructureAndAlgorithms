package linkedlist;

public class AddTwoNumbers {

  // h1 -> 2 -> 4 -> 3
  // h2 -> 5 -> 6 -> 4

  public static void main(String[] args) {

    ListNode d1 = new ListNode(2);
    ListNode d2 = new ListNode(4);
    ListNode d3 = new ListNode(3);

    d1.next = d2;
    d2.next = d3;
    d3.next = null;

    ListNode dd1 = new ListNode(5);
    ListNode dd2 = new ListNode(6);
    ListNode dd3 = new ListNode(4);

    dd1.next = dd2;
    dd2.next = dd3;
    dd3.next = null;

    final ListNode result = addTwoNumbers(d1, dd1);

    ListNode temp = result;
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);

    ListNode curr = dummyHead;
    ListNode p = l1;
    ListNode q = l2;
    int carry = 0;

    while (p != null || q != null) {
      int x = p != null ? p.val : 0;
      int y = q != null ? q.val : 0;
      int sum = x + y + carry;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;

      if (p != null) {
        p = p.next;
      }

      if (q != null) {
        q = q.next;
      }
    }

    if (carry != 0) {
      curr.next = new ListNode(carry);
    }

    return dummyHead.next;
  }

  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode current1 = l1;
    ListNode current2 = l2;

    int carry = 0;

    ListNode dummyHead = new ListNode(0);
    ListNode tempNode = dummyHead;

    while (current1 != null || current2 != null) {
      int x = 0;
      int y = 0;

      int tempSum;
      int sum;

      if (current1 != null) {
        x = current1.val;
        current1 = current1.next;
      }

      if (current2 != null) {
        y = current2.val;
        current2 = current2.next;
      }

      tempSum = x + y + carry;
      sum = tempSum % 10;
      carry = tempSum / 10;

      ListNode newNode = new ListNode(sum);
      tempNode.next = new ListNode(sum);
      tempNode = newNode;
    }

    if (carry > 0) {
      tempNode.next = new ListNode(carry);
    }

    return dummyHead.next;
  }
}
