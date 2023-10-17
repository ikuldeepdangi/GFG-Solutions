//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends

class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // Create a 2D array to store the transitive closure
        ArrayList<ArrayList<Integer>> transitiveClosure = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add(graph[i][j]);
            }
            transitiveClosure.add(row);
        }

        // Use the Floyd-Warshall algorithm to update the transitive closure matrix
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (transitiveClosure.get(i).get(k) == 1 && transitiveClosure.get(k).get(j) == 1) {
                        transitiveClosure.get(i).set(j, 1);
                    }
                }
            }
        }

        // Correct the diagonal entries
        for (int i = 0; i < N; i++) {
            transitiveClosure.get(i).set(i, 1);
        }

        return transitiveClosure;
    }
}

