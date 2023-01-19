class Solution {
public:
    
    bool addEdge(int u, int v, list<int> adj_list[])
    {
        list<int>::iterator i;
        for(i = adj_list[v].begin();i != adj_list[v].end();++i)
            if(*i == u)
                return true;
        adj_list[u].push_back(v);
        return false;
    }
    
    
    vector<int> topsort(int V, list<int> adj_list[]){
        vector<int> in_degree(V, 0);
        vector<int> res,res1;
        
        for(int i = 0;i < V;i++){
            list<int>::iterator j;
            for(j = adj_list[i].begin();j != adj_list[i].end();j++)
                in_degree[*j]++;
        }
        queue<int> q;
        for(int i = 0;i < V;i++){
            if(in_degree[i] == 0)
                q.push(i);
        }
        int visited = 0;
        while(!q.empty()){
            int u = q.front();
            q.pop();
            res.push_back(u);
            
            list<int>::iterator itr;
            for(itr = adj_list[u].begin();itr != adj_list[u].end();itr++){
                if(--in_degree[*itr] == 0)
                    q.push(*itr);
            }
            ++visited;
        }
        
        if(visited != V)
            return res1;
        
        return res;
    }
    
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
         int n = prerequisites.size();
         list<int> adj_list[numCourses];
         bool cycle;
         vector<int> res;
        for(int i = 0;i < n;i++){
             cycle = addEdge(prerequisites[i][1], prerequisites[i][0], adj_list);
             if(cycle)
                 return res;
        }
         return topsort(numCourses, adj_list);
    }
};