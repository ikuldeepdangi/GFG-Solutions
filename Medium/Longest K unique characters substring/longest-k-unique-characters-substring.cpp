//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++
class Solution {
public:
    int longestKSubstr(std::string s, int k) {
        // Create an unordered_map to store the frequency of characters in the current substring.
        std::unordered_map<char, int> mp;
        int n = s.length();
        int i = 0;
        int j = 0;
        int max = -1;

        while (j < n) {
            // Add the current character to the unordered_map and update its frequency.
            mp[s[j]] = mp.find(s[j]) != mp.end() ? mp[s[j]] + 1 : 1;

            if (mp.size() < k) {
                j++;
            } else if (mp.size() == k) {
                max = std::max(max, j - i + 1);  // Update the maximum length.
                j++;
            } else if (mp.size() > k) {
                while (mp.size() > k) {
                    // Remove characters from the beginning of the substring until the unordered_map size is <= k.
                    mp[s[i]]--;
                    if (mp[s[i]] == 0) {
                        mp.erase(s[i]);
                    }
                    i++;
                }
                j++;  // Move the end pointer after adjusting the unordered_map size.
            }
        }

        return max;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        int k;
        cin >> k;
        Solution ob;
        cout << ob.longestKSubstr(s, k) << endl;
    }
}

// } Driver Code Ends