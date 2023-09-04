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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public char[][] fill(int n, int m, char a[][]) {
        // Find border regions and mark the Os as Ts
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && a[i][j] == 'O') {
                    dfs(i, j, n, m, a);
                }
            }
        }

        // Change all Os to Xs and Ts to Os
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == 'T') {
                    a[i][j] = 'O';
                }
            }
        }

        return a;
    }

    private void dfs(int r, int c, int totalRows, int totalColumns, char[][] board) {
        if (r < 0 || c < 0 || r >= totalRows || c >= totalColumns || board[r][c] != 'O') {
            return; // Nothing to do
        }

        board[r][c] = 'T';
        dfs(r - 1, c, totalRows, totalColumns, board);
        dfs(r + 1, c, totalRows, totalColumns, board);
        dfs(r, c + 1, totalRows, totalColumns, board);
        dfs(r, c - 1, totalRows, totalColumns, board);
    }
}
