class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        for (int[] e : edges)
            if (find(e[0]) == find(e[1])) 
                return e;
            else 
                union(e[0],e[1]);
        return edges[-1];
    }
    
    public int find(int x) {
        if (x != parent[x]) 
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }
}
