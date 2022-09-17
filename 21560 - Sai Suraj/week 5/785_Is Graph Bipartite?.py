class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        color=[-1]*len(graph)
        q = deque()
        for i in range(len(graph)):
            if color[i]==-1:
                color[i] = 0
                q.append(i)
                while(q):
                    u = q.popleft()
                    for node in graph[u]:
                        if color[node] ==-1:
                            color[node]=1-color[u]
                            q.append(node)
                        elif color[node]==color[u]:
                            return False
                        
        return True
