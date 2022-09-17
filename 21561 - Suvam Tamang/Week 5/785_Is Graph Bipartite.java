class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        // 0 : Uncolored
        // 1 : Blue
        // -1: Red
        int color = 1;
        for(int i=0; i<graph.length; i++) {
            if(colors[i] == 0 && !dfsValidate(graph, colors, color, i))
                return false;
        }
        return true;
    }
    
    public Boolean dfsValidate(int[][] graph,int[] colors,int color,int node) {
        if(colors[node] != 0)
            return colors[node] == color;
        colors[node] = color;
        for(int next_node : graph[node]) {
            if(!dfsValidate(graph,colors,-color,next_node))
                return false;
        }
        return true;
    }
}
