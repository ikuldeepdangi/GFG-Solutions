//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
     static class Pair{
        int s;
        int f;
        int ind;
        Pair(int s,int f,int ind){
            this.s=s;
            this.f=f;
            this.ind=ind;
        }
       
    }
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(new Pair(S[i],F[i],i+1));
        }
        Collections.sort(list,(a,b)->a.f-b.f);
        ArrayList<Integer> ans=new ArrayList<>();
        int last=-1;
        for(int i=0;i<N;i++){
            if(list.get(i).s>last){
                ans.add(list.get(i).ind);
                last=list.get(i).f;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
        
