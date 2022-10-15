# Approach 1: Recursive
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums: return [-1, -1]
        def search(lo, hi):
            if nums[lo] == target == nums[hi]:
                return [lo, hi]
            if nums[lo] <= target <= nums[hi]:
                mid = (lo + hi) // 2
                l, r = search(lo, mid), search(mid+1, hi)
                return max(l,r) if -1 in l+r else [l[0], r[1]]
            return [-1, -1]
        return search(0, len(nums)-1)
        

# Approach 2.1: Iterative
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def search(target):
            lo, hi = 0, len(nums)
            while lo < hi:
                mid = (lo + hi) // 2
                if nums[mid] < target:
                    lo = mid + 1
                else:
                    hi = mid
            return lo
                    
        lo = search(target)
        return [lo, search(target+1)-1] if target in nums[lo:lo+1] else [-1, -1]
        
# Approach 2.2: Iterative (Using library functions)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:                    
        lo = bisect.bisect_left(nums, target)
        return [lo, bisect.bisect(nums, target)-1] if target in nums[lo:lo+1] else [-1, -1]
