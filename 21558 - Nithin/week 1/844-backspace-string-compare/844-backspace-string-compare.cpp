class Solution {
public:
    bool backspaceCompare(string s, string t) {
        stack<char> stck1,stck2;
        bool flag = true;
        for(int i=0;i<s.size();i++){
            if(s[i] == '#'){
                if(!stck1.empty()){
                    stck1.pop();}
            }
            else
                stck1.push(s[i]);
        }
         for(int j=0;j<t.size();j++){
            if(t[j] == '#'){
                if(!stck2.empty()){
                    stck2.pop();}}
             else
                 stck2.push(t[j]);
        }
        if(stck1.size() != stck2.size())
            return false;
        
        while(stck1.empty() == false){
            if(stck1.top() == stck2.top()){
                stck1.pop();
                stck2.pop();
            }
            else{
                   flag = false;
                    break;
            }
        }
        return flag;
        
    }
};