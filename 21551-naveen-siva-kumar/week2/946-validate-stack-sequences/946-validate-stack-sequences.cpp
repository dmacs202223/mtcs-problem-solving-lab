class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        
        stack<int> push_st;
        int j=0;
    
        
        for(int i=0;i<pushed.size();i++)
        {
            push_st.push(pushed[i]);
        
            while(push_st.size() > 0 && popped[j] == push_st.top())
            {
                push_st.pop();
            
                j++;
            }
        }
        if(push_st.size()==0)
            return true;
        else 
            return false;

    }
};