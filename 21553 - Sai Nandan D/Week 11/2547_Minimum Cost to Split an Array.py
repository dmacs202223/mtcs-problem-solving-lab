class Solution:
    def minCost(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dp = [0] + [float('inf')]*n
        for j in range(1, n+1):
            freq = defaultdict(int)
            remove = 0
            for i in range(j, 0, -1):
                remove += (freq[nums[i-1]] == 0) - (freq[nums[i-1]] == 1)
                freq[nums[i-1]] += 1
                cur = dp[i-1] + (k + j-i+1 - remove)
                if cur < dp[j]: dp[j] = cur

        return dp[n]
