class Solution {
public:
    vector<int> parent;
    vector<int> size;
    
    void swap(int &x,int &y){
        int temp = x;
        x = y;
        y = temp;
    }
    
    void make_sets(int n){
        for(int i = 1;i <= n;i++){
            parent.push_back(i);
            size.push_back(1);
        }
    }
    
    int find_set(int v){
        if(parent[v-1] == v)
            return v;
        return parent[v-1] =  find_set(parent[v-1]);
        
    }
    
    void union_sets(int a,int b){
        a = find_set(a);
        b = find_set(b);
        if(a != b){
            if(size[a] < size[b])
                swap(a,b);
            parent[b-1] = a;
            size[a] += size[b];
        }
    }
    
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n = edges.size();
        make_sets(n);
        
        int x,y;
        vector<int> red;
        
        for(int i = 0;i < n;i++){
            x = find_set(edges[i][0]);
            y = find_set(edges[i][1]);
            
            if(x == y){
                if(red.size() != 0){
                    red.pop_back();
                    red.pop_back();
                }
                red.push_back(edges[i][0]);
                red.push_back(edges[i][1]);
            }
            else
                union_sets(edges[i][0], edges[i][1]);
        }
        
        return red;
        
    }
};