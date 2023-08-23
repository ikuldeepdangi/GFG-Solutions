//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends



class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> result = new ArrayList<>();
         result.add(0);
        
        // Loop through all possible subsets using bitmasking
        for (int mask = 0; mask < (1 << N); mask++) {
            int currSum = 0;
            
            // Calculate sum of current subset
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) { // Check if the i-th element is included in the subset
                    currSum += arr.get(i);
                }
            }
            
            result.add(currSum);
        }
        
        result.remove(0); // Remove the duplicate 0 that was added
        return result;
    }
}
