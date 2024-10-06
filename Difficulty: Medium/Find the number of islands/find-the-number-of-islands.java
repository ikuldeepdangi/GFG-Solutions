//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends



class Solution {
    public int numIslands(char[][] grid) {
        // Edge case: if the grid is empty, return 0
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If we find a land ('1'), we perform DFS using a stack
                if (grid[i][j] == '1') {
                    numIslands++;  // New island found, increment count
                    dfsIterative(grid, i, j, rows, cols);  // Mark the entire island
                }
            }
        }
        
        return numIslands;
    }

    // Iterative DFS function to mark all connected lands ('1') from the current position
    private void dfsIterative(char[][] grid, int i, int j, int rows, int cols) {
        // Directions for exploring the 8 possible directions (up, down, left, right, and diagonals)
        int[] rowDirections = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] colDirections = {0, 0, -1, 1, -1, 1, -1, 1};

        // Create a stack to simulate recursion
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        
        // Mark the starting cell as visited (by changing '1' to '0')
        grid[i][j] = '0';
        
        // Process the stack
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0], y = current[1];
            
            // Explore all 8 possible directions
            for (int d = 0; d < 8; d++) {
                int newX = x + rowDirections[d];
                int newY = y + colDirections[d];
                
                // If the new cell is within bounds and is land ('1')
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == '1') {
                    // Mark it as visited and push it to the stack
                    grid[newX][newY] = '0';
                    stack.push(new int[]{newX, newY});
                }
            }
        }
    }
}
