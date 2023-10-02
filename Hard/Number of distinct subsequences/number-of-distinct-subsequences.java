//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String s) {
        // code here
       long dp[] = new long[s.length()+1];
dp[0]=1;
int mod=(int)(1e9+7);
HashMap<Character,Integer>hm = new HashMap<>();
for(int i=1;i<dp.length;i++)
{
    dp[i]=(2*dp[i-1]%mod)%mod;
    char ch=s.charAt(i-1);
    if(hm.containsKey(ch))
    {
        int val=hm.get(ch);
        dp[i]=(dp[i]%mod-dp[val-1]+mod)%mod;
    }
    hm.put(ch,i);
    
}
return (int)dp[s.length()]%mod;

}
}