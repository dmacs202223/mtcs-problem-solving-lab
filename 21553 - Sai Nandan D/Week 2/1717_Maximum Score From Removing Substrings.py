class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:        
        def get_points(s: str, p: int, a: str, b: str) -> (int, str):           
            stack = []
            points = 0            
            for ch in s:
                if ch != b:
                    stack.append(ch)                    
                elif stack and stack[-1] == a:
                    stack.pop()
                    points += p
                else:
                    stack.append(ch)
            return points, ''.join(stack)
            
        if x > y:
            a, b = 'a', 'b'
        else:
            a, b = 'b', 'a'
            x, y = y, x
            
        ab, t = get_points(s, x, a, b)
        ba, _ = get_points(t, y, b, a)        
        
        return ab + ba
