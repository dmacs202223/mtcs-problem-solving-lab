class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colors[] = new int[n];
        
        Queue<Integer> q = new LinkedList<>();
        int qEle;
        
        for (int i = 0; i < n; i++) {
            if(colors[i] == 0) {
                colors[i] = 1;
                q.offer(i);
            }             
            while (!q.isEmpty()) {
                qEle = q.poll();  //for each of the neighbour,traverse through and color again.
                
                for (int neighobour : graph[qEle]) {                       
                    if(colors[neighobour] == 0) {
                        colors[neighobour] = -colors[qEle];
                        q.offer(neighobour);
                    } 
                    else if (colors[qEle] == colors[neighobour]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
