class Solution {
public:
    int maxDepth(string s) {
        int braces_count =0;
        int ans =0;
        //cout<<s.size()-1<<endl;
        for(int i=s.size()-1;i>-1;i--){
            
            if(s[i]==')') {
                braces_count++;
            }
            else if(s[i]=='('){
                braces_count--;
            }
            ans = std::max(ans,braces_count);
        }
        return ans;
    }
};