# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: TreeNode) -> int:
        q,maxl,maxs,lcount=[root],1,root.val,1
        while q:
            levelsum,newq=0,[]
            for n in q:
                if n.left: newq+=[n.left]
                if n.right: newq+=[n.right]
                levelsum+=n.val
            q=newq
            if levelsum>maxs:
                maxl=lcount
                maxs=levelsum
            lcount+=1
        return maxl
