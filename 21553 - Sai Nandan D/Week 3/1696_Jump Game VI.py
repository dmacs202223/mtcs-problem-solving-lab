from collections import deque

class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        dp = [nums[0]]
        q = deque([0])        
        
        for i in range(1, len(nums)):
            dp.append(dp[q[0]] + nums[i])
            while q and dp[i] > dp[q[-1]]:
                q.pop()
            q.append(i)
            if q[0] == i-k: q.popleft()
                
        return dp[-1]
