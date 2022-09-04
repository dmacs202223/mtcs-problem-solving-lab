class Solution {
    public:
    bool dfs(vector<vector<char>>& board,int index,int row,int col,string word){
        
        /*check if the indices are out of bound*/
        
        if(row<0 || row>=board.size() || col<0 || col>=board[0].size() ){
            //cout<<"OUT OF BOUND";
            return false;
        }
        if(board.size()==0){
            //cout<<"no board"<<endl;
            return false;     //No board only to traverse.
        }
        
        
        if(board[row][col]!=word[index] || board[row][col]== '.' ){
            //cout<<"came across anothe char than expected or visited again"<<endl;
            return false;    //we have already visited or got a dead end
        }
        
        if(index==word.size()-1 && board[row][col]==word[index]){
            cout<<"reached the word length";
            return true;        //we have traversed through the word
        }
        
        char c = board[row][col];
        board[row][col]='.';
        
        bool res = dfs(board,index+1, row+1, col, word) ||
                   dfs(board,index+1, row-1, col, word) ||
                   dfs(board,index+1, row, col+1, word) ||
                   dfs(board,index+1, row, col-1, word);
        
        board[row][col] =c;
        return res;
    }
    
    
public:
    bool exist(vector<vector<char>>& board, string word) {
        for(int i =0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(dfs(board,0,i,j,word)){
                    return true;
                }
            }
        }
        return false;
    }
};
