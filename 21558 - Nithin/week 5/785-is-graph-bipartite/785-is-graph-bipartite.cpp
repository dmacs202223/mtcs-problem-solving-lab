class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        
        vector<int> colors(n, 0);
        
        for(int i = 0;i < n;i++){
            
            if(colors[i] == 0){
                colors[i] = -1;
                queue<int> q;
                q.push(i);
            
                while(!q.empty()){
                    int front = q.front();
                    q.pop();
                    
                    for(int j = 0;j < graph[front].size();j++){
                        if(colors[graph[front][j]] == colors[front])
                            return false;
                        else if(colors[graph[front][j]] == 0){
                            colors[graph[front][j]] = -1*colors[front];
                            q.push(graph[front][j]);
                        }
                        else
                            continue;
                        }
                
                    }
                }
            }
        return true;
    }
};