//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution {
    public : 
    int DivisibleByEight(string s){
        int number = StringToNumber(s);
        
        if(number % 8 ==0  ){
            return 1;
        } else{
            return -1;
        }
    }
    
    int StringToNumber(string s){
        int n = s.length();
        int number=0 ;
        
        for(int i=0;i<n;i++){
            number = number*10 + (s[i]  - '0') ;
        }
        
        return number;
    }
};




//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        string S;
        cin>>S;
        Solution ob;
        cout<<ob.DivisibleByEight(S)<<"\n";
    }
}
// } Driver Code Ends