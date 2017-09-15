package linkedlist;

public class IntersectionPointOfTwoLinkedLists {

	Node head;
	Node head2;

	//Use two loops
	//Use Hashing
	//Use Difference of count
	//Use loop in linkedList
	
	public int getIntersectingNode(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			return 0;
		}

		if (n1 == null || n2 == null) {
			return -1;
		}

		int count1 = getCount(n1);
		int count2 = getCount(n2);
		int diff = 0;

		Node larger ,smaller;
		
		if (count1 > count2) {
			larger = n1;
			smaller = n2;
		}else {
			
			larger = n2;
			smaller = n1;
		}
		
		diff = Math.abs(count1 - count2);

		Node temp = larger;
		
		while (diff-- > 0) {
			temp = temp.next;
		}

		
		while (temp != null && smaller != null ) {
			
			if(temp.data == smaller.data) {
				System.out.println("Found intersecting Node as :"+temp.data);
				break;
			}
			
			temp = temp.next;
			smaller = smaller.next;
		}
		
		return temp!=null?temp.data:-1;
	}

	public int getCount(Node n) {
		Node curr = n;
		int count = 0;
		while (curr != null) {
			
			count++;
			curr = curr.next;
		}
		return count;
	}

	public static void main(String[] args) {

		IntersectionPointOfTwoLinkedLists list = new IntersectionPointOfTwoLinkedLists();
		list.head = new Node(3);
		list.head.next = new Node(6);
		list.head.next.next = new Node(15);
		Node intersectingNode = new Node(20);
		list.head.next.next.next = intersectingNode;
		list.head.next.next.next.next = new Node(30);
		list.head.next.next.next.next.next = new Node(40);
		list.head.next.next.next.next.next.next = new Node(50);

		list.head2 = new Node(10);
		list.head2.next = intersectingNode;
		
		list.getIntersectingNode(list.head, list.head2);
	}

	static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [next=" + next + ", data=" + data + "]";
		}
		
		

	}

	@Override
	public String toString() {
		return "IntersectionPointOfTwoLinkedLists [head=" + head + ", head2=" + head2 + "]";
	}
	
	
}
