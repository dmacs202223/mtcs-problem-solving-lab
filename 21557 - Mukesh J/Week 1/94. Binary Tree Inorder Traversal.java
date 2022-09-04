Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]
 

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Data Structure: 
Stack, Depth First Search, Binary Tree

Idea:
1. Base conditions for recursive solution are if root is null and list is empty, then return the empty list as output.
2. Recursively traverse to left extreme node, root node, right side node and add all values to the list respectively.
3. After going through the full tree, return the list.
4. Time: O(N) where N is the number of nodes in the tree. 

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
    List<Integer> inorderList= new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null && inorderList.isEmpty())
            return inorderList;
        if(root==null)
            return null;
        inorderTraversal(root.left);
        inorderList.add(root.val);
        System.out.println(root.val);
        inorderTraversal(root.right);
        return inorderList;
    }
}
