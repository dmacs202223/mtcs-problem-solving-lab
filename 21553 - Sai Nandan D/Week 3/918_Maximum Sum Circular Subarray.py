class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        max_sum, cur_max = nums[0], nums[0]
        min_sum, cur_min = nums[0], nums[0]
        total = nums[0]
        
        for n in nums[1:]:
            cur_max = max(n, cur_max+n)
            max_sum = max(max_sum, cur_max)
            cur_min = min(n, cur_min+n)
            min_sum = min(cur_min, min_sum)
            total += n
            
        return max(max_sum, total - min_sum) if max_sum > 0 else max_sum
