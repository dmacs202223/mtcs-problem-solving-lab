class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:        
        i, j = 0, 0
        result = []        
        intersection = lambda f, s: f[0] <= s[1] and s[0] <= f[1]        
        while i < len(firstList) and j < len(secondList):
            f, s = firstList[i], secondList[j]
            if intersection(f, s):
                result.append([max(f[0], s[0]), min(f[1], s[1])])
            if f[1] <= s[1]:
                i += 1
            else:
                j += 1                
        return result
