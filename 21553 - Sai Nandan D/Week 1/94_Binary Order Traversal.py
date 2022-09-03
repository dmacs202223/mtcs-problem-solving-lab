# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursive (DFS):
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root:
            return self.inorderTraversal(root.left) + [root.val] + self.inorderTraversal(root.right)
        else:
            return []
        
        
# Iterative (Depth-first):
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        vals = []
        stack = []
        node = root
        while node or stack:
            while node:
                stack.append(node)
                node = node.left                                                       
            node = stack.pop()
            vals.append(node.val)
            node = node.right
                
        return vals
        
  
# Iterative (Breadth-first):
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        nodes, vals = [(root, False)], []
        while nodes:
            node, visited = nodes.pop()
            if node:
                if visited:
                    vals.append(node.val)
                else:
                    nodes.append((node.right, False))
                    nodes.append((node, True))
                    nodes.append((node.left, False))
            
        return vals
