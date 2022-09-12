class Solution {
public:
    int maxDepth(string s) {
        int depth = 0, count = 0;
        int length = s.length();
        
        if(length == 0 || (length == 1 && (s[0] != '(' || s[0] != ')')))
            return depth;
        
        stack<char> stck;
        for(int i = 0; i < length; i++){
            if(s[i] == '('){
                stck.push(s[i]);
                ++count;
                depth = max(count, depth);
            }
            else if(s[i] == ')' && stck.top() == '('){
                stck.pop();
                --count;
                depth = max(count, depth);
            }
            else
                continue;
        }
        return depth;
    }
};