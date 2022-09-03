class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        visited = {}
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.getwords(board,word,i,j,visited):
                    return True
        return False
    
    def getwords(self,board,word,i,j,visited,pos=0):
        if pos == len(word):
            return True
        if i < 0 or i == len(board) or j < 0 or j == len(board[0]) or visited.get((i, j)) or word[pos] != board[i][j]:
            return False
        visited[(i, j)] = True
        res = self.getwords(board, word, i, j + 1, visited, pos + 1) \
                or self.getwords(board, word, i, j - 1, visited, pos + 1) \
                or self.getwords(board, word, i + 1, j, visited, pos + 1) \
                or self.getwords(board, word, i - 1, j, visited, pos + 1)
        visited[(i, j)] = False
        return res
        
