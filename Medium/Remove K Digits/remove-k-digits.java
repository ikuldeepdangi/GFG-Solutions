//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
        int n = S.length();
        
        // If K is equal to the length of the string, we need to remove all digits
        if (K == n) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < n) {
            while (K > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > S.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                K--;
            }

            sb.append(S.charAt(i));
            i++;
        }

        // If K is still greater than 0, remove remaining digits from the end
        while (K > 0) {
            sb.deleteCharAt(sb.length() - 1);
            K--;
        }

        // Remove leading 0s
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
