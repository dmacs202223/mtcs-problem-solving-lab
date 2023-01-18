class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        def countLessorEqual(x):
            cnt = 0
            c =len(matrix[0])-1
            for r in range(len(matrix)):
                while c >= 0 and matrix[r][c] > x: c -= 1 
                cnt += (c + 1)
            return cnt
        
        l,r = matrix[0][0],matrix[-1][-1]
        ans = -1
        while(l<=r):
            m = (l+r)//2
            if countLessorEqual(m) >= k:
                ans = m
                r = m-1
            else:
                l  =m+1
            
        return ans
