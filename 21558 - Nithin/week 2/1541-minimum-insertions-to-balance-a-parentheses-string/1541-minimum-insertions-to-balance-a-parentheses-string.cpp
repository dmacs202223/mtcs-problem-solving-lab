class Solution {
public:
    int minInsertions(string s) {
        stack<char> stck1;
        int min_ins = 0;
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s[i] == '(')
                stck1.push(s[i]);
            else{
                if(s[i+1] == ')'){
                    if(!stck1.empty())
                        stck1.pop();
                    else
                        min_ins += 1;
                    i += 1;
                }
                else
                    if(!stck1.empty()){
                        stck1.pop();
                        min_ins += 1;
                    }
                    else{
                       min_ins += 2;
                     }
                }
        }
        
        while(!stck1.empty()){
            min_ins += 2;
            stck1.pop();
        }
        return min_ins;
    }
};