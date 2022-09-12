class Solution:
    def minOperations(self, logs: List[str]) -> int:
        num_op = 0
        for d in logs:            
            if d[:-1] == '..':
                if num_op > 0:
                    num_op -= 1
            elif d[:-1] == '.':
                continue
            else:
                num_op += 1
                
        return num_op                    
