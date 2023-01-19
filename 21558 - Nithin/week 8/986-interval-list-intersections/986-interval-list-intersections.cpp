class Solution {
public:
    void swap(int& x,int& y){
        int temp = x;
        x = y;
        y = temp;
    }
    
    vector<vector<int>> intervalIntersection(vector<vector<int>>& firstList, vector<vector<int>>& secondList){
        vector<vector<int>> inter;
        int m = firstList.size();
        int n = secondList.size();
         
        if(m == 0 || n == 0)
            return inter;
        
        int maxi, mini,i = 0,j = 0;
        
        while(i < m && j < n ){
            vector<int> in;
            maxi = min(firstList[i][1], secondList[j][1]);
            mini = max(firstList[i][0], secondList[j][0]);
            if(mini<=maxi){
                in.push_back(mini);
                in.push_back(maxi);
                inter.push_back(in);
            }
            if(maxi == firstList[i][1])   
                i++;
            else
                j++;
        }
        
        return inter;
            
    }
};