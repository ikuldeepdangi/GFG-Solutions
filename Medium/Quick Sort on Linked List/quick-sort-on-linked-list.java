//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
  }
}
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
/*node class of the linked list */

class GfG {
    public static Node quickSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: empty or single-element list is already sorted
        }

        // Split the list into two halves
        Node[] halves = splitList(head);
        Node firstHalf = halves[0];
        Node secondHalf = halves[1];

        // Recursively sort both halves
        firstHalf = quickSort(firstHalf);
        secondHalf = quickSort(secondHalf);

        // Merge the sorted halves
        return merge(firstHalf, secondHalf);
    }

    // Split the linked list into two halves
    private static Node[] splitList(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node[] halves = new Node[2];
        halves[0] = head;
        halves[1] = slow.next;
        slow.next = null;

        return halves;
    }

    // Merge two sorted linked lists
    private static Node merge(Node first, Node second) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while (first != null && second != null) {
            if (first.data < second.data) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        }
        if (second != null) {
            current.next = second;
        }

        return dummy.next;
    }
}
