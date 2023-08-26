//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], long N) {
        int n = arr.length;
        return mergeSortAndCount(arr, 0, n - 1);
    }

    public static long mergeSortAndCount(long arr[], int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);

            count += merge(arr, left, mid, right);
        }
        return count;
    }

    public static long merge(long arr[], int left, int mid, int right) {
        long count = 0;

        int n1 = mid - left + 1;
        int n2 = right - mid;
        long a[] = new long[n1];
        long b[] = new long[n2];

        for (int i = 0; i < n1; i++) {
            a[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            b[i] = arr[mid + i + 1];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
                count += n1 - i;
            }
        }

        while (i < n1) {
            arr[k++] = a[i++];
        }

        while (j < n2) {
            arr[k++] = b[j++];
        }

        return count;
    }
}
