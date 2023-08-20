//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int count(int[] arr, int n, int x) {
        // code here
       int start=0;
       int end=n-1;
       int mid;
       int count=0;
       
       while(start<=end){
           mid=start+(end-start)/2;
           
           if(arr[mid]==x){
               count++;
                 start = mid - 1;
                while (start >= 0 && arr[start] == x) {
                    count++;
                    start--;
                }

                // Move right to count next occurrences
                end = mid + 1;
                while (end < n && arr[end] == x) {
                    count++;
                    end++;
                }

                // Break the loop since all occurrences around 'x' have been counted
                break;
           }else if(arr[mid]<x){
               start=mid+1;
           }else{
               end=mid-1;
           }
       }
       return count;
       
    }
}