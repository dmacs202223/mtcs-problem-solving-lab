from collections import deque

class Solution:    
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        result, q = [], deque([])
        
        for i, n in enumerate(nums):
            # Build the queue monotonically
            while q and n > nums[q[-1]]:
                q.pop()
            q.append(i)
            
            # Ensure that a max element does not remain in the queue even after the window has slid past it
            if q[0] == i-k: q.popleft()
                
            # The monotonicity of the queue ensures that `q[0]` is the desired max element in the current window
            if i >= k-1: result.append(nums[q[0]])
                
        return result
