class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        m, n = len(board), len(board[0])        
        directions = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        
        def dfs(r, c):
            if 0 <= r < m and 0 <= c < n:
                if board[r][c] == 'E':
                    mines = sum([board[r+i][c+j] == 'M' for i,j in directions if 0 <= r+i < m and 0 <= c+j < n])
                    if mines:
                        board[r][c] = str(mines)
                    else:
                        board[r][c] = 'B'
                        for i, j in directions: dfs(r+i, c+j)
                    
        r, c = click
        if board[r][c] == 'M': board[r][c] = 'X'
        else: dfs(r, c)
            
        return board
