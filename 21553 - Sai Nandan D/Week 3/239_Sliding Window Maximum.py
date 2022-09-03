from collections import deque

class Solution:    
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        result, q = [], deque([])
        
        for i, n in enumerate(nums):
            while q and n > nums[q[-1]]:
                q.pop()
            q.append(i)
            if q[0] == i-k: q.popleft()
            if i >= k-1: result.append(nums[q[0]])
                
        return result
