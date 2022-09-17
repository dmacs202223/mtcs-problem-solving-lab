class Solution {
    unordered_map<int, int> parent;
    int provinces =0;
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        vector<int> universe;
        for(int i=0;i<isConnected.size();i++){
            universe.push_back(i);
        }
        makeSet(universe);
        provinces=isConnected.size();
        //cout<<provinces;
        for(int i=0;i<isConnected.size();i++){
            for(int j=0;j<isConnected[i].size();j++){
                if(i<=j)
                if(isConnected[i][j] == 1){
                    Union(i,j);
                }
            }
        }
        return provinces;
    }
    
    void makeSet(vector<int> const &universe)
    {
        // create n disjoint sets
        for (int i: universe) {
            parent[i] = i;
        }
    }
    
    int Find(int k)
    {
        
        if (parent[k] == k) {
            return k;
        }
        return Find(parent[k]);
    }
    void Union(int a, int b)
    {
        int x = Find(a);
        int y = Find(b);
        if(parent[x]!=y){
            provinces--;    
        }
        parent[x] = y;
        
    }
};