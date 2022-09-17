class Solution {
    private int[] parent;
    
    public int find(int m)
    {
        if(parent[m]==m)
            return m;
        return parent[m]=find(parent[m]);
    }
    
    public int[] findRedundantConnection(int[][] edges) 
    {
        parent = new int[edges.length+1];
        
        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }
        
        for(int j=0; j<edges.length;j++) {
            int m = find(edges[j][0]);
            int n = find(edges[j][1]);
            
            if(m == n) {
                return edges[j];
            }
            parent[n]= m;
        }   
        return new int[]{-1,-1};
    }
}