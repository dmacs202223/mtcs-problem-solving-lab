# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # `inorder_map` is used to select the appropriate list of values for the left and the right subtrees, respectively.
        inorder_map = {}
        for i, num in enumerate(inorder):
            inorder_map[num] = i
        # Start from the left end of `preorder` to build the tree from its root
        self.preorder_index = 0
        
        def build(start, end):
            if start > end:
                return None
            rootVal = preorder[self.preorder_index]
            self.preorder_index += 1
            root = TreeNode(rootVal)
            # Build the subtrees using `inorder_map` to get the appropriate "bisection" (It's put in quotes because we aren't actualy bisecting anything.)
            root.left = build(start, inorder_map[rootVal]-1)
            root.right = build(inorder_map[rootVal]+1, end)
            return root
        
        return build(0, len(preorder)-1)
