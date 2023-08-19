//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends

class Solution {
    // Function to build a Heap from array.
    void buildHeap(int arr[], int n) {
        // Starting from the last non-leaf node and going up to the root.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i); // Call heapify for each non-leaf node.
        }
    }

    // Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // Compare with left child.
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        // Compare with right child.
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If the largest element is not the current element, swap and recursively heapify.
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n) {
        // Build the initial max-heap.
        buildHeap(arr, n);

        // Heap sort process.
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i); // Swap the root (maximum element) with the last element.
            heapify(arr, i, 0); // Heapify the reduced heap.
        }
    }

    // Utility function to swap elements in an array.
    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

 
