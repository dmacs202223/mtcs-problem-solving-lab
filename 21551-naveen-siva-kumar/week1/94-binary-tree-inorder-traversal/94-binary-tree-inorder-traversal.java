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
    
    public  List<Integer> inOrderElementsList = new ArrayList();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        /*using stack in the sense of recursion */
        
        if(root==null){
            return inOrderElementsList;
        }
        
        inorderTraversal(root.left);
        inOrderElementsList.add(root.val);
        inorderTraversal(root.right);
        
        return inOrderElementsList;
    }
    
    
}