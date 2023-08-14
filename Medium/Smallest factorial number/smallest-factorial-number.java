//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
 class Solution
{
    public static int countZero(int z) {
        int count = 0;
        int divisor = 5;
        while (z / divisor > 0) {
            count += z / divisor;
            divisor *= 5;
        }
        return count;
    }
    
    int findNum(int n) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int zeros = countZero(mid);
            
            if (zeros >= n) {
                result = mid;
                high = mid - 1; // Look for smaller numbers to get the minimum
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
}

