Question : 

Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child. 

Example 1:
Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

Example 2:
Input: root = [5,1,7]
Output: [1,null,5,null,7]
 

Constraints:
The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000 

Data Structure:
Stack, Depth First Search, Tree, Recursion

Idea:
Do inorder traversal.
First goto extreme left of the tree and add the left, root and right of the tree to the right side of the new tree respectively.
After going through the full tree, return the root node of the new tree.
Time: O(n).


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
    TreeNode temp=null;   // Declaring Globally
    TreeNode root2=null;  // Declaring Globally another Tree's head
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)
            return null;
        increasingBST(root.left);           // Traversing to left side.
        if(root2==null)                     // Adding to new Tree.
        {
            temp = new TreeNode(root.val);    // Creating a new node.
            root2= temp;
        }
        else
        {
            temp.right= new TreeNode(root.val);     // Creating a new node
            temp = temp.right;
        }
        increasingBST(root.right);              // Traversing to Right Side.
        return root2;                           // Returning a new Tree's root node.
    }
}
  
  
