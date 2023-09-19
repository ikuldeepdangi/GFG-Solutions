//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to find the position of the first set bit in the given number.
    public static int getFirstSetBit(int n) {

        // Convert integer to binary string
        String binary = Integer.toBinaryString(n);

        int l = binary.length();

        // Iterate through the binary string in reverse
        for (int i = l - 1; i >= 0; i--) {
            char z = binary.charAt(i);

            // Use single quotes for character comparison
            if (z == '1') {
                return l - i;
            }
        }

        return 0; // If there are no set bits (all 0s), return -1
    }
}
