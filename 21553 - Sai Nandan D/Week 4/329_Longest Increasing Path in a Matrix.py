class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:        
        m, n = len(matrix), len(matrix[0])
        dp = [[0]*n for _ in range(m)]
        directions = [(0,-1), (-1, 0), (0, 1), (1, 0)]
        
        def dfs(r, c):
            if not dp[r][c]:
                ele = matrix[r][c]
                dp[r][c] = 1 + max([dfs(r+i, c+j) if 0 <= r+i < m and 0 <= c+j < n and ele < matrix[r+i][c+j] else 0 for i, j in directions])
            return dp[r][c]
        
        return max(dfs(r, c) for r in range(m) for c in range(n))
