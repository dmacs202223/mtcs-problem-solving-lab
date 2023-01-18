class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()   
        MOD=10**9+7
        l = 0
        h = len(nums)-1
        c = 0
        while(l<=h):
            if(nums[h]+nums[l]<=target):
                c = (c+ pow(2,h-l,MOD))%MOD
                l+=1
            else:
                h-=1
        return c
