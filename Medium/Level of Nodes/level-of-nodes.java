//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        // Create a boolean array to mark visited nodes
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Start from the node 0 and mark it as visited
        queue.add(0);
        visited[0] = true;

        // Initialize the level to 0
        int level = 0;

        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int nodesAtCurrentLevel = queue.size();

            // Traverse all the nodes at the current level
            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                int node = queue.poll();

                // Check if the current node is the one we are looking for
                if (node == X) {
                    return level;
                }

                // Explore all the adjacent nodes of the current node
                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }

            // Increment the level for the next level of nodes
            level++;
        }

        // If X is not found, return -1
        return -1;
    }
}
