class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> pre_req = new HashMap<>();
        List<Boolean> result = new ArrayList<>();
        int [] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0 ; i < numCourses; i++) {
            pre_req.put(i, new HashSet<>());
            graph.put(i, new HashSet<>());
        }
        
        for(int [] arr : prerequisites) {
            if(!graph.containsKey(arr[0]))
                graph.put(arr[0], new HashSet<Integer>());
            graph.get(arr[0]).add(arr[1]);
            indegree[arr[1]] += 1;
        }
        
        for(int i=0;i<numCourses; i++) {
            if(indegree[i]==0)
                q.add(i);
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            HashSet <Integer> set = graph.get(node);
            for(int neig : set) {
                pre_req.get(neig).add(node);
                pre_req.get(neig).addAll(pre_req.get(node));
                indegree[neig]--;
                if(indegree[neig]==0)
                    q.add(neig);
            }
        }
//         while (!q.isEmpty()) {
//             int node = q.poll();            
//             Set<Integer> set = graph.get(node);
//             for (int next : set) {
//                 pre_req.get(next).add(node);
//                 pre_req.get(next).addAll(pre_req.get(node));
//                 indegree[next]--;
//                 if (indegree[next] == 0) {
//                     q.offer(next);
//                 }
//             }
//         }
        
        for(int [] qry : queries) {
            if(pre_req.get(qry[1]).contains(qry[0]))
                result.add(true);
            else
                result.add(false);
        }
        
        return result;
    }
}
