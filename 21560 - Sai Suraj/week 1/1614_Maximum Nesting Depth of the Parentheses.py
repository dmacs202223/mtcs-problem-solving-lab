class Solution:
    def maxDepth(self, s: str) -> int:
        curr_depth = depth = 0
        for c in s:
            if c=="(":
                curr_depth +=1
                
            if c==")":
                depth = max(depth,curr_depth)
                curr_depth-=1
        return depth
