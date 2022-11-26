class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        l, r = 0, len(nums)-1
        result = 0
        mod = 10 ** 9 + 7
        
        while l <= r:
            if nums[l] + nums[r] > target:
                r -= 1
            else:
                result += pow(2, r-l, mod)
                l += 1
        
        return result % mod
