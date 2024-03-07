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
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        // code here
        if (n == 1)
            return "-1";

        String ans = "";
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (j - i <= len)
                    continue;

                String a = s.substring(i, j);
                String b = s.substring(j, n);
                
                if (b.contains(a)) {
                    ans = a;
                    len = a.length();
                } else {
                    break;
                }
            }
        }
        return ans.length() == 0 ? "-1" : ans;
    }
};