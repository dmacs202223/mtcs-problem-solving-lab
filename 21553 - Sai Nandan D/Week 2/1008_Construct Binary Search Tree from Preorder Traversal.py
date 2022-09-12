# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Iterative
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        root = TreeNode(preorder[0])
        stack = [root]
        
        for val in preorder[1:]:
            if val < stack[-1].val:
                stack[-1].left = TreeNode(val)
                stack.append(stack[-1].left)                
                
            else:
                while stack and val > stack[-1].val:
                    temp = stack.pop()
                sub_root = temp
                sub_root.right = TreeNode(val)
                stack.append(sub_root.right)                
                
        return root
        
       
# Recursive
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        root = TreeNode(preorder[0])
        right_subroot = bisect.bisect(preorder, preorder[0])
        root.left = self.bstFromPreorder(preorder[1:right_subroot])
        root.right = self.bstFromPreorder(preorder[right_subroot:])
        
        return root
