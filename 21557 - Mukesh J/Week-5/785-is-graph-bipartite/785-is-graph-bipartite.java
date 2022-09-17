class Solution {
    public boolean bfs(int index, int[][] graph, int[] state)
    {
        Queue<Integer> adjacent = new LinkedList<>();
        adjacent.offer(index);
        state[index]=0;
        int node;
        while(!adjacent.isEmpty())
        {
            node = adjacent.poll();
            for(int j=0;j<graph[node].length;j++)
            {
                if(state[graph[node][j]]==-1)
                {
                    adjacent.offer(graph[node][j]);
                    state[graph[node][j]] = 1- state[node];
                }
                else if(state[node]==state[graph[node][j]])
                    return false;
            }
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] state = new int[graph.length];
        Arrays.fill(state,-1);
        for(int i=0;i<graph.length;i++)
        {
            if(state[i]==-1)
                if(bfs(i,graph,state)==false)
                    return false;
        }
        return true;
    }
}