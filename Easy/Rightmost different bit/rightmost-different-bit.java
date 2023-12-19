//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Main{
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		
		//input number of testcases
		int t=sc.nextInt();
		int m,n;
		while(t-->0) {
		    
		    
            Solution obj = new Solution();
            //input m and n
		    m = sc.nextInt();
		    n = sc.nextInt();
		    System.out.println(obj.posOfRightMostDiffBit(m, n));
		}
	}
}




// } Driver Code Ends


//User function Template for Java
class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
            
        // Your code here    
        String s1=Integer.toBinaryString(m);
        String s2=Integer.toBinaryString(n);
        
        int index1=s1.length()-1;
        int index2=s2.length()-1;
        int count=1;
        while(index1>=0&&index2>=0){
            if(s1.charAt(index1)!=s2.charAt(index2)){
                return count;
            }
            count++;
            index1--;
            index2--;
        }
        if(index1>=0||index2>=0){
            return count;
        }
        return -1;
            
    }
}

