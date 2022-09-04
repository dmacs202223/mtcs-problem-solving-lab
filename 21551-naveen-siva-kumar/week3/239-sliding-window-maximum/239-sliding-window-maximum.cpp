/*  this particular code is giving timelimit exceeded */

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int size = nums.size();
        int max = INT_MIN;
        int max_index=0;
        int intMax =INT_MIN;
        vector<int> ans;
        
        
        for(int i=0;i<k;i++){
            if(max<=nums[i]){
                max_index=i;
            }
            else{
                max_index = -1;
            }
            max = std::max(max,nums[i]);
            
        }
        //cout<<max_index<<endl;
        
        ans.push_back(max);
        
        for(int i=1;i<size-k+1;i++){
            if(i<=max_index && i+k-1>=max_index){
                if(max<=nums[i+k-1]){
                    max_index=i+k-1;
                }
                
                max = std::max(max,nums[i+k-1]);
                ans.push_back(max);
            }
            else{
                
                intMax=INT_MIN;
                for(int j=i;j<=k+i-1;j++){
                    if(intMax<=nums[j]){
                        max_index=j;
                    }
                    
                    intMax = std::max(intMax,nums[j]);
            
                } 
                ans.push_back(intMax);
                max=intMax;
            }
            
        }
        
        return ans;
    }
};
