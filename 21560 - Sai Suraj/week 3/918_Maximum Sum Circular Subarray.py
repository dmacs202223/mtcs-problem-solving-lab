class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        msf = float('-inf')
        s = 0
        
        for i in nums:
            s+=i
            if s>msf:
                msf = s
            if s<0:
                s = 0
        
        s = 0
        minsf = float('inf')
        for i in nums[1:-1]:
            s+=i
            if s<minsf:
                minsf = s
            if s>0:
                s = 0
                
        return max(msf,sum(nums)-minsf)
