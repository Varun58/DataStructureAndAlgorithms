package linkedlist;

public class RemoveNthNodeFromEnd {

  // 1 pass
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode first = dummy;
    ListNode second = dummy;

    for (int i = 0; i <= n; i++) {
      first = first.next;
    }

    while (first != null) {
      first = first.next;
      second = second.next;
    }

    second.next = second.next.next;
    return dummy.next;
  }

  // 2 passes
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length = 0;
    ListNode first = head;
    while (first != null) {
      length++;
      first = first.next;
    }

    length -= n;
    first = dummy;
    while (length > 0) {
      length--;
      first = first.next;
    }

    first.next = first.next.next;
    return dummy.next;
  }
}
