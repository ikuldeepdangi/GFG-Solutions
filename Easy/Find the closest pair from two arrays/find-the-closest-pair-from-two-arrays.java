//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> printClosest(int arr[], int brr[], int n, int m, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);

        int i = 0; 
        int j = m - 1;
        int diff = Integer.MAX_VALUE;

        while (i < n && j >= 0) {
            int sum = arr[i] + brr[j];
            int curDiff = Math.abs(sum - x);

            if (curDiff < diff) {
                diff = curDiff;
                result.set(0, arr[i]);
                result.set(1, brr[j]);
            }

            if (sum < x) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }
}