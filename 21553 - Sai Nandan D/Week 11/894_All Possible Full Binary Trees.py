# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    dp = {0:[], 1:[TreeNode()]}
    def allPossibleFBT(self, n: int) -> List[Optional[TreeNode]]:
        if n % 2 == 0:
            return self.dp[0]

        if n not in self.dp:
            trees = []
            for i in range(1, n-1, 2):
                for l in self.allPossibleFBT(i):
                    for r in self.allPossibleFBT(n-i-1):
                        trees.append(TreeNode(0, l, r))
            self.dp[n] = trees

        return self.dp[n]
