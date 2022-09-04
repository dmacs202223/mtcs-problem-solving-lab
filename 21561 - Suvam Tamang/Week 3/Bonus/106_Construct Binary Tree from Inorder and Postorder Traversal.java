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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(postorder.length != inorder.length) 
             return null;
         return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode build(int[] postorder, int postLow, int postHigh, int[] inorder, int inLow, int inHigh){
        if(postLow > postHigh || inLow > inHigh)
            return null;
        TreeNode root = new TreeNode(postorder[postHigh]);
        
        int inorderRoot = inLow;
        for(int i=inLow;i<=inHigh;i++){
            if(inorder[i]==root.val){ 
                inorderRoot=i; 
                break; 
            }
        }
        int leftTreeLen = inorderRoot-inLow;
        root.left = build(postorder, postLow, postLow+leftTreeLen-1, inorder, inLow, inorderRoot-1);
        root.right = build(postorder, postLow+leftTreeLen, postHigh-1, inorder, inorderRoot+1, inHigh);       
        return root;   
    }
}
