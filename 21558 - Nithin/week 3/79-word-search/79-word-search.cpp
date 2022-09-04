class Solution {
public:
    // Initialize direction vectors
   // int dRow[] = { 0, 1, 0, -1 };
    //int dCol[] = { -1, 0, 1, 0 };
    
    bool dfs_search(vector<vector<char>>&board, int i, int j,string word){
        if(word.size() == 0)
            return true;
         if (i<0 || i>=board.size() || j<0 || j>=board[0].size() || board[i][j] != word[0])  
            return false;
         char temp = board[i][j];
         string ch = word.substr(1);
         board[i][j] = '#';
         bool t_F = dfs_search(board, i-1, j, ch) || dfs_search(board, i, j-1, ch) || dfs_search(board, i+1, j, ch) || dfs_search(board, i, j+1, ch);
        board[i][j] = temp;
        return t_F;
    }

    bool exist(vector<vector<char>>& board, string word) {
        int str_len  = word.length();
        int m = board.size();
        int n = board[0].size();
        int k = 0;
        
        if(str_len > m*n)
            return false;
        
        unordered_map<char, int> map;
        for(int i = 0; i < m; i++)
            for(int j = 0;j < n;j++)
                ++map[board[i][j]];
        for(int i = 0;i < str_len; i++)
        {
            --map[word[i]];
            if(map[word[i]] < 0)
                return false;
        }
        
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                           if(dfs_search(board, i, j, word))
                               return true;
            }
        }
        return false;
    }
};