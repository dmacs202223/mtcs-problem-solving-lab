class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        l,r=0,0
        n = len(nums)
        s = set()
        ans=0
    
        while(r<n):
            s.add((nums[r],r))
            mx = s
            mn = s
            if mx[0]-mn[0]<= limit:
                ans = max(ans,r-l+1)
                r+=1
            else:
                s.remove((nums[l],l))
                l+=1
        return ans
