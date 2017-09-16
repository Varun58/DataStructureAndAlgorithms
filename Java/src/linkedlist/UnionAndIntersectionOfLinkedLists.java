package linkedlist;

import java.util.HashSet;
import java.util.Set;

import linkedlist.ReversingLinkedList.Node;

public class UnionAndIntersectionOfLinkedLists {

	Node head;

	void push(int data) {

		Node newNode = new Node(data);

		newNode.next = head;

		head = newNode;
	}

	public static void main(String[] args) {
		UnionAndIntersectionOfLinkedLists ll1 = new UnionAndIntersectionOfLinkedLists();

		ll1.push(20);
		ll1.push(4);
		ll1.push(15);
		ll1.push(10);

		UnionAndIntersectionOfLinkedLists ll2 = new UnionAndIntersectionOfLinkedLists();
		ll2.push(10);
		ll2.push(2);
		ll2.push(4);
		ll2.push(8);

		ll1.print(ll1.head);
		ll2.print(ll2.head);

		System.out.println();

		UnionAndIntersectionOfLinkedLists union = new UnionAndIntersectionOfLinkedLists();
		union.union(ll1.head, ll2.head);
		System.out.println("Union : ");
		union.print(union.head);

		UnionAndIntersectionOfLinkedLists intersection = new UnionAndIntersectionOfLinkedLists();

		intersection.intersection(ll1.head, ll2.head);
		System.out.println(" \nIntersection : ");
		intersection.print(intersection.head);

		
		UnionAndIntersectionOfLinkedLists unionHash = new UnionAndIntersectionOfLinkedLists();
		unionHash.unionUsingHash(ll1.head, ll2.head);
		System.out.println(" UnionUsingHash : ");
		unionHash.print(unionHash.head);

		UnionAndIntersectionOfLinkedLists intersectionHash = new UnionAndIntersectionOfLinkedLists();

		intersectionHash.intersectionUsingHash(ll1.head, ll2.head);
		System.out.println(" \nIntersectionHash : ");
		intersectionHash.print(intersectionHash.head);

	}

	public void intersection(Node n1, Node n2) {

		Node t2 = n2;
		while (t2 != null) {
			if (isPresent(n1, t2.data)) {
				push(t2.data);
			}
			t2 = t2.next;
		}

	}

	public void union(Node n1, Node n2) {
		Node t1 = n1;

		while (t1 != null) {
			push(t1.data);
			t1 = t1.next;
		}

		Node t2 = n2;
		while (t2 != null) {
			if (!isPresent(head, t2.data)) {
				push(t2.data);
			}
			t2 = t2.next;
		}
	}

	public void unionUsingHash(Node n1, Node n2) {
		Node t1 = n1;
		
		Set<Integer> set = new HashSet<Integer>();
		
		while (t1 != null) {
			push(t1.data);
			set.add(t1.data);
			t1 = t1.next;
		}

		Node t2 = n2;
		while (t2 != null) {
			if (!set.contains(t2.data)) {
				push(t2.data);
			}
			t2 = t2.next;
		}
	}

	public void intersectionUsingHash(Node n1, Node n2) {

		Node t1 = n1;
		
		Set<Integer> set = new HashSet<Integer>();
		
		while (t1 != null) {
			set.add(t1.data);
			t1 = t1.next;
		}
		
		Node t2 = n2;
		while (t2 != null) {
			if (set.contains(t2.data)) {
				push(t2.data);
			}
			t2 = t2.next;
		}

	}
	private boolean isPresent(Node n, int data) {

		Node temp = n;

		while (temp != null) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}

		return false;
	}

	public void print(Node head) {
		System.out.println();
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}

		System.out.println();
	}
}
