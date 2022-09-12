class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> stck;
        int i=0,j=0;
        int len = pushed.size();
        
        while(j < len){ 
             
            if(!stck.empty() && popped[j] == stck.top()){
                stck.pop();
                ++j;
            }
            
            
            else if(i < len && pushed[i] != popped[j]){
                stck.push(pushed[i]);
                ++i;
            }
            
            else if(i < len && pushed[i] == popped[j]){
                    ++i;
                    ++j;
            }
            
            else
                break;
        }
        
        return stck.empty();
    }
};
