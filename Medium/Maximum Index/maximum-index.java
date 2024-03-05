//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends

class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
       if(n==1){
           return 0;
       }
        int lmin[] = new int[n];
        lmin[0] = a[0];
        int rmax[] = new int[n];
        rmax[n-1] = a[n-1];
        
        for(int i=1;i<n;i++){
            lmin[i] = Integer.min(lmin[i-1],a[i]);
        }
        for(int i=n-2;i>=0;i--){
            rmax[i] = Integer.max(a[i],rmax[i+1]);
        }
        int ans = -1;
        int left = 0;
        int right = 0;
        
        while(left <n && right <n){
            if(lmin[left] <= rmax[right]){
                ans = Integer.max(ans,(right-left));
                right++;
            }
            else{
                left++;
            }
        }
        return ans;
    }
}