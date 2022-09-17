class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        int n = equations.size();
        
        //unordered_map<string,unordered_map<string,double>> cost;
        unordered_map<string, int> str2idx;

        int c = 0;
        for(int i = 0;i < n;i++){
            if (str2idx.find(equations[i][0]) == str2idx.end())
                str2idx[equations[i][0]] = c++;
             if (str2idx.find(equations[i][1]) == str2idx.end())
                str2idx[equations[i][1]] = c++;
        }
        
        int n1 = str2idx.size();
        vector<vector<double>> cost(n1, vector<double>(n1, -1));
        for(int i = 0;i < n;i++){
                int x = str2idx[equations[i][0]];
                int y = str2idx[equations[i][1]];
                cost[x][y] = values[i];
                cost[y][x] = 1/values[i];
                cost[x][x] = 1;
                cost[y][y] = 1;
            
        }
        
       /* for(int i = 0;i < n1;i++){
            for(int j = 0;j < n1;j++){
              if(cost[map[i]][map[j]] == 0){
                  if(cost[map[j]][map[i]] != 0)
                      cost[map[i]][map[j]] = 1/cost[map[j]][map[i]];
                  else
                    for(int k = 0;k < n1;k++){
                        if(cost[map[i]][map[k]] != 0 && cost[map[k]][map[j]] != 0)
                            cost[map[i]][map[j]] = cost[map[i]][map[k]] * cost[map[k]][map[j]];
                    }
                }
            }
        }*/
        
       for (int k = 0; k < n1; k++)
            for (int i = 0; i < n1; i++)
            {
                 for (int j = 0; j < n1; j++)
                {
                    if (cost[i][k] == -1 || cost[k][j] == -1)
                         continue;
                      if (cost[i][j] == -1)
                          cost[i][j] = cost[i][k] * cost[k][j];
                     else
                            cost[i][j] = min(cost[i][j], cost[i][k] * cost[k][j]);
                }
            }
            
        int n2 = queries.size();
        vector<double> ans;
        
        for(int j = 0;j < n2;j++){
        if (str2idx.find(queries[j][0]) == str2idx.end() || str2idx.find(queries[j][1]) == str2idx.end())
        {
            ans.push_back(-1);
            continue;
        }
        else{  
                int x = str2idx[queries[j][0]];
                int y = str2idx[queries[j][1]];
                if(cost[x][y] == -1){
                    if(cost[y][x] != -1){
                        ans.push_back(1/cost[y][x]);
                    }
                    else{
                    ans.push_back(-1);
                    }
                }
                else
                    ans.push_back(cost[x][y]);
          }
        }
        return ans;
    }
};