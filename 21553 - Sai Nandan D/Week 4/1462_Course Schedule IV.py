# Approach 1: Floyd-Warshall Algorithm
class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:        
        pre = [[False] * numCourses for _ in range(numCourses)]
        
        for a, b in prerequisites:            
            pre[a][b] = True
                
        for k in range(numCourses):
            for i in range(numCourses):
                for j in range(numCourses):
                    if not pre[i][j]:
                        pre[i][j] = pre[i][k] and pre[k][j]
                        
        return [pre[u][v] for u, v in queries]


# Approach 2: Topological Sort
class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        graph = defaultdict(list)
        in_degree = [0] * numCourses
        pre_reqs = [set() for _ in range(numCourses)]
        
        for pre, course in prerequisites:
            graph[pre].append(course)
            in_degree[course] += 1
            pre_reqs[course].add(pre)
            
        q = deque([course for course, degree in enumerate(in_degree) if degree == 0])        
        while q:
            pre = q.popleft()
            for course in graph[pre]:
                pre_reqs[course] |= pre_reqs[pre]
                in_degree[course] -= 1
                if in_degree[course] == 0:
                    q.append(course)
            
        return [pre in pre_reqs[course] for pre, course in queries]


# Approach 3: Simply set union
class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:                
        pre_course = defaultdict(set)
        course_pre = defaultdict(set)
        
        for p, c in prerequisites:
            pre_course[p].add(c)            
            pre_course[p] |= pre_course[c]
            course_pre[c].add(p)
            course_pre[c] |= course_pre[p]
                                
        return [c in pre_course[p] or p in course_pre[c] for p, c in queries]
