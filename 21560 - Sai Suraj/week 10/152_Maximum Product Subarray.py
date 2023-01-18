class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = nums[0]
        cur_max,cur_min =1,1
        for num in nums:
            val = (num,num*cur_max,num*cur_min)
            cur_max,cur_min = max(val),min(val)
            res = max(res,cur_max)
        return res

