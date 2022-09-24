class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1)
            return -1;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
    
        for(int i=0;i<n;i++)
            graph.put(i, new ArrayList<Integer>());
        
        for(int[] row:connections){
            graph.get(row[0]).add(row[1]);
            graph.get(row[1]).add(row[0]);
        }
        
        int result=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,graph,visited);
                result++;
            }
        }
        return result-1;
    }
    
    public void dfs(int i,Map<Integer,List<Integer>> graph,boolean[] visited){
        visited[i]=true;
        
        for(int el:graph.get(i)){
            if(!visited[el])
                dfs(el,graph,visited);
        }
    }
}
