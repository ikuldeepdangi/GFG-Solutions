//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int smithNum(int n) {
        // code here
        int i,j;
        int s=0,c=n,sm=0,sc;
        s=sum(n);
        int d=n/2;
        for(i=2;i<=d;i++)
        {
            c=n;
            if(prime(i)==1 && c%i==0)
            {
                sc=sum(i);
                while(c%i==0)
                {
                    sm=sm+sc;
                    c/=i;
                    //System.out.println(i);
                }
            }
        }
        if(s==sm)
            return 1;
        return 0;
    }
    static int sum(int c)
    {
        int s=0;
        while(c!=0)
        {
            s=s+(c%10);
            c/=10;
        }
        return s;
    }
    static int prime(int n)
    {
        int m=(int)Math.sqrt(n);
        int i;
        for(i=2;i<=m;i++)
        {
            if(n%i==0)
                return 0;
        }
        return 1;
    }
};