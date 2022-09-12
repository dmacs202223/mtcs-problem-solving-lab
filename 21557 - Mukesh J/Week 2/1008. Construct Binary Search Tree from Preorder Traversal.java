Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 

  Example 1:

Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12].

  Example 2:

Input: preorder = [1,3]
Output: [1,null,3].
 

  Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 1000
All the values of preorder are unique.


  Data Structure:

Tree, Binary Tree.
  
  Idea:
1. Construct an insert function with root and value to be inserted to the binary search tree.
2. In the insert function, if the root's value is greater than the given value, then traverse to the right side of the tree recursively and insert. 
3. If the root’s value is less than the given value, then traverse to the left side of the tree recursively and insert.
4. If root is null, then return node with value.
5. In the bstFromPreorder function, Each value in the preorder array is sent to BST’s root node for inserting.
6. Once all preorder array elements are inserted, then return root.
7. Time: O(N) where N is the length of the Preorder Array.


  Solution:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode insert(TreeNode root, int val){
        if(root==null)
            return new TreeNode(val);
        if(val>root.val)
            root.right=insert(root.right,val);
        if(val<root.val) 
            root.left=insert(root.left,val);
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i=0;i<preorder.length;i++){
            root=insert(root,preorder[i]);
        }
        return root;
    }
}
