//This solution has passed  79/81 test cases    ------------using bfs
//have to use queues to do the same thing and see.



class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        //int colors[] = new int[graph.size()]
        int colors[graph.size()];
        memset( colors, 0, graph.size()*sizeof(int) );
        
        // for(int i=0;i<graph.size();i++){
        //     cout<<colors[i]<<" ";
        // }
        // cout<<endl;

        int color = 0;
        cout<<" graph.size() :"<<graph.size()<<endl;
        for(int i=0;i<graph.size();i++){
            
            if(colors[i]==0){
                for(int k=0;k<graph[i].size();k++){
                    //cout<<"ima ";
                    if(colors[graph[i][k]]==1) {colors[i]=-1;color=-1;break;}
                    if(colors[graph[i][k]]==-1) {colors[i]=1;color=1;break;}
                }
                if(color==0) {colors[i]=1;color=1;}
                
            }
            if(colors[i]==1){
                color=1;
            }
            if(colors[i]==-1){
                color=-1;
            }
            cout<<"color :"<<color<<endl;
            for(int j=0;j<graph[i].size();j++){
                if(color==1){
                    //colors of neighbours should be -1
                    if(colors[graph[i][j]]==-1) continue;
                    if(colors[graph[i][j]]==1){ 
                      return false;
                    }
                    if(colors[graph[i][j]]==0) colors[graph[i][j]] =-1;
                    
                }
                if(color==-1){
                    //colors of neighbours should be -1
                    if(colors[graph[i][j]]==1) continue;
                    if(colors[graph[i][j]]==-1) return false;
                    if(colors[graph[i][j]]==0) colors[graph[i][j]] = 1;
                    
                }
            }
        }
        return true;
    
           
    }
};
