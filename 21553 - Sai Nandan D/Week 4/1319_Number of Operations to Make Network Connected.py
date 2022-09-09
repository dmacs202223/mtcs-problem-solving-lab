# Approach 1: DFS

class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if len(connections) < n-1: return -1
        
        paths = [[] for _ in range(n)]        
        visited = [False]*n
        
        for i, j in connections:
            paths[i].append(j)
            paths[j].append(i)
            
        def dfs(root):            
            for p in paths[root]:
                if not visited[p]:
                    visited[p] = True
                    dfs(p)
                
        result = 0
        for v in range(n):
            if not visited[v]:
                visited[v] = True
                dfs(v)
                result += 1
                
        return result - 1


# Approach 2: Union-Find

class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if len(connections) < n-1: return -1
        
        parent = [i for i in range(n)]
        rank = [0] * n
        self.components = n
        
        def find(a):
            if parent[a] != a:
                parent[a] = find(parent[a])
            return parent[a]
        
        def union(a, b):                        
            x = find(a)
            y = find(b)
            
            if x != y:
                if rank[x] > rank[y]:
                    parent[y] = x                    
                elif rank[x] < rank[y]:
                    parent[x] = y
                else:
                    parent[y] = x
                    rank[x] += 1
                self.components -= 1
                    
        for a, b in connections:
            union(a, b)
            
        return self.components - 1
