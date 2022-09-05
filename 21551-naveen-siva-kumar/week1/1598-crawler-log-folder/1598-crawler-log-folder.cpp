class Solution {
public:
    
    /* 
    just counting all the child directories while staying back when its ./ ans  going back when its ../
    
    but when its root ,../ doesn't effect
    
    */
    int minOperations(vector<string>& logs) {
        
        int ans = 0;
        
        //string element;
        
        for(int i=0;i<logs.size();i++){
            
            if(logs[i]!="../" && logs[i]!="./"){
                
                ans++;
            }
            else if(logs[i]=="./"){
                
                continue;
            }
            else if(logs[i]=="../"){
                
                if(ans!=0) ans--;
            }
        }
        return ans;
    }
};