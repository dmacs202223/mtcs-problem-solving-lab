class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        left, right = 0, len(nums)-1
        while left < right:
            mid = left + (right-left)//2
            neighbor = mid+1 if mid%2 == 0 else mid-1
            if nums[mid] == nums[neighbor]:
                left = mid + 1
            else:
                right = mid
        return nums[left]
