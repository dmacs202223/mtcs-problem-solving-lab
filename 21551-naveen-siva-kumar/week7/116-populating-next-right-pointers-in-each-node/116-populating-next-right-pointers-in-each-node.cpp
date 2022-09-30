/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        
        if(root == NULL){ return root;}
        
        queue<Node*> q;
        Node* temp;
        int qSize;
        q.push(root);
        while(!q.empty()){
            
            
            qSize = q.size();
            
            
            for(int i=0;i<qSize;i++){
                
                temp = q.front();
                //cout<<"temp-val"<<temp->val<<endl;
                q.pop();
                
                if(i == qSize-1){
                    temp->next = NULL;
                }
                else{
                    //if(q.empty()) { temp->next = NULL; }
                    //else{
                    //cout<<"temp-val"<<temp->val<<endl;
                    temp->next = q.front();
                    //}
                }
                if(temp->left) { q.push(temp->left); }
                if(temp->right){ q.push(temp->right); }
            }
        }
        return root;
    }
};