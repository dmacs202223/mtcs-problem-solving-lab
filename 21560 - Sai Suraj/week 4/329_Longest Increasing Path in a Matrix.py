class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        longest_by_pos={}
        directions=[(1,0),(-1,0),(0,1),(0,-1)]
        row,col = len(matrix),len(matrix[0])
        
        def dfs(pos):
            if pos in longest_by_pos:
                return longest_by_pos[pos]
            
            val=matrix[pos[0]][pos[1]]
            longest=1
            for dir_x,dir_y in directions:
                neighbor_x=dir_x+pos[0]
                neighbor_y=dir_y+pos[1]
                
                if 0<=neighbor_x<row and 0<=neighbor_y<col and matrix[neighbor_x][neighbor_y]>val:
                    longest=max(longest,1+dfs((neighbor_x,neighbor_y)))
            
            longest_by_pos[pos]=longest
            return longest
        
        max_path=1
        for r in range(row):
            for c in range(col):
                max_path=max(max_path,dfs((r,c)))
        return max_path
