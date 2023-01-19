class Solution:
    def findClosestElements(self, nums: List[int], k: int, x: int) -> List[int]:
        l, r = 0, len(nums)-k
        while l < r:
            mid = (l + r) // 2
            if x - nums[mid] <= nums[mid+k] - x:
                r = mid
            else:
                l = mid+1
                
        return nums[l:l+k]
