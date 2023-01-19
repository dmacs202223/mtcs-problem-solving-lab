class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = defaultdict(set)
        in_degree = [0] * numCourses
        result = []
        
        for course, pre in prerequisites:
            graph[pre].add(course)
            in_degree[course] += 1
            
        q = deque([course for course, degree in enumerate(in_degree) if degree == 0])
        
        while q:
            pre = q.popleft()
            result.append(pre)
            for course in graph[pre]:
                in_degree[course] -= 1
                if in_degree[course] == 0:
                    q.append(course)
                    
        return result if len(result) == numCourses else []
