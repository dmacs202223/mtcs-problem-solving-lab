from collections import Counter
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        word_freq = Counter(word)        
        if word_freq - Counter(sum(board, [])): return False
        
        if word_freq[word[0]] > word_freq[word[-1]]: word = word[::-1]
        
        rows = len(board)
        cols = len(board[0])
        word_len = len(word)
        
        def search(r, c, w):
            if w == word_len: return True
            if not (0 <= r < rows and 0 <= c < cols): return False            
            if board[r][c] != word[w]: return False                        
            board[r][c] = None            
            found = search(r, c-1, w+1) or\
                    search(r-1, c, w+1) or\
                    search(r, c+1, w+1) or\
                    search(r+1, c, w+1)
            board[r][c] = word[w]
            return found
            
        
        for r in range(rows):
            for c in range(cols):
                found = search(r, c, 0)
                if found: return True
        return False
