//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends


class Solution {
    static int binarySearch(int[] tails, int end, int key) {
        int left = 0, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    static int longestSubsequence(int size, int a[]) {
        int[] tails = new int[size];
        tails[0] = a[0];
        int end = 0;
        
        for (int i = 1; i < size; i++) {
            if (a[i] > tails[end]) {
                tails[++end] = a[i];
            } else {
                int idx = binarySearch(tails, end, a[i]);
                tails[idx] = a[i];
            }
        }
        
        return end + 1;
    }
}


// class Solution 
// {
//     //Function to find length of longest increasing subsequence.
//     static int longestSubsequence(int size, int a[])
//     {
//         // code here
//         int omax=0;
//         int[] dp=new int [size];
//         dp[0]=1;
        
//         for(int i=0;i<dp.length;i++){
//             int max=0;
//             for(int j=0;j<i;j++){
//                 if(a[j]<a[i]){
//                     if(dp[j]>max){
//                         max=dp[j];
//                     }
//                 }
//             }
//             dp[i]=max+1;
//             if(dp[i]>omax){
//                 omax=dp[i];
//             }
//         }
//         return omax;
//     }
// } 