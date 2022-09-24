class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        coursePrereqs = { i: set() for i in range(numCourses) }
        prereqFor = { i: set() for i in range(numCourses) }
        for pre, course in prerequisites:
            coursePrereqs[course].add(pre)
            coursePrereqs[course].update(coursePrereqs[pre])
            prereqFor[pre].add(course)
            prereqFor[pre].update(prereqFor[course])
        answer = []
        for pre, course in queries:
            if pre in coursePrereqs[course] or course in prereqFor[pre]:
                answer.append(True)
            else:
                answer.append(False)
        return answer
