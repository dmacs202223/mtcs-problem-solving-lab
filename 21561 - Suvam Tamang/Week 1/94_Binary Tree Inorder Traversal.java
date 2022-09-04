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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        if (root == null){
            return result;
        }
        
        while(current!=null || !stack.empty()){
            if(current==null){
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
            else{
                stack.push(current);
                current = current.left;
            }
        }
   
       
        return result;
    }
}
