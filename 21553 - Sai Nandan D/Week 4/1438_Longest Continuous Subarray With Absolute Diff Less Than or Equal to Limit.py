class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        min_q, max_q = deque(), deque()
        max_size = 0
        l = 0        
        n = len(nums)
        
        for r in range(n):
            
            while min_q and nums[min_q[-1]] > nums[r]: min_q.pop()                
            min_q.append(r)
            
            while max_q and nums[max_q[-1]] < nums[r]: max_q.pop()                
            max_q.append(r)
            
            while nums[max_q[0]] - nums[min_q[0]] > limit:
                l += 1
                if l > min_q[0]: min_q.popleft()
                if l > max_q[0]: max_q.popleft()
            
            max_size = max(max_size, r-l+1)            
        
        return max_size
