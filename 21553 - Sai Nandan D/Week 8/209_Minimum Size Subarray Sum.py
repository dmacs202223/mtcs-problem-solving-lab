class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        start = 0        
        total = 0        
        minLen = float('inf')
        
        for i, num in enumerate(nums):
            total += num
            while total >= target:
                minLen = min(minLen, i-start+1)               
                total -= nums[start]
                start += 1
                        
        return minLen if minLen != float('inf') else 0
