class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        int ans=0;
        if(connections.size()<n-1)  return -1;
        
        else{
            vector<int> adj[n];   //create the adjecency matrix
            
            for(auto &x: connections) {
                adj[x[0]].push_back(x[1]);
                adj[x[1]].push_back(x[0]);
            }
            
            vector<int> visited(n, 0);
            
            for(int i=0;i<n;i++) {
                if(visited[i]==0) {
                    dfs(adj,visited,i);  //if dfs returns then its a network
                    ans++;
                }
            }
            
        }
        
        return ans-1; 
    }
    
    //traverse through all the nodes in adjacency matrix
    void dfs(vector<int> adj[], vector<int> &visited, int i) {
        visited[i]=1;
        for(auto x: adj[i]) {
            if(visited[x]==0) {
                dfs(adj,visited,x);
            }
        }
    }
};