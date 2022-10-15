class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = self.BS(nums,target,True)
        right = self.BS(nums,target,False)
        return [left,right]
    def BS(self,nums,target,leftbias):
        l = 0
        r = len(nums)-1
        i=-1
        while(l<=r):
            m =(l+r)//2
            if target > nums[m]:
                l=m+1
            elif target<nums[m]:
                r=m-1
            else:
                i=m
                if leftbias:
                    r=m-1
                else:
                    l=m+1
        return i
