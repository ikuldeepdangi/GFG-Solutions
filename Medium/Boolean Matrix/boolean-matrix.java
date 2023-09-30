//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to modify the matrix such that if a matrix cell matrix[i][j]
    // is 1, then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][]) {
        // code here
        ArrayList<Integer> pairList = new ArrayList<>();
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 1) { 
                    pairList.add(i);
                    pairList.add(j);
                }
            }
        }
        
        changeRAC(pairList, matrix, n, m);
    }
    
    void changeRAC(ArrayList<Integer> pairList, int matrix[][], int n, int m) {
        int z = pairList.size(); 
        
        for(int k = 0; k < z; k += 2) { 
            changeRow(pairList.get(k), matrix, n, m);
            changeColumn(pairList.get(k + 1), matrix, n, m);
        }
    }
    
    void changeRow(int rowIndex, int matrix[][], int n, int m) {
        for(int j = 0; j < m; j++) {
            matrix[rowIndex][j] = 1;
        }
    }
    
    void changeColumn(int columnIndex, int matrix[][], int n, int m) {
        for(int i = 0; i < n; i++) {
            matrix[i][columnIndex] = 1;
        }
    }
}
