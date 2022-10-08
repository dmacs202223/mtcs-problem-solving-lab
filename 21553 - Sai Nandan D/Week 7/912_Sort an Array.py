class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def partition(lo, hi):
            pivot = nums[randint(lo, hi)]            
            while True:                
                while nums[lo] < pivot:
                    lo += 1
                while nums[hi] > pivot:
                    hi -= 1
                if lo >= hi:
                    return hi
                nums[lo], nums[hi] = nums[hi], nums[lo]
                lo += 1
                hi -= 1
                
        def quicksort(lo, hi):
            if lo < hi:
                p = partition(lo, hi)
                quicksort(lo, p)
                quicksort(p+1, hi)
            
        quicksort(0, len(nums)-1)
        return nums
