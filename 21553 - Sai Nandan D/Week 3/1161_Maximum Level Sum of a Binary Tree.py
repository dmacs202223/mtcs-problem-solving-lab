# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        max_total, nodes = root.val, [root]                
        max_level, level = 1, 1                
        
        while nodes:            
            total = 0
            level_nodes = []
            for node in nodes:                
                total += node.val
                if node.left: level_nodes.append(node.left)
                if node.right: level_nodes.append(node.right)                    
            if total > max_total:
                max_total = total
                max_level = level
            nodes = level_nodes
            level += 1
            
        return max_level
