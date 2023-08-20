//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.maxOdd(s));
        }
    }
}
// } Driver Code Ends


class Solution {

    String maxOdd(String s) {
        // code hereimport java.io.*;
 
  // returns a substring that contains the maximum odd number at its end
    // Loop through the string backwards, starting from the end
    for (int i = s.length() - 1; i >= 0; i--)
    {
 
      // Check if the current character is odd
      if (s.charAt(i) % 2 != 0)
      {
 
        // If it is, return the substring that contains
        // all the characters up to and including the current character
        String s1 = s.substring(0, i + 1);
        return s1;
      }
    }
 
    // If no odd number is found in the string, return an empty string
    return "";
  }
 
  // driver functiom
//   public static void main(String[] args)
//   {
 
//     String s = "504";
 
//     // function call
//     String ans = maxOdd(s);
//     System.out.println(ans);
//   }
}