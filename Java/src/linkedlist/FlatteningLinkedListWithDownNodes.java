package linkedlist;

import linkedlist.LinkedListDown.DownNode;

public class FlatteningLinkedListWithDownNodes {

	/* Let us create the following linked list
    5 -> 10 -> 19 -> 28
    |    |     |     |
    V    V     V     V
    7    20    22    35
    |          |     |
    V          V     V
    8          50    40
    |                |
    V                V
    30               45
*/

	public static void main(String[] args) {
		LinkedListDown l1 = new LinkedListDown();

		l1.head = new DownNode(5);
		l1.head.down = new DownNode(7);
		l1.head.down.down = new DownNode(8);
		l1.head.down.down.down = new DownNode(30);
	
		l1.head.next = new DownNode(10);
		l1.head.next.down = new DownNode(20);
		
		l1.head.next.next = new DownNode(19);
		l1.head.next.next.down = new DownNode(22);
		l1.head.next.next.down.down = new DownNode(50);
		
		l1.head.next.next.next = new DownNode(28);
		l1.head.next.next.next.down = new DownNode(35);
		l1.head.next.next.next.down.down = new DownNode(40);
		l1.head.next.next.next.down.down.down = new DownNode(45);
		
		l1.head = flatten(l1.head);
		
		DownNode curr = l1.head;
		System.out.println();
		while(curr!=null) {
			System.out.print(curr.data+" ");
			curr = curr.down;
		}
		System.out.println();
		
	}
	
	public static DownNode flatten(DownNode n) {
		if(n==null || n.next==null) {
			return n;
		}
			
		n.next = flatten(n.next);
		
		n = merge(n,n.next);
		
		return n;
	}
	
	public  static DownNode merge(DownNode a,DownNode b) {
		if(a == null) return b;
		
		if(b== null) return a;
		
		DownNode r;
		if(a.data<b.data) {
			r = a;
			r.down = merge(a.down,b);
		}else {
			r = b;
			r.down = merge(a,b.down);
		}
		return r;
	}

	
}
