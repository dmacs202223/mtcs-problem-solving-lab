class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int globalMax = nums[0],globalMin = nums[0];
        int localMax = nums[0],localMin = nums[0];
        
        int totalSum =nums[0];
        
        for(int i=1;i<nums.size();i++){
            
            totalSum+=nums[i];
            localMax=std::max(nums[i],localMax+nums[i]);
            globalMax = std::max(globalMax,localMax);
            
            localMin = std::min(nums[i],localMin+nums[i]);
            globalMin = std::min(globalMin,localMin);
                
        }
        
        int ans = std::max(globalMax,totalSum-globalMin);
        
        return ans>0 ? ans : globalMax;
    }
};
