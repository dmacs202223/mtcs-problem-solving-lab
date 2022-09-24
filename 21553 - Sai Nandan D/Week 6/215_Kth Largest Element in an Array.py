class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:        
        n = len(nums)
        
        def partition(lo, hi):
            r_i = randint(lo, hi)
            nums[r_i], nums[hi] = nums[hi], nums[r_i]
            pivot = nums[hi]
            l = lo-1
            for r in range(lo, hi):
                if nums[r] >= pivot:
                    l += 1
                    nums[l], nums[r] = nums[r], nums[l]
            nums[l+1], nums[hi] = nums[hi], nums[l+1]
            return l+1
            
    
        def kth_largest(lo, hi, k):
            if lo == hi: return nums[lo]
            p = partition(lo, hi)
            count = p - lo + 1
            if count > k: return kth_largest(lo, p-1, k)
            if count < k: return kth_largest(p+1, hi, k-count)            
            return nums[p]
            
        return kth_largest(0, n-1, k)
