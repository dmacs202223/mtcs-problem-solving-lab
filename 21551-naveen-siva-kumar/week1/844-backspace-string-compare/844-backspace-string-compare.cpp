class Solution {
public:
    bool backspaceCompare(string s, string t) {
        
        
        /* using two stacks for two strings and then comapring two stacks */
        
        stack<char> string1Chars;
        stack<char> string2Chars;
        
        for(int i=0;i<s.size();i++){
            
            if(s[i]!='#'){ 
                
                string1Chars.push(s[i]);
                
            }
            else{ 
                
                if(string1Chars.empty()) {
                    continue;
                    //return false;
                }
                else string1Chars.pop(); 
            }
        }
        
        for(int i=0;i<t.size();i++){
            
            if(t[i]!='#'){ 
                
                string2Chars.push(t[i]);
                
            }
            else{ 
                
                if(string2Chars.empty()) {
                    continue;//return false;
                }
                else string2Chars.pop(); 
            }
        }
        
        char s_c,t_c;
        
        
        
        if(string1Chars.size() == string2Chars.size()){
            
            //for(int i=0;i<string1Chars.size();i++){
            while(!string1Chars.empty()) {   
                s_c = string1Chars.top();
                t_c = string2Chars.top();
                cout<<s_c<<t_c<<endl;
                if(s_c!=t_c) return false;
                
                else{
                    string1Chars.pop();
                    string2Chars.pop();
                }
                    
            }
            return true;
        }else 
            return false;
        
    }
};