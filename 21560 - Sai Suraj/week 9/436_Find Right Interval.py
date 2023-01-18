class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        max_start, max_end = [], []
        result = [-1] * len(intervals)
        for i, (start, end) in enumerate(intervals):
            heappush(max_start, (-start, i))
            heappush(max_end, (-end, i))
        while max_end:
            end, i = heappop(max_end)
            end *= -1
            index = -1
            while max_start[0][0] * -1 >= end:
                start, index = heappop(max_start)
            heappush(max_start, (start, index))                
            result[i] = index
            
        return result
    
