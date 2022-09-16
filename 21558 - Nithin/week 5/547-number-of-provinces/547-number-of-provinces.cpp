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
        for(int i = 0;i < n;i++){
            parent.push_back(i);
            size.push_back(1);
        }
    }
    
    int find_set(int v){
        if(parent[v] == v)
            return v;
        return parent[v] =  find_set(parent[v]);
        
    }
    
    void union_sets(int a,int b){
        a = find_set(a);
        b = find_set(b);
        if(a != b){
            if(size[a] < size[b])
                swap(a,b);
            parent[b] = a;
            size[a] += size[b];
        }
    }
    
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        if(n == 1)
            return 1;
        
        make_sets(n);
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i != j && isConnected[i][j] == 1)
                    union_sets(i, j);
            }
        }
        int iso_clusters = 0;
        for(int i = 0;i < n;i++)
            if(parent[i] == i)
                iso_clusters++;
        
        return iso_clusters;
        
        
    }
};