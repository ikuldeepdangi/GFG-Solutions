//{ Driver Code Starts
import java.util.*;
class Node{
    int data;
    Node next;
    
    Node(int a){
        data = a;
        next = null;
    }
    
}

class LinkedList{
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int x=sc.nextInt();
            Node head=null;
            for(int i=0;i<n;i++)
            {int a=sc.nextInt();
            if(head==null){
                head=new Node(a);
            }
            else
                insert(head,a);
            }
        
            Solve y = new Solve();
            System.out.println(y.countTriplets(head,x));
        }
    }
    public static Node insert(Node head,int a){
        if(head==null){
            return new Node(a);
        }
        head.next=insert(head.next,a);
        return head;
    }
    
}


// } Driver Code Ends


//User function Template for Java

class Solve
{
    static int countTriplets(Node head, int x) 
    { 
        //code here.
      ArrayList<Integer> arr = new ArrayList<>();
      while(head != null){
          arr.add(head.data);
          head = head.next;
      }
      int n = arr.size();
      int count = 0;
      
      int i,j,k;
      
      for( i=0;i<n;i++){
           j=i+1;
           k=n-1;
           
           while(j<k){
               if(arr.get(i) + arr.get(j) + arr.get(k) == x){
                   count++;
                   j++;
                   k--;
               }else if(arr.get(i) + arr.get(j) + arr.get(k) < x){
                   k--;
               }else{
                   j++;
               }
           }
      }
      
      return count;
      
    } 
}
