class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp,dp_prev = [0]*n,[0]*n
        for r in range(m):
            for c in range(n):
                if r==0 or c==0:
                    dp[c]=1
                else:
                    dp[c] = dp[c-1]+dp_prev[c]
            dp,dp_prev = dp_prev,dp
        return dp_prev[n-1]

