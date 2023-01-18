class Solution:
    def jump(self, nums: List[int]) -> int:
        jumps = 0
        i=0
        max_reacheable = 0
        last_jump_pos=0
        while(last_jump_pos<len(nums)-1):
            max_reacheable = max(max_reacheable,i+nums[i])
            if(i==last_jump_pos):
                last_jump_pos = max_reacheable
                jumps+=1
            i+=1
        return jumps
