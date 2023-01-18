class Solution:
    def maxProduct(self, nums: List[int]) -> int:        
        left = [nums[0]]
        right = [nums[-1]]
        for i in range(1, len(nums)):
            left.append((left[i-1] or 1) * nums[i])
            right.append((right[i-1] or 1) * nums[~i])

        return max(left + right)