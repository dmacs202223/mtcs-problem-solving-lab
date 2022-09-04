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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);   // preorder[0] is anyways the root of the tree by the property of the preorder traversal
        
        for(int i=1; i<preorder.length;i++){
            helperCreate(root, preorder[i]);
        }
        return root;
    }
    
    public void helperCreate(TreeNode root, int value){
        TreeNode temp = root;
        // if the value to be added is lesser than the value that we are currently scanning
        // then we traverse to the left subtree until we find a null value in which case we input the value.
        if(value < temp.val){
            if(temp.left != null){
                helperCreate(temp.left, value);
            }
            else{
                temp.left = new TreeNode(value);
            }
        }
        // if the value to be added is greater than the value that we are currently scanning
        // then we traverse to the right subtree until we find a null value in which case we input the value.
        if(value > temp.val){
            if(temp.right != null && temp.val < value){
                helperCreate(temp.right, value);
            }
            else{
                temp.right = new TreeNode(value);
            }
        }
    }
    
}
