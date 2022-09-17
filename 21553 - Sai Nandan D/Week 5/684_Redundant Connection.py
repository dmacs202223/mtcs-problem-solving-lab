class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
                
        parent = [i for i in range(n)]
        rank = [0] * n
        extra_edges = []
        
        internal_name = lambda x: x-1
        external_name = lambda x: x+1
        
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
                    
            else:
                extra_edges.append([external_name(a), external_name(b)])
    
        for u, v in edges:
            union(internal_name(u), internal_name(v))
            
        return extra_edges[-1]
