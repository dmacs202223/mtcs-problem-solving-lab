class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:        
        
        def max_heapify(n, i):
            l = 2*i+1
            r = l+1
            
            max_i = i
            
            if l < n and nums[l] > nums[max_i]:
                max_i = l            
                
            if r < n and nums[r] > nums[max_i]:
                max_i = r
                
            if max_i != i:
                nums[max_i], nums[i] = nums[i], nums[max_i]
                max_heapify(n, max_i)
                
        n = len(nums)
        
        for i in range(n//2+1)[::-1]: 
            max_heapify(n, i) 

        for i in range(n)[::-1]: 
            nums[i], nums[0] = nums[0], nums[i]
            max_heapify(i, 0)
            
        return nums
