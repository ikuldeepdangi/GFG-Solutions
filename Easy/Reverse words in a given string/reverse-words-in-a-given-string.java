//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends





class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
         String[] words = S.split("\\.");
        
        // Initialize a StringBuilder to build the reversed string
        StringBuilder reversedStringBuilder = new StringBuilder();
        
        // Iterate through the words in reverse order and append them with dots
        for (int i = words.length - 1; i >= 0; i--) {
            reversedStringBuilder.append(words[i]);
            if (i > 0) {
                reversedStringBuilder.append(".");
            }
        }
        
        // Convert the StringBuilder to a string
        String reversedString = reversedStringBuilder.toString();
        
        // Print the reversed string
        return reversedString;
    }
}