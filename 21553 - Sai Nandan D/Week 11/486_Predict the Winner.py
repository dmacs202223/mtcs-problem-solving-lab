from collections import defaultdict
class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = defaultdict(lambda: -1)
        def score(l, r):
            if l > r: return 0
            if l == r: return nums[l]
            if dp[(l, r)] == -1:
                a = nums[l] + min(score(l+2, r), score(l+1, r-1))
                b = nums[r] + min(score(l+1, r-1), score(l, r-2))
                dp[(l, r)] = max(a, b)
            return dp[(l, r)]
          
        p1_score = score(0, n-1)
        p2_score = sum(nums) - p1_score        
        return  p1_score >= p2_score
