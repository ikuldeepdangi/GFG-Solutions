//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        if(n==1)
           return (long)1;
        
        else if(n==2)
           return (long)2;
           
        else if(n==3)
           return (long)4;  
           
        long a=1,b=2,c=4;
        
        for(int i=4;i<=n;i++)
        {
            long temp1=c;
            long temp2=b;
            long d=a%1000000007+b%1000000007+c%1000000007;
            c=d%1000000007;
            b=temp1%1000000007;
            a=temp2%1000000007;
        }
           
        
        return c;
    }
   
        
    
}