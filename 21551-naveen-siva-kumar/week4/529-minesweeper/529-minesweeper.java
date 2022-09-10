class Solution {
    
    /*basic-idea
    
    if its mine then mark x and return.
    else check for mines around and fill the value.
    
    if there are no mines around and its a blank,then recursively call the same updateborad function so that the board is fully revealed.
    
    These 3 conditions are written in 3 functions below.
    
    */
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        
        if (board[row][col] == 'M'){
            board[row][col] = 'X';
        } else {
            int count = minesCount(board,row, col);
            if (count > 0){
                board[row][col] = (char)(count + '0');
            } else {
                board[row][col] = 'B';
                boardReveal(board,row, col);
            }    
        }
        return board;
    }
    
    public int minesCount(char[][] board,int row, int col){
        
        int m = board.length;
        int n = board[0].length;
        int count =0;
        int r,c;
        
        //check in all 8 neighbours
        
        for (int i = -1; i < 2; i++){
            
            for (int j = -1; j < 2; j++){
                
                if (i ==0 && j ==0) continue;
                
                r = row + i;
                c = col + j;
                
                if (r < 0 || r >= m || c < 0 || c >= n) continue;//outofbounds
                if (board[r][c] == 'M' || board[r][c] == 'X'){
                    count++;
                }
            }
        }
        return count;   
    }
    
    public void boardReveal(char[][] board,int row,int col){
        
        int m = board.length;
        int n = board[0].length;
        int r,c;
        
        //going through all the 8 neighbours and updating them.
        for (int i = -1; i < 2; i++){
                
            for (int j = -1; j < 2; j++){
                    
                    r = row + i;
                    c = col + j;
                    
                    if (r < 0 || r >= m || c < 0 || c >= n) continue;
                    if (board[r][c] == 'E'){
                        updateBoard(board, new int[]{r, c});
                    }
            }
        }
        return;
    }
}