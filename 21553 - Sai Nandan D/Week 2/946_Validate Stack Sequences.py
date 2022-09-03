class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = []
        i = 0
        for x in pushed:
            stack.append(x)
            while stack and stack[-1] == popped[i]:
                i += 1
                stack.pop()
                
        return len(stack) == 0
