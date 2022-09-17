class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        graph = defaultdict(list)        
        result = []
        
        for (a, b), v in zip(equations, values):
            graph[a].append((b, v))
            graph[b].append((a, 1/v))
                                
        def dfs(start, end, product):
            visited.add(start)
            if start == end: 
                return product                            
            for nbr, val in graph[start]:
                if nbr not in visited:
                    ans = dfs(nbr, end, product * val)
                    if ans != -1: return ans                
            return -1
                
        for num, den in queries:
            if num not in graph or den not in graph:
                result.append(-1.0)
            elif num == den:
                result.append(1.0)
            else:
                visited = set()
                result.append(dfs(num, den, 1))
        
        return result
