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
    vector<int> inorderTraversal(TreeNode* root) {
        /*doing this in iterative way*/
        
        /* 
        
        First push the root on stack and go left repeat this until root is not null
        
        if root is null then push rhe value to vector and pop the root node and take its            right 
        repeat this sequence untill nothing is left in stack(so that i have traversed               all the elements in tree) or root is not null
        
        If both are happenning then we have traversed all the tree
        
        
        */
        
        vector<int> elements;
        
        stack<TreeNode*> ele ;
        
        TreeNode* node1=root;
        
        //TreeNode* 
        
        while(node1!=nullptr || !ele.empty()){
            if(node1!=nullptr){
                ele.push(node1);
                node1 = node1->left;
                
            }
            else{
                elements.push_back(ele.top()->val);
                node1=ele.top();
                ele.pop();
                node1 = node1->right;
            }
        }
        return elements;
        
    }
};