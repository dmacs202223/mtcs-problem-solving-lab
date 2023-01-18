class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        
        if n == 1: return 0
        
        jump_no = 1
        l, r = 1, nums[0]

        while r < n-1:
            jump_no += 1     
            r_nxt = max(i + nums[i] for i in range(l, r+1))
            l, r = r+1, r_nxt            

        return jump_no