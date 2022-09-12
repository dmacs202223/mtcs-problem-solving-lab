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
    public TreeNode increasingBST(TreeNode root) {
        Stack <TreeNode> stack = new Stack <> ();
        List <Integer> list = new ArrayList <> ();
        TreeNode head = new TreeNode(0);
        TreeNode temp = head;
        TreeNode current = root;
        
        if(root == null){
            return null;
        }
        
        while(current != null || !stack.empty()){
            if(current == null){
                current = stack.pop(); 
                list.add(current.val);
                current = current.right;
            }
            else{
                stack.push(current);
                current = current.left;
            }
        }
        
        for(int value : list){
            temp.right = new TreeNode(value);
            temp = temp.right;
        }
        
        return head.right;
    }
}
