//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                markUnwalkable(grid, i, 0);
            }
            if (grid[i][m - 1] == 1) {
                markUnwalkable(grid, i, m - 1);
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                markUnwalkable(grid, 0, j);
            }
            if (grid[n - 1][j] == 1) {
                markUnwalkable(grid, n - 1, j);
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public void markUnwalkable(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0; 

        
        markUnwalkable(grid, i - 1, j);
        markUnwalkable(grid, i + 1, j);
        markUnwalkable(grid, i, j - 1);
        markUnwalkable(grid, i, j + 1);
    }
}



// class Solution {

//     int numberOfEnclaves(int[][] grid) {

//         // Your code here
        
//         int n = grid.length;
//         int m = grid[0].length;
//         int count = 0;
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
                
//               if (i != 0 && i != n - 1 && j != 0 && j != m - 1) {
//                     if(grid[i][j]== 1){
//                         boolean z = walkoff(grid,i,j);
//                         if(z == false){
//                             count++;
//                         }
//                     }
//                 }
                
//             }
//         }
        
//         return count;
//     }
    
//     public static boolean walkoff(int grid[][],int i,int j){

//       if(grid[i-1][j] != 0){
//           return false;
//       }
//       if(grid[i][j-1] != 0){
//           return false;
//       }
//       if(grid[i][j+1] != 0){
//           return false;
//       }
//       if(grid[i+1][j] != 0){
//           return false;
//       }
       
//       return true;
//     }
// }