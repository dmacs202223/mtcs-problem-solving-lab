class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        if(matrix.empty()) return 0;
        
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int longest = 0;
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                longest = max(longest, dfs(matrix, i, j, INT_MIN, dp));
            }
        
        return longest;
    }
    
    int dfs(const vector<vector<int>>& matrix, int i, int j, int prevEle, vector<vector<int>>& dp){
        
        if(i < 0 || i >= matrix.size() || j < 0 || j >= matrix[0].size()){
            return 0;
        }
        
        int top,bottom,left,right;
        
        if(matrix[i][j] > prevEle){
            
            if(dp[i][j]) return dp[i][j];
            
                top  = dfs(matrix, i - 1, j, matrix[i][j], dp) + 1;
            
                bottom  = dfs(matrix, i + 1, j, matrix[i][j], dp) + 1;
            
                left  = dfs(matrix, i, j - 1, matrix[i][j], dp) + 1;
            
                right = dfs(matrix, i, j + 1, matrix[i][j], dp) + 1;
            
            
            dp[i][j] = std::max(std::max(top, bottom), std::max(left, right));
            return dp[i][j];
        }
        
        return 0;
    }
    
};