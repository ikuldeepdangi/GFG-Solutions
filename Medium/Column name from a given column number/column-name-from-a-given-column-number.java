//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends

class Solution {
    String colName(long n) {
        StringBuilder str = new StringBuilder();

        while (n > 0) {
            n--; // Adjust n to handle 1-based indexing
            char colChar = (char) ('A' + (n % 26));
            str.insert(0, colChar);
            n /= 26;
        }

        return str.toString();
    }
}
