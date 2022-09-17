class UF:
    def __init__(self,n):
        self.par = [i for i in range(n)]
        self.rank = [0]*n
        
    def union(self,a,b):
        apar = self.find(a)
        bpar = self.find(b)
        if apar==bpar:
            return
        if self.rank[apar]>self.rank[bpar]:
            self.par[bpar] = apar
        elif self.rank[bpar]>self.rank[apar]:
            self.par[apar] = bpar
        else:
            self.par[bpar] = apar
            self.rank[apar]+=1
    
    def find(self,n):
        if self.par[n]==n:
            return n
        self.par[n] = self.find(self.par[n])
        return self.par[n]
    
    def conn(self,n):
        s = set()
        for i in range(n):
            s.add(self.find(i))
        return len(s)
    
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        if not n:
            return 0
        uf = UF(n)
        for i in range(n):
            for j in range(i,n):
                if isConnected[i][j]:
                    uf.union(i,j)
        return uf.conn(n)
