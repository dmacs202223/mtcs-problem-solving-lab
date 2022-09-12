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
    vector<int> ans;
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode*> stck;
        TreeNode* curr_node = root;
        while(stck.empty() == false || curr_node != nullptr){
            if(curr_node != nullptr){
                stck.push(curr_node);
                curr_node = curr_node->left;
            }
            else{
                curr_node = stck.top();
                stck.pop();
                ans.push_back(curr_node->val);
                curr_node = curr_node->right;
            }
        }
        return ans;
    
    }
};