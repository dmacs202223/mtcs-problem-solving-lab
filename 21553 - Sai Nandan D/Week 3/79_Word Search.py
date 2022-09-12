from collections import Counter
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # Check if the letters in the word are present in the board; return False if not
        word_freq = Counter(word) # frequency of each letter in the word
        board_freq = Counter(sum(board, [])) # frequency of each letter in the board
        if word_freq - board_freq: return False
        
        # If the first letter of the word occurs more frequently (in the board) than the last letter, then reverse the word.
        # (To reduce the number and depth of possible wrong paths)        
        if board_freq[word[0]] > board_freq[word[-1]]: word = word[::-1]
        
        rows = len(board)
        cols = len(board[0])
        word_len = len(word)
        
        def search(r, c, w):
            # All letters have been succesfully searched (in word order)
            if w == word_len: return True
            
            # Board boundaries
            if not (0 <= r < rows and 0 <= c < cols): return False
            
            # Letter not found
            if board[r][c] != word[w]: return False
            
            # Mark as having read the cell during the search
            # (To ensure that a cell is read only once during a word search)
            board[r][c] = None
            
            # Search the four possible paths
            found = search(r, c-1, w+1) or\
                    search(r-1, c, w+1) or\
                    search(r, c+1, w+1) or\
                    search(r+1, c, w+1)
            
            # "Unmark" the cell while backtracking
            board[r][c] = word[w]
            
            return found
            
        # The search for the word begins by searching for its first letter, 
        # which, in turn, is searched for in the board sequentially (row-major order).
        for r in range(rows):
            for c in range(cols):
                found = search(r, c, 0)
                if found: return True        
        return False
