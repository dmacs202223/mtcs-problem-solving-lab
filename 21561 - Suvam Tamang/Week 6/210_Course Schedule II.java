class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }
        
        for(int[] pre : prerequisites) {
            int curCourse = pre[0], preCourse = pre[1];
            graph.get(preCourse).add(curCourse);  
            inDegree.put(curCourse, inDegree.get(curCourse) + 1); 
        }

        int[] res = new int[numCourses];
        int help = 0;
        
        while(!inDegree.isEmpty()) {
            boolean flag = false;   
            for(int key : inDegree.keySet()) {  
                if(inDegree.get(key) == 0) {
                    res[help ++] = key;
                    List<Integer> children = graph.get(key);  
                    for(int child : children) 
                        inDegree.put(child, inDegree.get(child) - 1);
                    inDegree.remove(key);      
                    flag = true;
                    break;
                }
            }
            if(!flag)  // it means there is a cycle
                return new int[0];
        }
        return res;
    }
}
