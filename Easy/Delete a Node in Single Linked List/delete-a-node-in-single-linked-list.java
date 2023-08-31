
/* Linklist node structure
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
/*You are required to complete below method*/
class GfG
{
    Node deleteNode(Node head, int x)
    {
        if (x == 1)
        {
            head = head.next;
            return head;
        }
        
        int count = 1;
        Node prev = head;
        Node curr = head;
        
        while (curr != null && count < x)
        {
            prev = curr; 
            curr = curr.next;
            count++;
        }
        
        if (curr == null) {
            return head;  
        }
        
        prev.next = curr.next;
        
        return head;
    }
}
