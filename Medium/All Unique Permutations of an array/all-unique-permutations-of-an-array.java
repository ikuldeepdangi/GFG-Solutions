//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[n]; // Corrected typo in 'boolean'

        Collections.sort(arr); // Corrected typo in 'Collections'
        backtrack(arr, n, visited, current, result);
        return result;
    }

    static void backtrack(ArrayList<Integer> arr, int n, boolean[] visited, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || (i > 0 && arr.get(i).equals(arr.get(i - 1)) && !visited[i - 1])) {
                continue;
            }

            visited[i] = true;

            current.add(arr.get(i));
            backtrack(arr, n, visited, current, result);

            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }

    // Example usage
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(2);

        ArrayList<ArrayList<Integer>> result = uniquePerms(input, input.size());

        for (ArrayList<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}
