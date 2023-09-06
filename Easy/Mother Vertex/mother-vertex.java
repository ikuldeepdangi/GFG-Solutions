//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Solution
{
    // Function to perform a DFS traversal starting from vertex v.
    private void DFS(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                DFS(adj, neighbor, visited);
            }
        }
    }

    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Create an array to keep track of visited vertices.
        boolean[] visited = new boolean[V];
        
        int lastVisited = -1; // Initialize the last visited vertex to -1.
        
        // Perform DFS from each vertex to find the last visited vertex.
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(adj, i, visited);
                lastVisited = i; // Update the last visited vertex.
            }
        }
        
        // Reset visited array for a new traversal.
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Check if the last visited vertex can reach all other vertices.
        DFS(adj, lastVisited, visited);

        // If the last visited vertex can reach all other vertices, it is a mother vertex.
        if (allVisited(visited)) {
            return lastVisited;
        } else {
            return -1;
        }
    }

    // Function to check if all vertices in the visited array are true.
    private boolean allVisited(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}