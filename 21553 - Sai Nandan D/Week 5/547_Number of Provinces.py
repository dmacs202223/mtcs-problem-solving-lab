class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        self.provinces = n
        
        parent = [i for i in range(n)]
        rank = [0] * n
        
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(a, b):
            x = find(a)
            y = find(b)
            
            if x != y:
                if rank[x] > rank[y]:
                    parent[y] = x
                elif rank[y] > rank[x]:
                    parent[x] = y
                else:
                    parent[y] = x
                    rank[x] += 1
                self.provinces -= 1
                
        for i in range(n):
            for j in range(i+1, n):
                if isConnected[i][j]:
                    union(i, j)
                
        return self.provinces
