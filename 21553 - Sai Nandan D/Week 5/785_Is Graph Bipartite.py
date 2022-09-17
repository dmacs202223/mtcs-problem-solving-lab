class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        colored = {i : 0 for i in range(n)}
        
        for node in range(n):
            if not colored[node]:
                colored[node] = 1
                q = deque([node])
                while q:
                    cur_node = q.popleft()
                    for nbr in graph[cur_node]:
                        if not colored[nbr]:
                            colored[nbr] = -colored[cur_node]
                            q.append(nbr)
                        elif colored[nbr] == colored[cur_node]:
                            return False                                    
        
        return True
