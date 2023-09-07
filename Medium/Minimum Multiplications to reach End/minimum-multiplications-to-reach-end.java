//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java




class Solution {
    public int minimumMultiplications(int[] arr, int start, int end) {
        final int MOD = 100000;
        int[] dp = new int[MOD];
        Arrays.fill(dp, -1);
        dp[start] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int num : arr) {
                int nextValue = (current * num) % MOD;
                
                if (dp[nextValue] == -1) {
                    dp[nextValue] = dp[current] + 1;
                    queue.add(nextValue);
                }
            }
            
            if (dp[end] != -1) {
                return dp[end];
            }
        }
        
        return -1; // If end cannot be reached
    }
}

