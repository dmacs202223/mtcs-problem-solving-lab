class Solution {
    public int maxDepth(String s) {
        
        Stack braces = new Stack();
        
        char[] str = s.toCharArray();
        
        int ans = 0,count=0;
        
        for(int i=0;i<s.length();i++){
            
            if(str[i]=='('){
                
                braces.push(str[i]);
                count+=1;
            }
            else if(str[i]==')'){
                
                //if(braces.empty()){ continue;}
                ans = Math.max(ans,count);
                braces.pop();
                count--;
            }
            else{
                continue;
            }
        }
        return ans;
        
    }
}

