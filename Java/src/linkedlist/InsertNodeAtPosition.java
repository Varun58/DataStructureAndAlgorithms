package linkedlist;

public class InsertNodeAtPosition {
	
	 Node InsertNth(Node head, int data, int position) {
		  if(head!=null && head.data==2) {
			   head = head.next;
		   }
		 	
		   Node newNode = new Node();
		   newNode.data =data;
		   if(head == null) {
		       head = newNode;
		       return head;
		   }
		   
		   if(position ==0 ) {
			   newNode.next=head;
			   head = newNode;
			   return head;
		   }
		   int temp = 0;
		   Node curr = head;
		   while(temp<position-1 && curr.next  != null){
		       curr = curr.next;
		       temp++;
		   }
		   if(curr!=null){
		       newNode.next = curr.next;
		       curr.next = newNode;
		   }
		  return head;
		}
	
	public static void main(String[] args) {
	/*	InsertNodeAtPosition ins = new InsertNodeAtPosition();
		Node firstE = new Node();
		firstE.data=2;
		Node head = firstE;
		head =ins.InsertNth(head,3,0);
		head =ins.InsertNth(head,5,1);
		head =ins.InsertNth(head,4,2);
		head =ins.InsertNth(head,2,3);
		head =ins.InsertNth(head,10,1);
		
		Node curr = head;
		while(curr!=null) {
			System.out.println(curr.data);
			curr=curr.next;
			
		}*/
		
		InsertNodeAtPosition ins = new InsertNodeAtPosition();
		Node firstE = new Node();
		firstE.data=2;
		Node head = firstE;
		head =ins.InsertNth(head,781,0);
		head =ins.InsertNth(head,39,1);
		head =ins.InsertNth(head,790,0);
		head =ins.InsertNth(head,187,2);
		head =ins.InsertNth(head,544,3);
		head =ins.InsertNth(head,725,3);
		head =ins.InsertNth(head,52,2);
		head =ins.InsertNth(head,954,2);
		head =ins.InsertNth(head,410,7);
		head =ins.InsertNth(head,207,0);
		
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.data);
			curr=curr.next;
			
		}
		
	}

}
class Node {
    int data;
    Node next;
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
    
    
 }

   


