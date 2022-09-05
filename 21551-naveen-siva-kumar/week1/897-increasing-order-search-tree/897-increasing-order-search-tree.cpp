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
    TreeNode* increasingBST(TreeNode* root) {
        
        stack<TreeNode*> ele ;
        
        TreeNode *node1=root,*node2=root;
        TreeNode *newRoot;
        
        //TreeNode* 
        bool flag = true;
        
        while(node1!=nullptr || !ele.empty()){
            if(node1!=nullptr){
                ele.push(node1);
                node1 = node1->left;
                
            }
            else{
                if(flag){
                    newRoot = ele.top();
                    ele.pop();
                    node1 = newRoot;
                    node2 = newRoot;
                    newRoot->left = nullptr;
                    flag = false;
                }
                else{
                    node1 = ele.top();
                    ele.pop();
                    node2->right = node1;
                    node1->left=nullptr;
                    node2=node2->right;
                }
                
                node1 = node1->right;
            }
        }
        return newRoot;
    }
};

/* 
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
        }*/