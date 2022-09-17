class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        G = defaultdict(dict)
        for i in range(len(equations)):
            a, b = equations[i][0], equations[i][1]
            G[a][b] = values[i]
            G[b][a] = 1 / values[i]
            
        def bfs(start: int,end: int) -> int:
            q = deque()
            q.append((start,1))
            visited = set()
            while q:
                for _ in range(len(q)):
                    node,res = q.popleft()
                    if node==end:
                        return res
                    visited.add(node)
                    for n in G[node]:
                        if n not in visited:
                            q.append((n,res*G[node][n]))
            return -1.0
        
        res = []
        for a,b in queries:
            if a not in G or b not in G:
                res.append(-1.0)
            else:
                res.append(bfs(a,b))
        
        return res
