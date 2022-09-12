# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {}
        for i, n in enumerate(inorder):
            inorder_map[n] = i
        # To be able to build the tree from the root, we've to start from the right end of `postorder`
        self.postorder_idx = -1
        
        def build(start, end):
            if start > end: return None            
            rootVal = postorder[self.postorder_idx]
            self.postorder_idx -= 1
            root = TreeNode(rootVal)
            # Build the right subtree first
            root.right = build(inorder_map[rootVal]+1, end)
            # And then the left subtree
            root.left = build(start, inorder_map[rootVal]-1)            
            return root
            
        return build(0, len(inorder)-1)
