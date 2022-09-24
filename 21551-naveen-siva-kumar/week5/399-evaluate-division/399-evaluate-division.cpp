class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        //Floyd warshall method
        
        int n = values.size();
        unordered_map<string, unordered_map<string, double>> adj;
        
        vector<double> answer;
        
        for(int i=0;i<equations.size();i++){
            
            adj[equations[i][0]][equations[i][1]] = values[i];
            adj[equations[i][1]][equations[i][0]] = 1/values[i];
            adj[equations[i][1]][equations[i][1]] = 1.0;
            adj[equations[i][0]][equations[i][0]] = 1.0;
            
        }
        
        
        for (auto &x : adj) 
            for (auto &y : adj[x.first])
                for (auto &z : adj[x.first])
                    adj[y.first][z.first] = adj[y.first][x.first] * adj[x.first][z.first];
        
        string first,second;
        for (auto &Q : queries) {
            first = Q[0];
            second = Q[1];
            if (adj.find(first) != adj.end() &&adj[first].find(second) != adj[first].end())
                answer.push_back(adj[first][second]);
            else 
                answer.push_back(-1.0);
        }
        
        return answer;
    }
};