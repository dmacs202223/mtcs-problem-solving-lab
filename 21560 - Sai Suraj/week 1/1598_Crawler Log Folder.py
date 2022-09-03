class Solution:
    def minOperations(self, logs: List[str]) -> int:
        curr_ops = 0
        for i in range(len(logs)):
            if logs[i] == "../":
                if curr_ops!=0:
                    curr_ops -= 1
                else:
                    continue
            elif logs[i]=='./':
                continue
            else:
                curr_ops+=1
        return curr_ops
