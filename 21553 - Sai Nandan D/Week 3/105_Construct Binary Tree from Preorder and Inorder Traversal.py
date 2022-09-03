# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {}
        for i, num in enumerate(inorder):
            inorder_map[num] = i
        self.preorder_index = 0
        
        def build(start, end):
            if start > end:
                return None
            rootVal = preorder[self.preorder_index]
            self.preorder_index += 1
            root = TreeNode(rootVal)            
            root.left = build(start, inorder_map[rootVal]-1)
            root.right = build(inorder_map[rootVal]+1, end)
            return root
        
        return build(0, len(preorder)-1)
