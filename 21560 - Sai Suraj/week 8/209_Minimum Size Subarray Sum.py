class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        ans = sys.maxsize
        l,res = 0,0
        for i in range(n):
            res+=nums[i]
            while(res>=target):
                ans = min(ans,i+1-l)
                res -= nums[l]
                l=l+1
        if ans!=sys.maxsize:
            return ans
        return 0
