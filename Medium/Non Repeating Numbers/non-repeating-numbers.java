//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int n = nums.length;
        int xorSum = 0;
        
        for (int i = 0; i < n; i++) {
            xorSum ^= nums[i];
        }
        
        int rightmostSetBit = xorSum & -xorSum;
        
        int[] result = new int[2];
        int sum1 = 0;
        int sum2 = 0;
        
        for (int i = 0; i < n; i++) {
            if ((nums[i] & rightmostSetBit) > 0) {
                sum1 ^= nums[i];
            }
            else {
                sum2 ^= nums[i];
            }
        }
        
        result[0] = sum1;
        result[1] = sum2;
         Arrays.sort(result);
        
        return result;
    }
}








        //int n = nums.length;
        // int k = 0;
        
        // int[] res = new int[2];
        
        // for (int i = 0; i < n; i++) {
        //     int count = 0;
            
        //     for (int j = 0; j < n; j++) {
        //         if (i != j && nums[i] == nums[j]) {
        //             count++;
        //             break;
        //         }
        //     }
            
        //     if (count == 0) {
        //         res[k++] = nums[i];
        //     }
        // }
        
        // Arrays.sort(res); 
        // return res;
        