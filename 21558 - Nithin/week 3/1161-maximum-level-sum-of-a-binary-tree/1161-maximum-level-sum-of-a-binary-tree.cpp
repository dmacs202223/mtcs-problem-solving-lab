/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxLevelSum(TreeNode* root) {
        queue<TreeNode*> tree_queue;
        tree_queue.push(root);
        int level_sum, level = 1, qsize;
        int smallest_level, max_levelsum = INT_MIN;
        
        while(tree_queue.empty() == false){
            level_sum = 0;
            qsize = tree_queue.size();
            while(qsize != 0){
                TreeNode *node = tree_queue.front();
                tree_queue.pop();
                level_sum += node->val;
                if (node->left != NULL)
                    tree_queue.push(node->left);
                if (node->right != NULL)
                    tree_queue.push(node->right);
                --qsize;
            }
            if(level_sum > max_levelsum){
                smallest_level = level;
                max_levelsum = level_sum;
            }
            ++level;
        }
        return smallest_level;
        
    }
};