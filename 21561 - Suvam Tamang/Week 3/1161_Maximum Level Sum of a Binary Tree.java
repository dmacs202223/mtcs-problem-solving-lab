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
    public int maxLevelSum(TreeNode root) {
        int levelSum;
        int maxSum = root.val;
        int maxlevel = 1;
        int level = 1;
        int size = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            levelSum = 0;
            size = q.size();
            for(int i=0;i<size;i++){
                TreeNode tempNode = q.poll();
            
                if (tempNode.left != null) {
                    q.add(tempNode.left);
                }

                if (tempNode.right != null) {
                    q.add(tempNode.right);
                }
                levelSum += tempNode.val;
            }
            
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxlevel = level;
            }
            level++;
        }
        return maxlevel;
    }
}
