class Solution:
    def goodIndices(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        non_inc, non_dec = [1]*n, [1]*n
        
        for i in range(1, n):
            if not (nums[i] > nums[i-1]): non_inc[i] = non_inc[i-1] + 1
            if not (nums[~i+1] < nums[~i]): non_dec[~i] = non_dec[~i+1] + 1
                
        return [i for i in range(k, n-k) if non_inc[i-1] >= k and non_dec[i+1] >= k]
