//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/



/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node reverse(Node num){
        Node curr = num, prev = null;
        
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            
            curr = next;
        }
        
        return prev;
    }
    
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        if(num1 == null)
            return num2;
            
        if(num2 == null)
            return num1;
        
        //reversing both the numbers
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        Node output = null;
        int carry = 0;
        //adding digits of number 1 and number 2 and add to output
        while(num1 != null && num2 != null){
            int sum = (num1.data + num2.data) + carry;
            Node temp = new Node(sum % 10);
            carry = sum / 10;
            
            if(output == null){
                output = temp;
            }else{
                temp.next = output;
                output = temp;
            }
            
            num1 = num1.next;
            num2 = num2.next;
        }
        
        //adding remaining digits of number 1
        while(num1 != null){
            int sum = num1.data + carry;
            Node temp = new Node(sum % 10);
            carry = sum / 10;
            
            temp.next = output;
            output = temp;
            
            num1 = num1.next;
        }
        
        //adding remaining digits of number 2
        while(num2 != null){
            int sum = num2.data + carry;
            Node temp = new Node(sum % 10);
            carry = sum / 10;
            
            temp.next = output;
            output = temp;
            
            num2 = num2.next;
        }
        
        //adding a node for carry it not zero
        if(carry > 0){
            Node temp = new Node(carry);
            temp.next = output;
            
            return temp;
        }
        
        //removing leading zeroes
        while(output != null && output.data == 0){
            output = output.next;
        }
        
        //if output is null
        if(output == null){
            output = new Node(0);
        }
        
        return output;
    }
}