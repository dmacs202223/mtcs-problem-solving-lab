class DSU:
    def __init__(self):
        self.par = [i for i in range(1001)]
        self.rank = [0] * 1001

    def find(self, x):
        if self.par[x] != x:
            self.par[x] = self.find(self.par[x])
        return self.par[x]

    def union(self, x, y):
        xr, yr = self.find(x), self.find(y)
        if xr == yr:
            return False
        elif self.rank[xr] < self.rank[yr]:
            self.par[xr] = yr
        elif self.rank[xr] > self.rank[yr]:
            self.par[yr] = xr
        else:
            self.par[yr] = xr
            self.rank[xr] += 1
        return True
    
class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        dsu = DSU()
        for edge in edges:
            if not dsu.union(*edge):
                return edge
