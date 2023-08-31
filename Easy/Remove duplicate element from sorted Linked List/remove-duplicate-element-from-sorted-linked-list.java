//{ Driver Code Starts
/* package whatever; // don't place package name! */


/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
	// Your code here	
	 
	 Node prev = null;
	 Node curr = head;
	 Node next = (head!=null) ? head.next : null ;
	 
	 while(curr!=null && next!=null){
	     if(curr.data==next.data){
	         
	         curr.next = next.next;
	         next=next.next;
	     }else{
	         prev = curr;
	         curr = next;
	         next = next.next;
	     }
	 }
	 return head;
	
    }
}
