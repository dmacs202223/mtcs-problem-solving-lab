class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        n=len(prerequisites)
        G,indegree,ans = defaultdict(list),[0]*numCourses,[]
        for nxt,pre in prerequisites:
            G[pre].append(nxt)
            indegree[nxt]+=1
            
        q = deque()
        for i in range(numCourses):
            if indegree[i]==0:
                q.append(i)
        while q:
            cur = q.popleft()
            ans.append(cur)
            for nxt in G[cur]:
                indegree[nxt]-=1
                if indegree[nxt]==0:
                    q.append(nxt)
        return ans if len(ans)==numCourses else []
