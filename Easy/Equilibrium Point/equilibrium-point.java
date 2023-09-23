//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        // Calculate the total sum of the array.
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        
        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            // Calculate the right sum by subtracting the left sum and the current element from the total sum.
            long rightSum = totalSum - leftSum - arr[i];
            
            // Check if the left sum and right sum are equal.
            if (leftSum == rightSum) {
                // Return the equilibrium point (1-based index).
                return i + 1;
            }
            
            // Update the left sum for the next iteration.
            leftSum += arr[i];
        }
        
        // If no equilibrium point is found, return -1.
        return -1;
    }
}
