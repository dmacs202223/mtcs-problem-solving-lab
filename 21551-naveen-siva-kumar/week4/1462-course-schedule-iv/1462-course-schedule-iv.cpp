class Solution {
    
    public: vector<vector<int>> dp;
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        unordered_map<int,vector<int>> preReqMap;
        
        dp.resize(numCourses, vector<int>(numCourses, -1)); //this initializes all values to -1 with size numCourses*numCourses
        
        for (int i=0;i<prerequisites.size();i++){
            
            preReqMap[prerequisites[i][1]].push_back(prerequisites[i][0]);
            dp[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        
        bool torf;
        vector<bool> output;
        
        for(int i=0;i<queries.size();i++){
            
            torf = dfs(preReqMap,queries[i][0],queries[i][1]);
            output.push_back(torf);
        }
        
        return output;
    }
    
    public:
    bool dfs(unordered_map<int,vector<int>> &preReqMap,int ispreReq,int course){
        
        if(dp[course][ispreReq]!=-1){
            return dp[course][ispreReq];
        }
        else{
            for(int i=0;i<preReqMap[course].size();i++){
                
                if(preReqMap[course][i]==ispreReq || dfs(preReqMap,ispreReq,preReqMap[course][i])){
                    dp[course][ispreReq] = 1;
                    return true;
                }
                
            }
            dp[course][ispreReq] = 0;
            return false;
        }
        
    }
};