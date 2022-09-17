//     One of the approaches using DFS
//     public int findCircleNum(int[][] isConnected) {
//         int count = 0;
//         int n = isConnected.length;
//         boolean[] visited = new boolean[n];
                
//         for(int i=0; i<n; i++) {
//             if(visited[i] == false) {
//                 visited[i] = true;
//                 count++;
//                 dfs(isConnected, visited, i);
//             }
//         }
//         return count;
//     }
    
//     public void dfs(int[][] M, boolean[] visited, int i) {
//         for(int j=0; j<M.length; j++) {
//             if(!visited[j] && M[i][j] == 1) {
//                 visited[j] = true;
//                 dfs(M, visited, j);
//             }
//         }
//     }
    
// Other approach using Union-Find Operation
class Solution {
    class UnionFind {
        int count = 0;
        int[] parent, rank;
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int node) {
        	while (node != parent[node]) {
                parent[node] = parent[parent[node]]; 
                node = parent[node];
            }
            return node;
        }
        
        public void union(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2) return;
            if (rank[root2] > rank[root1]) {
                parent[root1] = root2;
            }
            else {
                parent[root2] = root1;
                if (rank[root1] == rank[root2]) {
                    rank[root1]++;
                }
            }
            count--;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.getCount();
    }
}
