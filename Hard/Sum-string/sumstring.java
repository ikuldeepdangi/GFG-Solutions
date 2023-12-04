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
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isSumString(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
 {
    private String stringSum(String str1, String str2) 
    {
        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }


        int m = str1.length();
        int n = str2.length();
        StringBuilder ans = new StringBuilder();
        int carry = 0;


        for (int i = 0; i < n; i++) 
        {
            int ds = ((str1.charAt(m - 1 - i) - '0') +
                    (str2.charAt(n - 1 - i) - '0') +
                    carry) % 10;


            carry = ((str1.charAt(m - 1 - i) - '0') +
                    (str2.charAt(n - 1 - i) - '0') +
                    carry) / 10;


            ans.insert(0, ds);
        }


        for (int i = n; i < m; i++) {
            int ds = (str1.charAt(m - 1 - i) - '0' +
                    carry) % 10;
            carry = (str1.charAt(m - 1 - i) - '0' +
                    carry) / 10;
            ans.insert(0, ds);
        }


        if (carry > 0) 
        {
            ans.insert(0, carry);
        }


        return ans.toString();
    }


    private boolean checkSumStrUtil(String str, int beg, int len1, int len2) 
    {
        String s1 = str.substring(beg, beg + len1);
        String s2 = str.substring(beg + len1, beg + len1 + len2);
        String s3 = stringSum(s1, s2);
        int s3Len = s3.length();


        if (s3Len > str.length() - len1 - len2 - beg) {
            return false;
        }


        if (s3.equals(str.substring(beg + len1 + len2, beg + len1 + len2 + s3Len))) {
            if (beg + len1 + len2 + s3Len == str.length()) {
                return true;
            }


            return checkSumStrUtil(str, beg + len1, len2, s3Len);
        }
        return false;
    }


    private boolean isSumStr(String str) {
        int n = str.length();


        for (int i = 1; i < n; i++) {
            for (int j = 1; i + j < n; j++) {
                if (checkSumStrUtil(str, 0, i, j)) {
                    return true;
                }
            }
        }


        return false;
    }


    public int isSumString(String S) {
        return isSumStr(S) ? 1 : 0;
    }
}

