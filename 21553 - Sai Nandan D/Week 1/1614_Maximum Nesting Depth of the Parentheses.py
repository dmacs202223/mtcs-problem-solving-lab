class Solution:
    def maxDepth(self, s: str) -> int:
        nest = 0
        max_nest = 0
        for c in s:
            if c == '(':
                nest += 1
            elif c == ')':
                nest -= 1
            if nest > max_nest:
                max_nest = nest
            
        return max_nest
