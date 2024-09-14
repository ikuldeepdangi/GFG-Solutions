#User function Template for python3

# User function Template for python3

class Solution:
    def rearrange(self, arr):
        # Step 1: Separate positive and negative numbers
        pos = [x for x in arr if x >= 0]  # Including 0 as positive
        neg = [x for x in arr if x < 0]

        # Step 2: Merge positive and negative numbers alternatively
        i, j = 0, 0  # i is for pos, j is for neg
        k = 0  # index for the original array

        # Fill the array alternately with positive and negative elements
        while i < len(pos) and j < len(neg):
            if k % 2 == 0:  # Place a positive element at even index
                arr[k] = pos[i]
                i += 1
            else:  # Place a negative element at odd index
                arr[k] = neg[j]
                j += 1
            k += 1

        # If there are remaining positive elements, append them
        while i < len(pos):
            arr[k] = pos[i]
            i += 1
            k += 1

        # If there are remaining negative elements, append them
        while j < len(neg):
            arr[k] = neg[j]
            j += 1
            k += 1





#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ob.rearrange(arr)
        for x in arr:
            print(x, end=" ")
        print()
        tc -= 1

# } Driver Code Ends