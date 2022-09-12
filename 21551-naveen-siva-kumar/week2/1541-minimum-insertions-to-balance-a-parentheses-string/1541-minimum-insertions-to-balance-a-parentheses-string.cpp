
class Solution {
public:
    int minInsertions(string s) {
        int n=s.size();
        int cost=0, open=0;
        
        for(int i=0;i<n;i++){
            
            if(s[i] == '(')
                open++;
            else{
               
                if(open==0){
                    cost++;                    
                }
                else{
					
                    open--;
                }
               
                if(i==n-1 or s[i+1] != ')')cost++;
                else i++;
            }
        }
        
        cost += 2*(open); //this is for all those ( paranthesis still not closed
        return cost;
    }
};

