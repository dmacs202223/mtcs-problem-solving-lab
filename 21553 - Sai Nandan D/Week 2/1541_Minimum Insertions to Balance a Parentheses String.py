class Solution:
    def minInsertions(self, s: str) -> int:
        pairs, ones = 0, 0
        i, n = 0, len(s)
        
        while i < n:
            if s[i] == '(': pairs += 1                
            else:
                if i == n-1 or s[i+1] != ')': ones += 1
                else: i += 1                
                if not pairs: ones += 1
                else: pairs -= 1                
            i += 1
            
        return 2 * pairs + ones
