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
    //public int left=0,right;
    //public TreeNode r;
    int j=0;
    int size =0;
public : TreeNode* bst(vector<int>& preorder,int left,int right){
    
        //cout<<"left :"<<left<<"right :"<<right<<endl;
        //cout<<"preorder[left] "<<preorder[left]<<"preorder[right] "<<preorder[right]<<endl;
        TreeNode* root = new TreeNode(preorder[left],nullptr,nullptr);   
        //TreeNode* r = root;
        if(left==right) return root;
        int temp = left,mid = -1;
        for(int i=left+1;i<=right;i++){
            
            if(i==right) break;
            
            if((preorder[i]<preorder[temp]) && (preorder[temp]<preorder[i+1])){
                
                mid=i;
                
                j++;
                //cout<<"i :"<<i<<" i+1 :"<<i+1<<"temp"<<temp<<endl;
                //cout<<"left"<<left<<"mid"<<mid<<"right"<<right<<endl;
                //cout<<"mid"<<mid<<endl;
                //cout<<preorder[i]<<" "<<preorder[temp]<<" "<<preorder[i+1]<<endl;
                //cout<<"j "<<j<<endl;
                break;
            }
            
        }
        //cout<<mid<<endl;
        if(mid==-1 && preorder[temp]>preorder[temp+1]){
                //mid=left;
                //cout<<"i :"<<i<<" i+1 :"<<i+1<<"temp"<<temp<<endl;
                //cout<<"left"<<left<<"mid"<<mid<<"right"<<right<<endl;
                //cout<<"mid"<<mid<<endl;
                //cout<<preorder[i]<<" "<<preorder[temp]<<" "<<preorder[i+1]<<endl;
                root->left=bst(preorder,left+1,right);
                //cout<<"left value"<<(root->left)->val;//<<endl;
                //cout<<" for "<<root->val<<endl;
                return root;
            }
            if(mid==-1 && preorder[temp]<preorder[temp+1]){
                //mid=left;
                root->right=bst(preorder,left+1,right);
                return root;
            }
        //cout<<endl;
        //cout<<"left "<<preorder[left+1]<<"mid "<<preorder[mid]<<endl;
        //if(left+1 < this->size){
            if(left+1>mid){
                root->left = nullptr;
            }
            else{ 
                //if(left+1)
                root->left = bst(preorder,left+1,mid);
            }
            // if(root->left!=nullptr){
            //     cout<<"left value"<<(root->left)->val;
            //     cout<<" for "<<root->val<<endl;
            // }
            // else{
            //     cout<<"left value"<<"null";//<<endl;
            //     cout<<" for "<<root->val<<endl;
            // }
            //cout<<endl;
            //cout<<"right "<<preorder[right]<<"mid "<<preorder[mid+1]<<endl;
            if(mid+1>right){
                root->right=nullptr;
            }
            else {
                if(mid+1>this->size){
                    mid=right-1;
                }
                else
                    root->right = bst(preorder,mid+1,right);
            }
            // if(root->right!=nullptr) {      
            //     cout<<"right value"<<(root->right)->val;
            //     cout<<" for "<<root->val<<endl;
            // }
            //     //cout<<endl;
            // else{
            //     cout<<"right value"<<"null";
            //     cout<<" for "<<root->val<<endl;
            // }
        //}
        return root;
        
        
    }
    
    
    
public:
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        this->size=preorder.size();
        return bst(preorder,0,preorder.size()-1);

    }
};