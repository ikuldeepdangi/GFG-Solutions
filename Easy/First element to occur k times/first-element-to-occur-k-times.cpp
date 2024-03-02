//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
public:
    int firstElementKTime(int n, int k, int a[]) {
        unordered_map<int, int> count; // Map to store element counts

        for (int i = 0; i < n; ++i) {
            count[a[i]]++; // Increment count of element a[i]
            if (count[a[i]] == k) {
                return a[i]; // If count reaches k, return the element
            }
        }

        return -1; // If no such element found, return -1
    }
};




//{ Driver Code Starts.

int main() {
	int t;
	cin >> t;
	while(t--){
	    int n, k;
	    cin >> n >> k;
	    int a[n];
	    for(int i = 0;i<n;i++){
	        cin >> a[i];
	    }
	    Solution ob;
	    cout<<ob.firstElementKTime(n, k, a)<<endl;
	}
	
	return 0;
}
// } Driver Code Ends