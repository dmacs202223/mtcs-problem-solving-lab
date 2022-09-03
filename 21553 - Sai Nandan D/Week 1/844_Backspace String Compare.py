class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:                
        def undeleted_chars(x):
            skip = 0
            for c in x[::-1]:
                if c == '#':
                    skip += 1
                elif skip:
                    skip -= 1
                else:
                    yield c
        try:          
            for s_c, t_c in zip(undeleted_chars(s), undeleted_chars(t), strict=True):
                if s_c != t_c:
                    return False
            return True            
        except ValueError as ve:
            return False
