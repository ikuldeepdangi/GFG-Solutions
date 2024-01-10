//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); 
        
        for (int i = 0; i < n; i++) {
            prefixSum += a[i];
            int mod = (prefixSum % k + k) % k; 
            
            if (modMap.containsKey(mod)) {
                int length = i - modMap.get(mod);
                maxLength = Math.max(maxLength, length);
            } else {
                modMap.put(mod, i);
            }
        }
        return maxLength;
    }
}





//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends






// class Solution{
//     int longSubarrWthSumDivByK(int a[], int n, int k)
//     {
//         // Complete the function
//         int max=0;
//         int count=0;
        
//         for(int i=0;i<n;i++){
//             int curr =0;
//             int j=i;
//             while(j<n){
//                 curr += a[j];
//                 if(curr % k ==0){
//                     if(count == 0){
//                         count += j+1;
//                     }else{
//                       count++;   
//                     }
//                 }
//                 j++;
//             }
//             max = Math.max(count , max);
//         }
        
//         return max;
       
//     }
 
// }
