class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        starts = sorted([(start, i) for i, (start, end) in enumerate(intervals)]) + [(float('inf'), -1)]        
        return [starts[bisect.bisect(starts, (end,))][1] for start, end in intervals]
