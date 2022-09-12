class Solution {
    
public : 
    int helper(string &s,int x,int y,char a,char b){
        stack<char> charForward;
        stack<char> charBackward;
        
        char charTop,c;
        int maxScore =0;
        bool flag = false;
        
        if(s.size()<2){
            return 0;
        }
        
        
         charForward.push(s[0]);
            
         for(int i=1;i<s.size();i++){
                
                if(charForward.empty())
                {
                    charForward.push(s[i]);
                    continue;
                }
                else{
                    if(charForward.top()==b && s[i]==a){
                        charForward.pop();
                        maxScore+=y;
                    }
                    else{
                        charForward.push(s[i]);
                        
                    }
                }            
          }
            string t="";
            //int ans1=0;
            while(charForward.size()>0)
            {
                t+=charForward.top();
                charForward.pop();
            }
            reverse(t.begin(),t.end());
            
            if(t!=""){
                charForward.push(t[0]);
            
                for(int i=1;i<t.size();i++){
                
                    if(charForward.empty())
                    {
                        charForward.push(t[i]);
                        continue;
                    }
                    else{
                        if(charForward.top()==a && t[i]==b){
                            charForward.pop();
                            maxScore+=x;
                        }
                        else{
                            charForward.push(t[i]);
                        
                        }
                    }            
                }
            }
            
            
            return maxScore;
    }
public:
    int maximumGain(string s, int x, int y) {
        stack<char> charForward;
        stack<char> charBackward;
        
        char charTop,c;
        int maxScore =0;
        bool flag = false;
        
        if(s.size()<2){
            return 0;
        }
        else if(s.size()==2){
            if(s=="ab") return x;
            else if(s=="ba")  return y;
            else return 0;
        }
        
        if(y>x)
            return helper(s,x,y,'a','b');
        else
            return helper(s,y,x,'b','a');
            //need to search for 'ba' to get maximum
            //so push all the elements char by char and see if we can get ba consecutively then pop.
            //then revert and once again from reverted stack start pushing in ,while pushing see if we can get 'ab' second best.
            
            
            
//             charForward.push(s[0]);
            
//             for(int i=1;i<s.size();i++){
                
//                 if(charForward.empty())
//                 {
//                     charForward.push(s[i]);
//                     continue;
//                 }
//                 else{
//                     if(charForward.top()=='b' && s[i]=='a'){
//                         charForward.pop();
//                         maxScore+=y;
//                     }
//                     else{
//                         charForward.push(s[i]);
                        
//                     }
//                 }            
//             }
//             string t="";
//             int ans1=0;
//             while(charForward.size()>0)
//             {
//                 t+=charForward.top();
//                 charForward.pop();
//             }
//             reverse(t.begin(),t.end());
            
//             for(int i=0;i<t.size();i++)
//             {
//                 if(t[i]=='a'&&charForward.size()>0&&charForward.top()=='b')
//                 {
//                     maxScore+=x;
//                     charForward.pop();
//                 }
//                 else
//                 charForward.push(t[i]);
//             }
//             while(!charForward.empty()){
//                 charBackward.push(charForward.top());
//                 charForward.pop();
//             }
            
//             if(!charBackward.empty()){
//                 charForward.push(charBackward.top());
//                 charBackward.pop();
//             }
            
//             while(!charBackward.empty()){
//                 if(charForward.empty())
//                 {
//                     charForward.push(charBackward.top());
//                     charBackward.pop();
//                     continue;
//                 }
//                 else{
//                     if(charForward.top()=='a' && charBackward.top()=='b'){
//                         charForward.pop();
//                         //charBackward.pop();
//                         maxScore+=x;
//                     }
//                     else{
//                         charForward.push(charBackward.top());
//                         charBackward.pop();
                        
//                     }
//                 } 
//             }
            
            
        //}
//         else{
//             //need to search for 'ab' to get maximum
//             //so push all the elements char by char and see if we can get ba consecutively then pop.
//             //then revert and once again from reverted stack start pushing in ,while pushing see if we can get 'ba' second best.
            
//             charForward.push(s[0]);
            
//             for(int i=1;i<s.size();i++){
                
//                 if(charForward.empty())
//                 {
//                     charForward.push(s[i]);
//                     continue;
//                 }
//                 else{
//                     if(charForward.top()=='a' && s[i]=='b'){
//                         charForward.pop();
//                         maxScore+=x;
//                     }
//                     else{
//                         charForward.push(s[i]);
                        
//                     }
//                 }            
//             }
            
//             while(!charForward.empty()){
//                 charBackward.push(charForward.top());
//                 charForward.pop();
//             }
            
//             if(!charBackward.empty()){
//                 charForward.push(charBackward.top());
//                 charBackward.pop();
//             }
            
//             while(!charBackward.empty()){
//                 if(charForward.empty())
//                 {
//                     charForward.push(charBackward.top());
//                     charBackward.pop();
//                     continue;
//                 }
//                 else{
//                     if(charForward.top()=='b' && charBackward.top()=='a'){
//                         charForward.pop();
//                         //charBackward.pop();
//                         maxScore+=y;
//                     }
//                     else{
//                         charForward.push(charBackward.top());
//                         charBackward.pop();
                        
//                     }
//                 } 
//             }
//         }
//         return maxScore;
    }
};