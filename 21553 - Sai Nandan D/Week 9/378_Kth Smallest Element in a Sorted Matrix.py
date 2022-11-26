class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        l, r = matrix[0][0], matrix[-1][-1]
        
        while l < r:
            mid = (l + r) // 2
            if sum(bisect.bisect_right(row, mid) for row in matrix) < k:
                l = mid+1
            else:
                r = mid
        
        return l
