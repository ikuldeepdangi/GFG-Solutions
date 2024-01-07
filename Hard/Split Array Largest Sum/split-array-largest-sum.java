//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


        
class Solution {
    static int splitArray(int[] arr, int N, int K) {
        Solution solution = new Solution();
        return solution.splitArray(arr, K);
    }

    public int splitArray(int[] nums, int m) {
        int low = 0, high = 0;
        for (int i : nums) {
            low = Math.max(low, i);
            high += i;
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, m, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    boolean isPossible(int[] nums, int m, int limit) {
        int count = 1, sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > limit) {
                count++;
                sum = nums[i];
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}