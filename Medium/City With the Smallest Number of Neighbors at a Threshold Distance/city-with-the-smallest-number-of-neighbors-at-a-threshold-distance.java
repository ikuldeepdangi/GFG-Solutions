//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    public int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] distances = new int[n][n];
        
        // Initialize distances matrix with infinity
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Update distances matrix with given edges
        for (int[] edge : edges) {
            int fromCity = edge[0];
            int toCity = edge[1];
            int weight = edge[2];
            distances[fromCity][toCity] = weight;
            distances[toCity][fromCity] = weight;
        }
        
        // Update diagonal elements with 0
        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
        }
        
        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) {
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    }
                }
            }
        }
        
        int minReachable = Integer.MAX_VALUE;
        int resultCity = -1;
        
        // Calculate the number of reachable cities for each city
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (distances[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities < minReachable || (reachableCities == minReachable && i > resultCity)) {
                minReachable = reachableCities;
                resultCity = i;
            }
        }
        
        return resultCity;
    }
}

