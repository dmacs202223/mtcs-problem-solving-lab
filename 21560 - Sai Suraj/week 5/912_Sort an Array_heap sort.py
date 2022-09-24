class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def MaxHeapify(arr, n, i):
            root = i
            l = (2*i)+ 1
            r = (2*i) + 2 
            if l < n and arr[root] < arr[l]:
                root = l
            if r < n and arr[root] < arr[r]:
                root = r
            if root != i:
                arr[i], arr[root] = arr[root], arr[i]
                MaxHeapify(arr, n, root)
        n = len(nums)
        for i in range(n//2 - 1, -1, -1):
            MaxHeapify(nums, n, i)
        
        for i in range(n-1, 0, -1):
            nums[i], nums[0] = nums[0], nums[i]
            MaxHeapify(nums, i, 0)
        return nums
