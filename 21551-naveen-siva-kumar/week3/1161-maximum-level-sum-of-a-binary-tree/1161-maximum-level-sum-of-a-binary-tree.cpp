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
        /* 
            Create the preorder list using queue and then add level by level
            
        */
        if(root->left==nullptr && root->right==nullptr){
            return 1;
        }
        queue<TreeNode*> Q;
        vector<int> levelSumVec;
        int levelSum = 0;
        bool loop =true;
        Q.push(root);
        TreeNode* temp;
        
        int max = INT_MIN;
        int ans=0;
        int level=0;
        
        while(!Q.empty()){
            levelSum = 0;
            int size = Q.size();
            for(int i=0;i<size;i++){
                levelSum+=Q.front()->val;
                if(Q.front()->left){
                    Q.push(Q.front()->left);
                        
                }
                if(Q.front()->right){
                    Q.push(Q.front()->right);
                        
                }
                
                
                Q.pop();
                
            }
            level++;
            
            if(max<levelSum){
                max = levelSum;
                ans=level;
            }
            //levelSumVec.push_back(levelSum);
            
            //Q.pop();
            
        }

        return ans;
        

        
        
    }
};

