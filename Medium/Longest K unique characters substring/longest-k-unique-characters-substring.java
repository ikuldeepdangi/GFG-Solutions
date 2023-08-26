//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestkSubstr(String s, int k) {
        // Create a map to store the frequency of characters in the current substring.
        Map<Character, Integer> mp = new HashMap<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int max = -1;
        
        while (j < n) {
            // Add the current character to the map and update its frequency.
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            
            if (mp.size() < k) {
                j++;
            } else if (mp.size() == k) {
                max = Math.max(max, j - i + 1);  // Update the maximum length.
                j++;
            } else if (mp.size() > k) {
                while (mp.size() > k) {
                    // Remove characters from the beginning of the substring until the map size is <= k.
                    mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                    if (mp.get(s.charAt(i)) == 0) {
                        mp.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;  // Move the end pointer after adjusting the map size.
            }
        }
        
        return max;
    }
}






// class Solution {
//     public int longestkSubstr(String s, int k) {
//         int max = 0;
//         int n = s.length();

//         for (int i = 0; i < n; i++) {
//             int count = 0;
//             ArrayList<Character> temp = new ArrayList<>();

//             for (int j = i; j < n; j++) {
//                 int z = k;

//                 if (temp.contains(s.charAt(j))) {
//                     count++;
//                 } else {
//                     if (z >= 1) {
//                         temp.add(s.charAt(j));
//                         z--;  // Decrement the allowed distinct character count
//                         count++;
//                     } else {
//                         break; // Exit the inner loop when z <= 0
//                     }
//                 }
//             }

//             if (max < count) {
//                 max = count;
//             }
//         }

//         return max;
//     }
// }
