#User function Template for python3

class Solution:
    def min_sprinklers(self, gallery, n):
        # code here
        arr = [-1]*n
        for i in range(n):
            if gallery[i]!=-1:
                left = max(0,i-gallery[i])
                right = min(n-1,i+gallery[i])
                arr[left] = max(arr[left],right)
        if arr[0] == -1:
            return -1
        index = 0
        anchor = arr[index]
        count = 0
        while anchor<n:
            count += 1
            if anchor == n-1:
                return count
            anchorPos = anchor
            while index<=anchorPos:
                anchor = max(anchor,arr[index])
                index += 1
            if anchor == n-1:
                return count+1
            if anchor == anchorPos and arr[index]==-1:
                return -1
            anchor = max(anchor,arr[index])
        return count     



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        gallery = [int(x) for x in input().strip().split()]
        obj = Solution()
        print(obj.min_sprinklers(gallery,n))

# } Driver Code Ends