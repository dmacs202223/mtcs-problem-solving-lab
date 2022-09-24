class Solution {
    public int[] parent;
    public int cycle;
    
    
    public int[] findRedundantConnection(int[][] edges) {
        //using union find in java
        int n = edges.length;
        int universe[] = new int[n+1];
        for(int i=1;i<n+1;i++){
            universe[i]=i;
        }
        makeUniverse(universe);
        
        for(int i=0;i<n;i++){
            union(edges[i][0],edges[i][1],i);
        }
        return edges[cycle];
        
    }
    
    public void makeUniverse(int[] universe){
        this.parent = new int[universe.length];
        //this cycle = new ArrayList<int>();
        for(int i=1;i<universe.length;i++){
            parent[i]=i;
        }
    }
    
    public void union(int node1,int node2,int index){
        
        int x = find(node1);
        int y=find(node2);
        
        if(parent[x]==y){
            //cycle.add(index);
            this.cycle=index;
            return;
        }
        else{
            parent[x]=y;
            return;
        }
    }
    public int find(int node){
        if (parent[node] == node) {
            return node;
        }
        return find(parent[node]);
    }
}