# Approach 1: Recursive
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        def find_peak(l, r):
            if l == r: return l
            mid = (l + r) // 2
            if nums[mid] > nums[mid+1]: r = mid
            else: l = mid + 1
            return find_peak(l, r)
        
        return find_peak(0, len(nums)-1)
      
      
# Approach 2: Iterative
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1
        while l < r:
            mid = (l+r) // 2
            if nums[mid] < nums[mid+1]: l = mid+1
            else: r = mid                
        return l
