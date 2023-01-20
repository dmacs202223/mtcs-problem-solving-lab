class Solution {
public:
    string longestPalindrome(string s) {
        int n =s.length();
        int start=0,end=1;
        
        bool dp[n][n];
        memset(dp,0,sizeof(dp));
        int i,j;
        

        for(i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(i=0;i<n-1;i++){
            if(s[i]==s[i+1]){
                dp[i][i+1]=true;
                start = i;
                end=2;
            }
        }

        int right,left;
        for(i=2;i<n;i++){
            for(j=0;j<n-i;j++){
                 left=j;right=i+j;
                if(dp[left+1][right-1]==true && s[left]==s[right]){
                    dp[left][right]=true; 
                    start=j;
                    end=i+1;
                    
                } 
            }
        }

        
        return s.substr(start,end);
    }
};
